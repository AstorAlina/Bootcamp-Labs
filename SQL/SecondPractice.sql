SELECT *
FROM northwind.products;

SELECT ProductID, ProductName, UnitPrice
FROM northwind.products;

SELECT ProductID, ProductName, UnitPrice
FROM northwind.products
ORDER BY UnitPrice DESC;

SELECT ProductID, ProductName, UnitPrice
FROM northwind.products
WHERE products.UnitPrice <= 7.50;

SELECT ProductID, ProductName, UnitsInStock, UnitPrice
FROM products
WHERE products.UnitsInStock >= 100
ORDER BY UnitPrice DESC, ProductName;

SELECT ProductID, ProductName, UnitsInStock, UnitsOnOrder
FROM northwind.products
WHERE UnitsInStock = 0 AND UnitsOnOrder >= 1
ORDER BY ProductName;

SELECT * FROM northwind.categories;

SELECT *
FROM northwind.categories
WHERE CategoryID = 8;

SELECT * 
FROM northwind.products
WHERE CategoryID = 8;

SELECT FirstName, LastName
FROM northwind.employees;

SELECT * 
FROM northwind.employees
WHERE Title LIKE '%Manager%';

SELECT DISTINCT Title
FROM employees;

SELECT * 
FROM employees
WHERE Salary BETWEEN 2000 AND 2500;

SELECT * FROM northwind.suppliers;

SELECT *
FROM northwind.products
WHERE SupplierID = '4';
