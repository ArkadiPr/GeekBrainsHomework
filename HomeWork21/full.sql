BEGIN;


DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial PRIMARY KEY, name VARCHAR(255),age int);
INSERT INTO users (name,age) VALUES
('Arnold S.',30),
('Silvester S.',25),
('Willis B.',60),
('Jackie C.',57),
('Bruce L.',15);


DROP TABLE IF EXISTS items CASCADE;
CREATE TABLE items (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO items(title, price) VALUES
('Mona Liza', 50000),
('Black Square', 1000),
('Mystic party', 78000),
('Girl in the Ball', 145222);




COMMIT;