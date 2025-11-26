CREATE DATABASE PizzeriaDB;
USE PizzeriaDB;

CREATE TABLE Bezeroak (
    nan VARCHAR(15) PRIMARY KEY,
    izena VARCHAR(50),
    abizena VARCHAR(50),
    helbidea VARCHAR(100),
    herria VARCHAR(50),
    telefonoa VARCHAR(20),
    emaila VARCHAR(100)
);

CREATE TABLE Osagaia (
    id INT PRIMARY KEY AUTO_INCREMENT,
    izena_osagaia VARCHAR(50),
    neurria_unitatea VARCHAR(20),
    mota VARCHAR(30)
);

CREATE TABLE Pizza (
    izena_pizza VARCHAR(50) PRIMARY KEY,
    preparazio_denbora INT,
    prezioa DECIMAL(6 , 2 )
);

CREATE TABLE Eduki (
    izena_pizza VARCHAR(50),
    id_osagaia INT,
    kantitatea DECIMAL(5 , 2 ),
    PRIMARY KEY (izena_pizza , id_osagaia),
    FOREIGN KEY (izena_pizza)
        REFERENCES Pizza (izena_pizza),
    FOREIGN KEY (id_osagaia)
        REFERENCES Osagaia (id)
);

CREATE TABLE Eskaerak (
    zbk INT PRIMARY KEY AUTO_INCREMENT,
    eguna DATE,
    nan VARCHAR(15),
    izena_pizza VARCHAR(50),
    id_osagai_gehigarria INT,
    FOREIGN KEY (nan)
        REFERENCES Bezeroak (nan),
    FOREIGN KEY (izena_pizza)
        REFERENCES Pizza (izena_pizza),
    FOREIGN KEY (id_osagai_gehigarria)
        REFERENCES Osagaia (id)
);

INSERT INTO Bezeroak VALUES
('12345678A', 'Ane', 'Lopez', 'Kale Nagusia 12', 'Bilbo', '600123456', 'ane.lopez@example.com'),
('23456789B', 'Jon', 'Garcia', 'Zabalbide 34', 'Gasteiz', '600234567', 'jon.garcia@example.com'),
('34567890C', 'Maite', 'Etxeberria', 'San Mames 7', 'Donostia', '600345678', 'maite.etxe@example.com'),
('45678901D', 'Iker', 'Mendizabal', 'Iparragirre Etorbidea 56', 'Eibar', '600456789', 'iker.mendi@example.com'),
('56789012E', 'Leire', 'Olaizola', 'Iturribide 9', 'Irun', '600567890', 'leire.ola@example.com');

INSERT INTO Osagaia (id, izena_osagaia, neurria_unitatea, mota) VALUES
(1, 'Gazta', 'gramoak', 'Oinarrizkoa'),
(2, 'Tomatea', 'gramoak', 'Oinarrizkoa'),
(3, 'Urdaiazpikoa', 'gramoak', 'Gehigarria'),
(4, 'Olibak', 'gramoak', 'Gehigarria'),
(5, 'Perretxikoak', 'gramoak', 'Gehigarria'),
(6, 'Anana', 'gramoak', 'Gehigarria'),
(7, 'Tipula', 'gramoak', 'Oinarrizkoa'),
(8, 'Txorizoa', 'gramoak', 'Gehigarria');

INSERT INTO Pizza VALUES
('Margarita', 10, 8.50),
('Barbekoa', 15, 11.00),
('Hawaiana', 12, 9.50),
('Vegetariana', 13, 10.00),
('4 Gazta', 14, 11.50);

INSERT INTO Eduki VALUES
('Margarita', 1, 100),
('Margarita', 2, 80),
('Barbekoa', 1, 100),
('Barbekoa', 2, 80),
('Barbekoa', 8, 70),
('Hawaiana', 1, 90),
('Hawaiana', 2, 70),
('Hawaiana', 6, 60),
('Vegetariana', 1, 90),
('Vegetariana', 2, 90),
('Vegetariana', 5, 50),
('Vegetariana', 4, 40),
('4 Gazta', 1, 120),
('4 Gazta', 7, 30);

INSERT INTO Eskaerak (eguna, nan, izena_pizza, id_osagai_gehigarria) VALUES
('2025-04-01', '12345678A', 'Margarita', 3),
('2025-04-02', '23456789B', 'Barbekoa', 4),
('2025-04-02', '34567890C', 'Hawaiana', 6),
('2025-04-03', '45678901D', 'Vegetariana', 5),
('2025-04-04', '56789012E', '4 Gazta', 8),
('2025-04-05', '12345678A', 'Barbekoa', 4),
('2025-04-06', '23456789B', 'Vegetariana', 5),
('2025-04-07', '34567890C', 'Margarita', 3),
('2025-04-08', '45678901D', 'Hawaiana', 6),
('2025-04-09', '56789012E', '4 Gazta', 4);