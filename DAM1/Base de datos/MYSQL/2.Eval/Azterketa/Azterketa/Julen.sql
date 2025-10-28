drop database if exists ElorrietaAutoak_Julen;
create database if not exists ElorrietaAutoak_Julen
charset utf8mb4 collate utf8mb4_spanish_ci;

use ElorrietaAutoak_Julen;

CREATE TABLE Jabea (
    kodea_jabea INT AUTO_INCREMENT NOT NULL,
    izena VARCHAR(50) NOT NULL,
    abizena VARCHAR(50) NOT NULL,
    helbidea VARCHAR(100) NOT NULL,
    postakodea VARCHAR(5) NOT NULL DEFAULT 48015,
    telefonoa VARCHAR(9) NOT NULL,
    lizentzia_zbk CHAR(5) NOT NULL,
    CONSTRAINT pk_jabea PRIMARY KEY (kodea_jabea , lizentzia_zbk)
);

CREATE TABLE Autoa (
    kodea_autoa VARCHAR(5) NOT NULL,
    matrikula VARCHAR(7) NOT NULL,
    marka ENUM('Maruti', 'Ford', 'Hyundai') NOT NULL,
    modeloa VARCHAR(25) NOT NULL,
    bertsioa VARCHAR(15) NOT NULL,
    modelo_urtea VARCHAR(4) NOT NULL,
    kolorea ENUM('Beltza', 'Zuria', 'Gorria', 'Urdina') NOT NULL,
    erosketa_urtea VARCHAR(4) NOT NULL,
    kilometroak INT NOT NULL CHECK (kilometroak < 50000),
    CONSTRAINT pk_autoa PRIMARY KEY (kodea_autoa , matrikula)
);

CREATE TABLE Autoa_Jabea (
    kodea_jabea INT NOT NULL,
    kodea_autoa VARCHAR(5) NOT NULL,
    erosketa_prezioa DECIMAL(10 , 2 ) NOT NULL CHECK (erosketa_prezioa < 25000),
    CONSTRAINT fk_jabea FOREIGN KEY (kodea_jabea)
        REFERENCES Jabea (kodea_jabea),
    CONSTRAINT fk_autoa FOREIGN KEY (kodea_autoa)
        REFERENCES Autoa (kodea_autoa),
    CONSTRAINT pk_autoa PRIMARY KEY (kodea_autoa , kodea_jabea)
);


CREATE TABLE Eskaintzak (
    id INT PRIMARY KEY AUTO_INCREMENT,
    kodea_autoa VARCHAR(5) NOT NULL,
    kodea_jabea INT NOT NULL,
    eguna DATE NOT NULL,
    CONSTRAINT fk_Eskaintzak FOREIGN KEY (kodea_autoa , kodea_jabea)
        REFERENCES Autoa_Jabea (kodea_autoa , kodea_jabea)
);