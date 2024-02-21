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

create table customer(
    id serial primary key,
    email varchar(50) not null,
	pwd varchar(500) not null,
	role varchar(500) not null
);

INSERT INTO customer(email, pwd, role) VALUES('jithesh@example.com', 'password5', 'admin');