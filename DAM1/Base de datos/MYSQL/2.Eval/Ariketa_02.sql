# Ariketa 2

create database if not exists db_herriak
charset utf8mb4
collate utf8mb4_general_ci;


use db_herriak;

create table if not exists herria(
id_herria varchar(4) primary key,
izena varchar(20) not null,
populazioa int not null,
kod_probintzia varchar(5) not null unique, #FOREEEEEEEEEEEEEEN KEYYYYYYY
check(id_herria between 1 and 9000),
check(populazioa between 1 and 10000000)
);


create table if not exists probintzia(
kod_probintzia varchar(4) primary key,
izena varchar(20) not null,
azalera int not null,
id_hiriburua varchar(20) not null, #FOREEEEEEEEEEEEENN KEEEEYYYY
id_erkidegoa int not null, #FOREEEEEEEEEEEEENN KEEEEYYYY
check(azalera between 1 and 150000),
check(kod_probintzia between 1 and 52),
unique (izena, id_hiriburua, id_erkidegoa)
);

create table if not exists komunitatea(
id_erkidegoa int primary key,
izena varchar(20) not null unique,
id_hiriburua varchar(20) not null unique, #FOREEEEEEEEEEENN KEEEEYYY
check(id_erkidegoa between 1 and 19),
unique (izena, id_hiriburua)
);


ALTER TABLE aa
	ADD FOREIGN KEY herria(kod_probintzia) REFERENCES probintzia (kod_probintzia) ON DELETE CASCADE ON UPDATE CASCADE,
	ADD FOREIGN KEY probintzia(id_hiriburua) REFERENCES herria (id_herria) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD FOREIGN KEY probintzia(id_erkidegoa) REFERENCES komunitatea (id_erkidegoa) ON DELETE CASCADE ON UPDATE CASCADE,
	ADD FOREIGN KEY komunitatea(id_hiriburua) REFERENCES herria (id_herria) ON DELETE CASCADE ON UPDATE CASCADE;


