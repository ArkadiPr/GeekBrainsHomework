BEGIN;

DROP TABLE IF EXISTS items CASCADE;
CREATE TABLE items (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO items (title, price) VALUES
('box', 10),
('sphere', 20),
('maul', 100),
('door', 50),
('camera', 500);

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('Borzenkov Oleg'),
('Antonov Michail'),
('Kolarov Alexander');

DROP TABLE IF EXISTS customers_items CASCADE;
CREATE TABLE customers_items (customer_id bigint, item_id bigint, FOREIGN KEY (customer_id) REFERENCES customers (id), FOREIGN KEY (item_id) REFERENCES items (id));
INSERT INTO customers_items (customer_id, item_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(1, 2),
(3,5),
(2,4),
(2, 2);


COMMIT;