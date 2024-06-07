#What is the product name(s) of the most expensive products? HINT: Find the max price in a subquery and then use that value to find products whose price equals that value.
SELECT products.ProductName
FROM products
WHERE products.UnitPrice = (SELECT MAX(UnitPrice) FROM products);

#What is the order id, shipping name and shipping address of all orders shipped via "Federal Shipping"? HINT: Find the shipper id of "Federal Shipping" in a subquery and then use that value to find the orders that used that shipper.
SELECT orders.OrderID, orders.ShipName, orders.ShipAddress, orders.ShipVia
FROM orders
WHERE ShipVia = (SELECT shippers.ShipperID FROM shippers WHERE CompanyName = 'Federal Shipping');


#What are the order ids of the orders that ordered "Sasquatch Ale"? HINT: Find the product id of "Sasquatch Ale" in a subquery and then use that value to find the matching orders from the order details table. Because the `order details table has a space in its name, you will need to surround it with back ticks in the FROM clause.
#SELECT products.ProductID FROM products WHERE ProductID = 34
SELECT `order details`.OrderID
FROM `order details`
WHERE ProductID = (SELECT ProductID FROM products WHERE ProductName = 'Sasquatch Ale');


#What is the name of the employee that sold order 10266?
SELECT employees.FirstName, employees.LastName
FROM employees
WHERE EmployeeID = (SELECT Orders.EmployeeID FROM orders WHERE OrderID = 10266);

#What is the name of the customer that bought order 10266?
SELECT customers.ContactName
FROM customers
WHERE customers.CustomerID = (SELECT orders.CustomerID FROM orders WHERE OrderID = 10266);