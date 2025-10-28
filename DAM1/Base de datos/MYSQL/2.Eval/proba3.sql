create database if not exists db_julen
charset utf8mb4
collate utf8mb4_general_ci;

use db_julen3;

create table if not exists taldea(
id varchar(5) primary key,
tutorea varchar(45)
);

create table if not exists ikasleak(
id char(4) primary key,
NAN char(9) unique,
izena varchar(20),
abizena varchar(25),
idT varchar(5),
foreign key (idT) references taldea (id)
);