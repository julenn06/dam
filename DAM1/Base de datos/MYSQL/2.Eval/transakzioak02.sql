/*---------------------------------------------------------------------------------*/
/************************* COMMIT ETA ROLLBACK ULERTZEN****************************/
/*--------------------------------------------------------------------------------*/

#LEHENENEGO KASUA

SET AUTOCOMMIT = 0;
SELECT @@AUTOCOMMIT;

DROP DATABASE IF EXISTS db_test;
CREATE DATABASE db_test CHARACTER SET utf8mb4;
USE db_test;

CREATE TABLE artikuluak (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  izena VARCHAR(100) NOT NULL,
  prezioa DOUBLE
);

INSERT INTO artikuluak (id, izena) VALUES (1, 'Lehen artikulua');
INSERT INTO artikuluak (id, izena) VALUES (2, 'Bigarren artikulua');
INSERT INTO artikuluak (id, izena) VALUES (3, 'Hirugarren artikulua');

-- Erregistratu al dira datuak taulan?
SELECT *
FROM artikuluak;

-- Erregistro berriak txertatu, beste modu batean:

INSERT INTO artikuluak (izena) VALUES ('Laugarre artikulua');
INSERT INTO artikuluak (izena) VALUES ('Bostgarren artikulua');
INSERT INTO artikuluak (izena) VALUES ('Seigarren artikulua');

-- Erregistratu al dira datuak taulan?
SELECT *
FROM artikuluak;

/*Orain, transakzioa osatu aurretik zerbitzariarekiko konexioa galtzen dugula simulatuko dugu 
(ikusi SET AUTOCOMMIT = 0 exekutatu dugula). 
MySQL Workbench-etik konexioa galtzen dugula simulatzeko, 
zerbitzariarekin konektatzeko erlaitza itxi behar da.*/

/* Ondoren berriz ere konektatuko gara eta ondorengo aginduak exekutatuko ditugu*/

USE db_test;

-- Erregistratu al dira datuak taulan?
SELECT *
FROM artikuluak;


#BIGARREN KASUA

SET AUTOCOMMIT = 1;
SELECT @@AUTOCOMMIT;

DROP DATABASE IF EXISTS db_test;
CREATE DATABASE db_test CHARACTER SET utf8mb4;
USE db_test;

CREATE TABLE artikuluak (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  izena VARCHAR(100) NOT NULL,
  prezioa DOUBLE
);

INSERT INTO artikuluak (id, izena) VALUES (1, 'Lehen artikulua');
INSERT INTO artikuluak (id, izena) VALUES (2, 'Bigarren artikulua');
INSERT INTO artikuluak (id, izena) VALUES (3, 'Hirugarren artikulua');

-- Erregistratu al dira datuak taulan?
SELECT *
FROM artikuluak;

-- Trantzakzioa desegiten saiatuko gara
ROLLBACK;

-- Zer itzuliko du ondorengo kontsultak?
SELECT *
FROM artikuluak;

-- Transakzio sortuko dugu
START TRANSACTION;
INSERT INTO artikuluak (id, izena) VALUES (4, 'Laugarren artikulua');
SELECT * FROM artikuluak;
ROLLBACK;

-- Zer itzuliko du ondorengo kontsultak?
SELECT *
FROM artikuluak;

-- Transakzioa exekutatuko dugu
INSERT INTO artikuluak (id, izena) VALUES (5, 'Bostgarren artikulua');
rollback;

-- Zer itzuliko du ondorengo kontsultak?
SELECT *
FROM artikuluak;

-- AUTOCOMMIT  desaktibatu eta taularen edukia ezabatzen dugu
SET AUTOCOMMIT = 0;
SELECT @@AUTOCOMMIT;

DELETE FROM artikuluak WHERE id > 0;

-- Konprobatu taula hutsik dagoela
SELECT *
FROM artikuluak;

-- Lerro berri bi txertatu
INSERT INTO artikuluak (id, izena) VALUES (6, 'Seigarren artikulua');
INSERT INTO artikuluak (id, izena) VALUES (7, 'Zazpigarren artikulua');
SELECT *
FROM artikuluak;

-- Rollback egingo dugu
ROLLBACK;

-- Zer emaitza izango dugu oraingoan??
SELECT *
FROM artikuluak;