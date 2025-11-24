drop database if exists azterketaErrepasoa;
create database if not exists azterketaErrepasoa
charset utf8mb4
collate utf8mb4_spanish2_ci;

use azterketaErrepasoa;

CREATE TABLE IF NOT EXISTS Liburua (
    ISBN CHAR(13) PRIMARY KEY NOT NULL,
    Izenburua VARCHAR(50) NOT NULL,
    Hizkuntza ENUM('Gaztelania', 'Ingelesa', 'Alemana', 'Euskara') NOT NULL,
    Editoriala VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Aleak (
    ISBN CHAR(13) NOT NULL,
    AleZbk INT NOT NULL,
    Hizkuntza ENUM('Prestatua', 'Erabilgarria', 'Konpontzen', 'Galdua') DEFAULT 'Erabilgarria' NOT NULL,
    CONSTRAINT pk_isbn_zbk PRIMARY KEY (ISBN , AleZbk),
    CONSTRAINT fk_isbn FOREIGN KEY (ISBN)
        REFERENCES Liburua (ISBN)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT ch_zbk CHECK (AleZbk >= 1)
);

CREATE TABLE Bazkidea (
    BazkideZbk INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    NIF CHAR(9) UNIQUE NOT NULL,
    Izena VARCHAR(25) NOT NULL,
    helbidea VARCHAR(100) NOT NULL,
    Email VARCHAR(25)
);

CREATE TABLE Mailegua (
    BazkideZbk INT NOT NULL,
    ISBN CHAR(13) NOT NULL,
    AleZbk INT NOT NULL,
    MaileguData DATE NOT NULL,
    ItzuleraData DATE,
    PRIMARY KEY (BazkideZbk, ISBN, AleZbk, MaileguData),
    CONSTRAINT fk_bazkide FOREIGN KEY (BazkideZbk)
        REFERENCES Bazkidea (BazkideZbk),
    CONSTRAINT fk_Alea FOREIGN KEY (ISBN, AleZbk)
        REFERENCES Aleak (ISBN, AleZbk)
        ON DELETE CASCADE ON UPDATE CASCADE
);