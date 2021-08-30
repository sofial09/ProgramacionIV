create database if not exists PIntermedia;
use PIntermedia;

create table factura(
id_factura int not null primary key auto_increment,
nombre varchar(150) not null,
numf int not null,
fecha_vencimiento date not null,
marca varchar(20) not null,
modelo varchar(20) not null,
descripcion varchar(150) not null
);

insert into factura values ("1","Andres", "23500", "2011-02-21", "Hyundai", "Accent", "Bujías sin punta");

select * from factura;