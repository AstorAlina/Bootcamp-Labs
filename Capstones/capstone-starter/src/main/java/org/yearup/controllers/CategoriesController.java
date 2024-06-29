package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.CategoryDao;
import org.yearup.data.ProductDao;
import org.yearup.models.Category;
import org.yearup.models.Product;

import java.util.List;

// add the annotations to make this a REST controller
@RestController

// add the annotation to make this controller the endpoint for the following url
// http://localhost:8080/categories

@RequestMapping("/categories")

// add annotation to allow cross site origin requests
@CrossOrigin

public class CategoriesController {

    //dont stored procedure for getprodbyid,

    // create an Autowired controller to inject the categoryDao and ProductDao
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ProductDao productDao;


    public CategoriesController(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }

    @GetMapping
    // add the appropriate annotation for a get action
    public List<Category> getAll() {
        // find and return all categories
        return categoryDao.getAllCategories();
    }

    @GetMapping("/{categoryId}") // Note the forward slash before {categoryId}
    public Category getById(@PathVariable int categoryId) {
        // get the category by id
        return categoryDao.getById(categoryId);
    }

    // the url to return all products in category 1 would look like this
    // https://localhost:8080/categories/1/products
    @GetMapping("{categoryId}/products")
    public List<Product> getProductsById(@PathVariable int categoryId) {
        // get a list of product by categoryId
        return productDao.listByCategoryId(categoryId);
    }

    // add annotation to call this method for a POST action
    // add annotation to ensure that only an ADMIN can call this function
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping //check postman for endpoints *****************
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
        // insert the category
        return categoryDao.create(category);
    }

    // add annotation to call this method for a PUT (update) action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function

//    @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/{categoryId}")
//    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
//        // update the category by id
//
//        categoryDao.update(id, category);
//    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{categoryId}")
    public void updateCategory(@PathVariable int categoryId, @RequestBody Category category) {
        // update the category by id
        categoryDao.update(categoryId, category);
    }



    // add annotation to call this method for a DELETE action - the url path must include the categoryId
    // add annotation to ensure that only an ADMIN can call this function
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable int categoryId) {
        // delete the category by id
        categoryDao.delete(categoryId);
    }
}

