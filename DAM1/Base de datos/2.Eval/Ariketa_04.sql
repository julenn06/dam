drop database db_lantokia;
create database if not exists db_lantokia

charset utf8mb4
collate utf8mb4_general_ci;

use db_lantokia;

create table hiria(
kodeHiria int unsigned primary key,
izenaHiria varchar(40),
probintzia varchar(30),
hiriburua boolean
);

create table lantokia(
kodeLantokia int unsigned primary key,
izenaLant varchar(40),
helbidea varchar(40),
aurrekontua float,
kodeHiria int unsigned,
foreign key (kodeHiria) references hiria (kodeHiria)
);

CREATE TABLE saila (
    kodeSaila CHAR(5) PRIMARY KEY,
    izenaSaila VARCHAR(40),
    aurrekontua FLOAT,
    kodeLantokia INT UNSIGNED,
    kodeSailaBurua CHAR(5),
    FOREIGN KEY (kodeSailaBurua)
        REFERENCES saila (kodeSaila),
    FOREIGN KEY (kodeLantokia)
        REFERENCES lantokia (kodeLantokia)
);