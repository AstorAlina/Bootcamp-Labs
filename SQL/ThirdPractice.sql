SELECT * FROM northwind.customers;

SELECT CompanyName, ContactName
FROM customers;

SELECT distinct (COUNTRY)
FROM customers;

SELECT ContactName, Country
FROM customers
WHERE Country = "UK";

SELECT *
FROM orders
WHERE Freight BETWEEN 50 AND 100;  

SELECT *
FROM orders
WHERE OrderDate > '1997-01-01' AND ShipCountry IN ('USA','Canada');

SELECT *
FROM orders
WHERE ShipCountry IN ('France', 'Belgium','Germany');

SELECT *
From products
WHERE UnitPrice BETWEEN 10 AND 20;

SELECT *
From suppliers
ORDER BY Country;

SELECT *
FROM customers
ORDER BY ContactName DESC;

SELECT *
FROM employees;
# varchar, datetime, longblob, mediumtext, float, int, 

SELECT *
From orders
WHERE OrderDate = '1996-07-04';

SELECT * FROM customers WHERE CustomerID = 'VINET';

SELECT * FROM `ORDER DETAILS`