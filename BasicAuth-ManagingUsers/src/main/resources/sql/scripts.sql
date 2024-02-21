create database spring-security;

use spring-security;

create table users(
    id serial primary key,
    username varchar(50) not null,
	password varchar(500) not null,
	enabled int not null
);

create table authorities (
    id serial primary key,
	username varchar(50) not null,
	authority varchar(50) not null
);

INSERT INTO users(username, password, enabled) VALUES('jithesh', 'password', 1);
INSERT INTO users(username, password, enabled) VALUES('yung', 'password', 1);
INSERT INTO authorities(username, authority) VALUES('jithesh', 'write');