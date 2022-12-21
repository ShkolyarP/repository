DROP TABLE users IF EXISTS;
CREATE TABLE IF NOT EXISTS users (id bigserial, name VARCHAR(255), PRIMARY KEY(id));
INSERT INTO users (name) VALUES ('Bob'), ('Jack'), ('John');

DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), price int, PRIMARY KEY(id));
INSERT INTO products (title, price) VALUES ('Bread', 8), ('Milk', 18), ('Eggs', 23), ('Water', 5), ('Apples', 13);

