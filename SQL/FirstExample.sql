SELECT *
FROM northwind.products
WHERE UnitsInStock < 30;

SELECT *
FROM products
WHERE CategoryID <> 1;

#Compound Where clauses AND/OR
#I want products that are dairy products or beverages
SELECT *
FROM products
WHERE CatagoryID = 1 OR CategoryID = 4;

#If you have a list of options
#I want all products that are beverages, dairy produxcts or product
SELECT *
FROM products
WHERE CategoryID IN (1, 4, 7);

SELECT *
FROM orders
WHERE ShipCountry = 'France';

SELECT *
From orders
WHERE ShippedDate > '1996-09-01';

#I want orders shipped between sep and oct of 1996
SELECT *
FROM orders
WHERE ShippedDate BETWEEN '1996-09-01' AND '1996-10-01';

#I want orders where shipping name starts with R
SELECT *
FROM orders
WHERE ShipName LIKE 'R%';

#I want orders where ship name contains the word super
SELECT *
FROM orders
WHERE ShipName LIKE '%SUPER%';

#I want to order things
SELECT *
FROM orders
WHERE Freight > 20
ORDER BY ShipCountry DESC;

SELECT *
FROM Customers
WHERE Region IS NULL;

SELECT DISTINCT (Country)
FROM customers
ORDER BY Country;