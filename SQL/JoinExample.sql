SELECT orders.OrderID, employees.EmployeeID, employees.FirstName, employees.LastName, customers.CompanyName
FROM Orders
JOIN employees ON Orders.EmployeeID = Employees.EmployeeId
JOIN customers ON Orders.CustomerID = Customers.CustomerId;
#combine orders and employees orders table on left column
#Can have 2

SELECT ORDERS.OrderID, ORDERS.CustomerID, Customers.CustomerID
From customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerId
WHERE Orders.OrderID IS NULL;
