#1. How many suppliers are there? Use a query!
SELECT COUNT(SupplierID)
FROM suppliers;

#2. What is the sum of all the employee's salaries?
SELECT SUM(Salary)
From employees;

#3. What is the price of the cheapest item that Northwind sells?
SELECT MIN(UnitPrice) AS Least_Expensive
FROM Products;

#4. What is the average price of items that Northwind sells?
SELECT AVG(UnitPrice) AS Avg_Price
FROM Products;

#5. What is the price of the most expensive item that Northwind sells?
SELECT MAX(UnitPrice) AS Most_Expensive
FROM Products;

#6. What is the supplier ID of each supplier and the number of items they supply? You can answer this query by only looking at the Products table.
SELECT SUM(UnitsInStock) AS Items_Supplied, SupplierID
FROM products
GROUP BY SupplierID
ORDER BY Items_Supplied;

#7. What is the category ID of each category and the average price of each item in the category? You can answer this query by only looking at the Products table.
SELECT AVG(UnitPrice), CategoryID
FROM products
GROUP BY CategoryID;

#8. For suppliers that provide at least 5 items to Northwind, what is the supplier ID of each supplier and the number of items they supply? You can answer this query by only looking at the Products table.
SELECT COUNT(*) AS Num_Of_Items, SupplierID
FROM products
GROUP BY SupplierID
HAVING Num_Of_Items >= 5;

#9. List the product id, product name, and inventory value (calculated by multiplying unit price by the number of units on hand). Sort the results in descending order by value. If two or more have the same value, order by product name.
SELECT ProductID, ProductName, UnitPrice, UnitsInStock,
UnitPrice * UnitsInStock AS Inventory_Value
FROM products
ORDER BY Inventory_Value DESC;

