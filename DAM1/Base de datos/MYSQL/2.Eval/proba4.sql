# 01 Ariketa: db_ikasleak db_ikasleak01 datu basearen aplikazioa

use db_ikasleak01;

create table if not exists ikasgaiak(
kodeikasgai smallint primary key,
izena varchar(20),
kodeziklo varchar(4),
foreign key (kodeziklo) references zikloak (kodezikloa),
check (kodeikasgai between 1 and 9999)
);

create table if not exists ikasleak_ikasgaiak(
kodeikasleak varchar(4),
kodeikasgai smallint,
primary key (kodeikasleak, kodeikasgai),
foreign key (kodeikasleak) references ikasleak(kodeikasleak),
foreign key (kodeikasgai) references ikasgaiak(kodeikasgai)
);