create database if not exists db_probak_01
charset utf8mb4
collate utf8mb4_spanish2_ci;

use db_probak_01;


create table Departamentuak (
    Kod_dep INT NOT NULL PRIMARY KEY,
    Saila VARCHAR(50) NOT NULL
);

insert into Departamentuak (Kod_dep, Saila) values
(1, 'Salmentak'),
(2, 'Ekoizpena'),
(3, 'Kalitatea'),
(4, 'Zuzendaritza');

create table Langileak (
    Kod_langilea INT NOT NULL PRIMARY KEY,
    Izena VARCHAR(50) NOT NULL,
    Abizena VARCHAR(50) NOT NULL,
    Kod_dep INT NOT NULL,
    Adina INT NOT NULL,
    FOREIGN KEY (Kod_dep) REFERENCES Departamentuak(Kod_dep)
);

-- Insertar los datos en la tabla Langileak
insert into Langileak (Kod_langilea, Izena, Abizena, Kod_dep, Adina) values
(1, 'Jon', 'Agirre', 1, 54),
(2, 'Ane', 'Barrenetxea', 1, 58),
(3, 'Miren', 'Goiri', 2, 43),
(4, 'Ziortza', 'Ameztoy', 2, 29),
(5, 'Eneko', 'Ibarguengoitia', 3, 34),
(6, 'Mikel', 'Eiguren', 4, 21),
(7, 'Julen', 'Beitia', 4, 40);