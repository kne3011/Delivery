create database delivery;
use delivery;

create table User_Status
(
id int(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name varchar(60) not null
);

create table User
(
id int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
email varchar(60) not null,
password varchar(60) not null,
name varchar(60) not null,
address varchar(60) not null,
status int(10) UNSIGNED,
FOREIGN KEY (status) REFERENCES User_Status (id)
); 

create table Reciept
(
id int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
type varchar(60) not null,
date date not null,
allPrice int not null,
user_id int UNSIGNED,
FOREIGN KEY (user_id) REFERENCES User (id)
); 

create table Type
(
id int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name varchar(60) not null
);

create table Product
(
id int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name varchar(60) not null,
type_id int UNSIGNED,
description text not null,
photo_link text not null,
price int,
FOREIGN KEY (type_id) REFERENCES Type (id)
); 

create table Reciept_component
(
id int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
product_id int UNSIGNED,
reciept_id int UNSIGNED,
FOREIGN KEY (product_id) REFERENCES Product (id),
FOREIGN KEY (reciept_id) REFERENCES Reciept (id)
);

create table Teg
(
id int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
name varchar(60) not null
);

create table Teg_list
(
id int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
product_id int UNSIGNED,
teg_id int UNSIGNED,
FOREIGN KEY (product_id) REFERENCES Product (id),
FOREIGN KEY (teg_id) REFERENCES Teg (id)
);

INSERT INTO `delivery`.`user_status` (`id`, `name`) VALUES ('1', 'User');
INSERT INTO `delivery`.`user_status` (`id`, `name`) VALUES ('2', 'Admin');
INSERT INTO `delivery`.`type` (`id`, `name`) VALUES ('1', 'burger');
INSERT INTO `delivery`.`type` (`id`, `name`) VALUES ('2', 'pizza');
INSERT INTO `delivery`.`type` (`id`, `name`) VALUES ('3', 'drinks');
INSERT INTO `delivery`.`type` (`id`, `name`) VALUES ('4', 'salad');
INSERT INTO `delivery`.`type` (`id`, `name`) VALUES ('5', 'addition');