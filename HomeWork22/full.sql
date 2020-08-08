BEGIN;


DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial PRIMARY KEY, name VARCHAR(255),age int);
INSERT INTO users (name,age) VALUES
('Arnold S.',25),
('Silvester S.',41),
('Willis B.',74),
('Jackie C.',32),
('Bruce L.',85),
('Smith W.',14);


DROP TABLE IF EXISTS items CASCADE;
CREATE TABLE items (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO items(title, price) VALUES
('Mona Liza', 50000),
('Black Square', 1000),
('Mystic party', 78000),
('Girl in the Ball', 145222);



COMMIT;