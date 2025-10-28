create database if not exists db_probak_02
charset utf8mb4
collate utf8mb4_spanish2_ci;

use db_probak_02;


create table Departamentuak (
    Kode INT NOT NULL PRIMARY KEY,
    Saila VARCHAR(50) NOT NULL
);

insert into Departamentuak (Kode, Saila) values
(1, 'Salmentak'),
(2, 'Ekoizpena'),
(3, 'Kalitatea'),
(4, 'Zuzendaritza');

create table Langileak (
    Kode INT NOT NULL PRIMARY KEY,
    Izena VARCHAR(50) NOT NULL,
    Abizena VARCHAR(50) NOT NULL,
    Kod_dep INT NOT NULL,
    Adina INT NOT NULL,
    FOREIGN KEY (Kod_dep) REFERENCES Departamentuak(Kode)
);

-- Insertar los datos en la tabla Langileak
insert into Langileak (Kode, Izena, Abizena, Kod_dep, Adina) values
(1, 'Jon', 'Agirre', 1, 54),
(2, 'Ane', 'Barrenetxea', 1, 58),
(3, 'Miren', 'Goiri', 2, 43),
(4, 'Ziortza', 'Ameztoy', 2, 29),
(5, 'Eneko', 'Ibarguengoitia', 3, 34),
(6, 'Mikel', 'Eiguren', 4, 21),
(7, 'Julen', 'Beitia', 4, 40);