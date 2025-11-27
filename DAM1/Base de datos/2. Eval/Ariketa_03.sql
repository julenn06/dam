drop database db_bidaiak;
create database if not exists db_bidaiak


charset utf8mb4
collate utf8mb4_general_ci;


use db_bidaiak;



create table if not exists herria(
kod_lekua smallint primary key,
izena varchar(20) not null,
deskribapena mediumtext,
check(kod_lekua > 0)
);


create table if not exists bidaia(
kod_Bidaia varchar(5),
izena varchar(20) not null unique,
iraupena smallint not null check(iraupena between 1 and 99)
);

alter table bidaia 
add primary key(kod_Bidaia);

create table if not exists hotela(
kod_Hotela smallint primary key,
izena varchar(20) not null,
kategoria smallint not null default '3',
deskribapena mediumtext,
kod_hotel_r smallint,
check(kod_Hotela between 1 and 999),
check(kategoria between 1 and 5),
foreign key (kod_hotel_r) references hotela(kod_Hotela)
);

#aukera1:
#kategoria tinyint not null defult 3,
#check (kateogria between 1 and 5),
#
#aukera2:
#kategoria enum('1','2','3','4','5') not null defult '3',
#
#aukera3:
#kategoria char(1) not null defult '3',
#check (kateogria IN ('1','2','3','4','5'))s


create table if not exists jarduera(
kod_Bidaia varchar(5),
jarduera_zbk smallint,
kod_jatorri smallint not null,
kod_helmuga smallint not null,
kod_Hotela smallint,
km smallint,
primary key(kod_Bidaia, jarduera_zbk),
check(jarduera_zbk between 1 and 99),
check(km between 0 and 20000),
foreign key (kod_Bidaia) references bidaia (kod_Bidaia) on delete cascade on update cascade,
foreign key (kod_jatorri) references herria (kod_lekua) on delete cascade on update cascade,
foreign key (kod_helmuga) references herria (kod_lekua) on delete cascade on update cascade,
foreign key (kod_Hotela) references hotela (kod_Hotela) on delete cascade on update cascade
);