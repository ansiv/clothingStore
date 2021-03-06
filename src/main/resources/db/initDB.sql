DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS purchases;

CREATE TABLE customers(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
customer_name VARCHAR(100) NOT NULL
)ENGINE = InnoDB;

CREATE TABLE products(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
product_name VARCHAR(100) NOT NULL ,
product_price DOUBLE NOT NULL
)ENGINE = InnoDB;

CREATE TABLE purchases(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
customer_id INT NOT NULL ,
product_id INT NOT NULL ,
date_of_purchase DATETIME NOT NULL,
quantity INT NOT NULL,
purchase_price INT NOT NULL,
FOREIGN KEY(customer_id) REFERENCES customers (id),
FOREIGN KEY(product_id) REFERENCES products (id)
)ENGINE = InnoDB;
