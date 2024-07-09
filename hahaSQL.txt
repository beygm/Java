create database TallerPizza;

use TallerPizza;

create table usuarios(
idUser int auto_increment primary key,
tident varchar(100),
numeroId varchar(100),
nombres varchar(100),
apellidos varchar(100),
telefono varchar(100),
direccion varchar(100),
correo varchar(100),
contraseña varchar(100),
rol varchar(100)
);


create table pizza(
id_piza int auto_increment primary key,
nombre varchar(100),
descripcion varchar(100),
precio decimal(5,2),
cantidad bigInt(50),
vegetarian varchar(100),
vegan varchar(100),
available varchar(100)
);


create table pizza_order(
id_order int auto_increment primary key,
idUser int,
fecha datetime,
total decimal(6,2),
method varchar(50),
additional_notes varchar(200),
estado varchar(50),
CONSTRAINT fk_usuarios FOREIGN KEY (idUser) REFERENCES usuarios (idUser)
);


create table order_item(
id_item int auto_increment primary key,
id_order int,
id_piza int,
cantidad decimal(2,1),
precio decimal(5,2),

CONSTRAINT fk_pizza_order FOREIGN KEY (id_order) REFERENCES pizza_order (id_order),
CONSTRAINT fk_pizza FOREIGN KEY (id_piza) REFERENCES pizza (id_piza)
);