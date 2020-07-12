CREATE DATABASE IF NOT EXISTS 'app_database';

use app_database;

drop table if exists users;

CREATE TABLE if not exists users(
id long NOT NULL AUTO_INCREMENT,
firstName VARCHAR(255),
lastName VARCHAR(255),
email VARCHAR(255),
PRIMARY KEY (id));

select * from users;