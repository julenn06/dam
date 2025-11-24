drop database if exists db_ikasleak01;
CREATE DATABASE db_ikasleak01
CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE db_ikasleak01;

DROP TABLE IF EXISTS ikasleak;

CREATE TABLE ikasleak (
  kodeikasleak varchar(4) NOT NULL,
  izena varchar(50) NOT NULL,
  abizena varchar(50) NOT NULL,
  PRIMARY KEY (kodeikasleak));

insert  into ikasleak(kodeikasleak,izena,abizena) values 
('I001','Aimar','Acosta'),
('I002','Ainara','Barea'),
('I003','Eneko','Caballero'),
('I004','Josu','Campillo'),
('I005','Unai','Caño'),
('I006','Jon','del Río'),
('I007','Ainhize','Dosuna'),
('I008','Julen','Fernandez'),
('I009','Claudia','Garrido'),
('I010','Asier','Garrido'),
('I011','Alexander','Gonzalez'),
('I012','Irune','Guerenabarrena '),
('I013','Jonathan','Mambu'),
('I014','Kerman','Mendez'),
('I015','Pablo','Morejon'),
('I016','Joseba','Murua'),
('I017','Xabier','Oñederra'),
('I018','Hodei','Pardo'),
('I019','Javier','Perez'),
('I020','Karim','Sadiki'),
('I021','Alex','Saez'),
('I022','Iker','San Pedro'),
('I023','Gorka','Veloso'),
('I024','Aitor','Zuloaga');


DROP TABLE IF EXISTS zikloak;

CREATE TABLE zikloak (
  kodeZikloa varchar(4) NOT NULL,
  izena varchar(100) NOT NULL,
  maila varchar(50) NOT NULL,
  PRIMARY KEY (kodeZikloa));


insert  into zikloak(kodeZikloa,izena,maila) values 
('ASIR','SAREKO INFORMATIKA-SISTEMEN ADMINISTRAZIOKO GOI-MAILAKO TEKNIKARIA','Goi-Maila'),
('DAM','PLATAFORMA ANITZEKO APLIKAZIOAK GARATZEKO GOI-MAILAKO TEKNIKARIA','Goi-Maila'),
('DAW','WEB APLIKAZIOEN GARAPENEKO GOI-MAILAKO TEKNIKARIA','Goi-Maila'),
('SMR','MIKROINFORMATIKA-SISTEMETAKO ETA SAREETAKO TEKNIKARIA','Erdi-Maila');


DROP TABLE IF EXISTS ikasle_zikloa;

CREATE TABLE ikasle_zikloa (
  kodeikasleak varchar(4) NOT NULL,
  kodeZikloa varchar(4) NOT NULL,
  PRIMARY KEY (kodeikasleak),
  FOREIGN KEY (kodeikasleak) REFERENCES ikasleak (kodeikasleak),
  FOREIGN KEY (kodeZikloa) REFERENCES zikloak (kodeZikloa));
  
  
insert  into ikasle_zikloa(kodeikasleak,kodeZikloa) values 
('I001','DAM'),
('I002','DAM'),
('I003','DAM'),
('I004','DAM'),
('I005','DAM'),
('I006','DAM'),
('I007','DAM'),
('I008','DAM'),
('I009','DAM'),
('I010','DAM'),
('I011','DAM'),
('I012','DAM'),
('I013','DAM'),
('I014','DAM'),
('I015','DAM'),
('I016','DAM'),
('I017','DAM'),
('I018','DAM'),
('I019','DAM'),
('I020','DAM'),
('I021','DAM'),
('I022','DAM'),
('I023','DAM'),
('I024','DAM');
