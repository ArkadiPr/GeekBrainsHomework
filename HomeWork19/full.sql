BEGIN;


DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO users (name) VALUES
('Arnold S.'),
('Silvester S.'),
('Willis B.'),
('Jackie C.'),
('Bruce L.'),
('Smith W.'),
('Staitham J.'),
('Banderos A.');

DROP TABLE IF EXISTS lots CASCADE;
CREATE TABLE lots (id bigserial PRIMARY KEY, title VARCHAR(255), sum int,user_id bigint,version int, FOREIGN KEY (user_id) REFERENCES users(id));
INSERT INTO lots (title, sum,user_id,version) VALUES
('Mona Liza', 0,1,0),
('Black Square', 0,5,0),
('Mystic party', 0,6,0),
('Girl in the Ball', 0,3,0);


COMMIT;