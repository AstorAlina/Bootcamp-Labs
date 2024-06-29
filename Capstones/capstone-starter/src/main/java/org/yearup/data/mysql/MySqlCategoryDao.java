package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao {
    public MySqlCategoryDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        // get all categories
        String query = "{CALL GetAllCategories}";

        List<Category> allCategories = new ArrayList<>();

        try (Connection conn = this.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                Category category = mapRow(resultSet);
                allCategories.add(category);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allCategories;
    }

    @Override
    public Category getById(int categoryId) {
        // get category by id
        String query = "{CALL GetCategoryById(?)}";
        Category category = new Category();

        try (Connection conn = this.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, categoryId);

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                category = mapRow(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return category;
    }

//    @Override
//    public Category create(Category category) {
//        // create a new category
//        String query = "{CALL CreateCategory(?, ?)}";
//        Category newCategory = new Category();
//
//        try (Connection conn = this.getConnection();
//             CallableStatement cs = conn.prepareCall(query)) {
//            cs.setString(1, newCategory.getName());
//            cs.setString(2, newCategory.getDescription());
//
//            ResultSet resultSet = cs.executeQuery();
//
////            resultSet.next();
//            return mapRow(resultSet);
//
//
//
//
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return category;
//    }

    @Override
    public Category create(Category category) {
        // create a new category
        String query = "{CALL CreateCategory(?, ?)}";
        Category newCategory = new Category();

        try (Connection conn = this.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {
            cs.setString(1, category.getName());
            cs.setString(2, category.getDescription());

            ResultSet resultSet = cs.executeQuery();

            if (resultSet.next()) {
                newCategory = mapRow(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle exception properly
        }
        return newCategory;
    }


    @Override
    public void update(int categoryId, Category category) {
        // update category
        String query = "{CALL UpdateCategory(?, ?, ?)}";

        try (Connection conn = this.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, categoryId);
            cs.setString(2, category.getName());
            cs.setString(3, category.getDescription());

            ResultSet resultSet = cs.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int categoryId) {
        // delete category
        String query = "{CALL DeleteCategory(?)}";

        try (Connection conn = this.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, categoryId);

            ResultSet resultSet = cs.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Category mapRow(ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
