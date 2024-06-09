#DEALERSHIPS
CREATE TABLE dealerships (
dealership_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50),
address VARCHAR(50),
phone VARCHAR(12)
);

#VEHICLES
CREATE TABLE vehicles (
VIN VARCHAR(17) PRIMARY KEY, 
make VARCHAR(50),
model VARCHAR(50),
year INT,
SOLD BIT
);

#INVENTORY
CREATE TABLE inventory (
dealership_id INT,
VIN VARCHAR(17),
FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

#SALES CONTRACTS
CREATE TABLE sales_contracts (
id INT AUTO_INCREMENT PRIMARY KEY,
VIN VARCHAR(17),
sale_price DECIMAL(10, 2),
sale_date DATE,
customer_id INT,
FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

CREATE TABLE lease_contracts (
id INT AUTO_INCREMENT PRIMARY KEY,
VIN VARCHAR(17),
lease_price DECIMAL(10, 2),
lease_start_date DATE,
lease_end_date DATE,
customer_id INT,
FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

INSERT INTO dealerships (name, address, phone) VALUES
('AutoNation', '123 Main St, Los Angeles, CA', '310-555-1234'),
('CarMax', '456 Elm St, San Francisco, CA', '415-555-5678'),
('Penske Automotive', '789 Oak St, Houston, TX', '713-555-9012'),
('DriveTime', '101 Maple St, Phoenix, AZ', '602-555-3456'),
('Lithia Motors', '202 Pine St, Medford, OR', '541-555-7890');

INSERT INTO vehicles (VIN, make, model, year, SOLD) VALUES
('1HGCM82633A004352', 'Honda', 'Accord', 2020, 0),
('2FTRX18W1XCA12345', 'Ford', 'F-150', 2019, 1),
('3VWFE21C04M000123', 'Volkswagen', 'Jetta', 2021, 0),
('JH4KA9650MC000456', 'Acura', 'Legend', 2022, 1),
('1GCHK29U84E123456', 'Chevrolet', 'Silverado', 2023, 0);

INSERT INTO inventory (dealership_id, VIN) VALUES
(1, '1HGCM82633A004352'),
(1, '2FTRX18W1XCA12345'),
(2, '3VWFE21C04M000123'),
(2, 'JH4KA9650MC000456'),
(3, '1GCHK29U84E123456');

INSERT INTO sales_contracts (VIN, sale_price, sale_date, customer_id) VALUES
('2FTRX18W1XCA12345', 25000.00, '2023-05-15', 101),
('JH4KA9650MC000456', 35000.00, '2023-06-10', 102);


INSERT INTO lease_contracts (VIN, lease_price, lease_start_date, lease_end_date, customer_id) VALUES
('1HGCM82633A004352', 300.00, '2023-01-01', '2025-01-01', 201),
('3VWFE21C04M000123', 250.00, '2023-02-01', '2026-02-01', 202);

#Tests
SELECT * FROM dealerships;

SELECT vehicles.VIN, vehicles.make, vehicles.model, vehicles.year, vehicles.SOLD, inventory.dealership_id
FROM vehicles
JOIN inventory ON vehicles.VIN = inventory.VIN
WHERE inventory.dealership_id = 1;

SELECT VIN, make, model, year, SOLD
FROM vehicles
WHERE VIN = '1HGCM82633A004352';

SELECT DISTINCT dealerships.dealership_id, dealerships.name, vehicles.make
FROM dealerships
JOIN inventory ON dealerships.dealership_id = inventory.dealership_id
JOIN vehicles ON inventory.VIN = vehicles.VIN
WHERE vehicles.make = 'Acura';

SELECT dealerships.dealership_id, dealerships.name, vehicles.VIN, vehicles.make, vehicles.model, vehicles.year, sales_contracts.sale_price, sales_contracts.sale_date, sales_contracts.customer_id
FROM dealerships
JOIN inventory ON dealerships.dealership_id = inventory.dealership_id
JOIN vehicles ON inventory.VIN = vehicles.VIN
JOIN sales_contracts ON vehicles.VIN = sales_contracts.VIN
WHERE dealerships.dealership_id = 1
AND sales_contracts.sale_date BETWEEN '2023-01-01' AND '2023-12-31';


