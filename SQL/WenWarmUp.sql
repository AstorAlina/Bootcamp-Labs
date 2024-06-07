Warmup Question 1: List Orders with Customer Names

Question:
Write a SQL query to list the OrderID, OrderDate, and CompanyName of the customer who placed each order. Use an inner join to combine the Orders and Customers tables.

Warmup Question 2: List Products with Supplier Names

Question:
Write a SQL query to list the ProductName and the CompanyName of the supplier for each product. Use an inner join to combine the Products and Suppliers tables.

Warmup Question 3: List Employees with Orders Over $1000

Question:
Write a SQL query to list the EmployeeID, LastName, and OrderID for orders where the total order amount (Freight) is greater than $1000. 





Warmup Question 1: List Orders with Customer Names
SELECT *
FROM orders
JOIN customers ON Orders.CustomerID = customers.CustomerID;

#Question 2: Write a SQL query to list the OrderID, OrderDate, and CompanyName of the customer who placed each order. Use an inner join to combine the Orders and Customers tables.
SELECT orders.OrderID, orders.OrderDate, CompanyName
From orders
JOIN customers ON Orders.CustomerID = customers.CustomerID;

#Warmup Question 2: List Products with Supplier Names
SELECT *
FROM suppliers
JOIN suppliers ON products.SupplierID = suppliers. SupplierID;

#Question: Write a SQL query to list the ProductName and the CompanyName of the supplier for each product. Use an inner join to combine the Products and Suppliers tables.
SELECT ProductName, CompanyName
FROM products
JOIN suppliers ON products.SupplierID = suppliers. SupplierID;

# Warmup Question 3: List Employees with Orders Over $1000
SELECT *
FROM orders
JOIN `order details` ON `order details`.EmployeeID = employees. EmployeeID;


#Question:Write a SQL query to list the EmployeeID, LastName, and OrderID for orders where the total order amount (Freight) is greater than $1000. 
SELECT EmployeeID, 
FROM orders
INNER JOIN `order details` ON `order details`.EmployeeID = employees. EmployeeID;