DROP DATABASE IF EXISTS adlister_db;

CREATE DATABASE adlister_db;
CREATE USER IF NOT EXISTS 'addlister'@'localhost' IDENTIFIED by 'codeup';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP ON adlister_db.*;

USE adlister_db;

CREATE TABLE IF NOT EXISTS users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR (50),
  email VARCHAR (255),
  PASSWORD VARCHAR (255)
);

CREATE TABLE IF NOT EXISTS ads (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  title VARCHAR(255),
  description TEXT,
  FOREIGN KEY (user_id)
  REFERENCES users(id)
    ON UPDATE CASCADE ON DELETE RESTRICT
);

# Default web user account
INSERT INTO users(username, email,password) VALUES ('admin','me@open.com','password')