DELETE
FROM customers;
DELETE
FROM products;
DELETE
FROM purchases;

ALTER TABLE customers AUTO_INCREMENT = 1;
ALTER TABLE products AUTO_INCREMENT = 1;

INSERT INTO customers (customer_name)
VALUES ('Иванов Иван Иванович'),
       ('Петров Петр Петрович'),
       ('Сидоров Сидор Сидорович');

INSERT INTO products (product_name, product_price)
VALUES ('штаны',50.0),
       ('трусы', 10.0),
       ('носки', 5.0);
INSERT INTo purchases(customer_id, product_id, date_of_purchase, quantity, purchase_price)
VALUES (1,1,'2018-12-03 12:05:01',2,50.0),
       (1,2,'2018-12-03 12:05:01',3,10.0),
       (3,3,'2018-12-05 09:44:00',4,5.0),
       (2,2,'2018-12-04 10:00:00',2,10.0);




