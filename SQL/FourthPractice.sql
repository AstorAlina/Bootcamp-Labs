#Aggregate Functions (aggregate means to bring together to one)
#SUM, COUNT, AVG, MIN, MAX

SELECT * FROM Products;


#How much inventory do we have on hand?
SELECT SUM(UnitsInStock) AS Inventory_On_Hand
FROM Products;

#Average price of products
SELECT AVG(UnitPrice) AS Avg_Price
FROM Products;

#What is the price of the most exp product
SELECT MAX(UnitPrice) AS Most_Expensive
FROM Products;

#What is the price of least exp product
SELECT MIN(UnitPrice) AS Least_Expensive
FROM Products;

#How many products do we sell that are beverages?
SELECT COUNT(ProductID)
FROM products
WHERE CategoryID = 1;

#A breakdown of avg freight by country
SELECT AVG(Freight) AS Avg_Freight, ShipCountry
FROM Orders
WHERE ShipCountry IN ('UK', 'Germany', 'Belgium', 'Sweden')
GROUP BY ShipCountry
HAVING Avg_Freight > 50
ORDER BY AVG(Freight);

