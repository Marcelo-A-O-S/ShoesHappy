create database teste;
use teste;
create table usuario(
Id int primary key auto_increment not null,
usuario varchar(100) not null,
email varchar(100) not null,
password varchar(100) not null
);
use teste;
insert into usuario (usuario,email,password) values ("admin","admin@admin.com","admin123");
use teste;
select * from usuario;
use teste;
select * from usuario where email = "admin@admin.com";

use teste;
create table cliente(
Id  int primary key auto_increment not null,
nome varchar(200) not null,
email varchar(50) not null,
modalidade varchar(200) not null
);
use teste;
create table endereco(
Id int primary key auto_increment not null,
clienteId int not null,
cidade varchar(200) not null,
bairro varchar(200) not null,
estado varchar(200) not null,
rua varchar(200) not null,
numero int not null,
foreign key(clienteId) references teste.cliente(Id) on update cascade on delete cascade
);

select * from teste.cliente;
select * from teste.endereco;