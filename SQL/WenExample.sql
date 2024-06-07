#scalar value
SELECT AVG(UnitPrice)
FROM products;

#Which products in the product table are above average price?
SELECT *
FROM Products
WHERE UnitPrice > (SELECT AVG(UnitPrice) FROM Products);
#rules - sub query must run inside by itself(if you highlight it should run)
#need to give back single value

SELECT products.ProductName, categories.CategoryName
FROM products
JOIN categories ON products.CategoryID = categories.CategoryID
WHERE products.UnitPrice = (SELECT MAX(UnitPrice) FROM products);