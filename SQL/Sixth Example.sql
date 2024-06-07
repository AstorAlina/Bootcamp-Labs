#1. List the product id, product name, unit price and category name of all products. Order by category name and within that, by product name. (catagory related)
SELECT products.ProductID, products.ProductName, products.UnitPrice, CategoryName
FROM products
JOIN categories ON products.CategoryID =  categories.CategoryID
ORDER BY ProductName;

#2. List the product id, product name, unit price and supplier name of all products that cost more than $75. Order by product name. (supplier name related)
SELECT products.ProductID, products.ProductName, products.UnitPrice, products.SupplierID, suppliers.CompanyName
FROM products
JOIN suppliers ON products.SupplierID = suppliers.SupplierID WHERE products.UnitPrice > 75
ORDER BY ProductName;

#3. List the product id, product name, unit price, category name, and supplier name of every product. Order by product name.
SELECT products.ProductID, products.ProductName, products.UnitPrice, products.CategoryID, products.SupplierID, suppliers.CompanyName
FROM products
JOIN suppliers ON products.SupplierID = suppliers.SupplierID
ORDER BY ProductName;

#4. What is the product name(s) and categories of the most expensive products? HINT: Find the max price in a subquery and then use that in your more complex query that joins products with categories.
#do in class

#5. List the order id, ship name, ship address, and shipping company name of every order that shipped to Germany.
SELECT orders.OrderID, orders.ShipName, orders.ShipAddress, shippers.CompanyName
FROM orders
JOIN shippers ON orders.ShipVia = shippers.ShipperID
WHERE ShipCountry = 'Germany';

#6. List the order id, order date, ship name, ship address of all orders that ordered "Sasquatch Ale"?'
SELECT orders.OrderID, orders.OrderDate , orders.ShipName, orders.ShipAddress, products.ProductName
FROM orders
JOIN `order details` ON order.OrderID = 
WHERE products.ProductName = 'Sasquatch Ale';
