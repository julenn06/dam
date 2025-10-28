CREATE DATABASE db_Eskaerak;
USE db_Eskaerak;
-- 
-- Table structure for table `artikulua`
-- 
DROP TABLE IF EXISTS `artikulua`;
CREATE TABLE `artikulua` (
    `ArtKod` CHAR(5) NOT NULL,
    `ArtDes` VARCHAR(30) NOT NULL,
    `ArtPVP` FLOAT NOT NULL,
    PRIMARY KEY (`ArtKod`),
    KEY `IArtDes` (`ArtDes` (10)),
    CONSTRAINT `ch_ArtPVP` CHECK ((`ArtPVP` > 0))
);
-- 
-- Dumping data for table `artikulua`
-- 
INSERT INTO `artikulua` VALUES 
('A0012','Borragoma',0.15),
('A0043','Boligrafo urdina',0.78),
('A0075','Arkatza 2B',0.55),
('A0078','Boligrafo gorria normala',1.05),
('A0089','Zorrozkailua',0.25);
-- 
-- Table structure for table `eskaera`
-- 
DROP TABLE IF EXISTS `eskaera`;
CREATE TABLE `eskaera` (
    `EskaRef` CHAR(5) NOT NULL,
    `EskaData` DATE NOT NULL,
    PRIMARY KEY (`EskaRef`)
);
-- 
-- Dumping data for table `eskaera`
-- 
INSERT INTO `eskaera` VALUES 
('E0001','2022-02-16'),
('E0002','2022-02-18'),
('E0003','2022-02-23'),
('E0004','2022-02-25');
-- 
-- Table structure for table `eskaera_lerroa`
-- 
DROP TABLE IF EXISTS `eskaera_lerroa`;
CREATE TABLE `eskaera_lerroa` (
    `EskaRef` CHAR(5) NOT NULL,
    `ArtKod` CHAR(5) NOT NULL,
    `ArtKant` INT UNSIGNED NOT NULL DEFAULT '1',
    PRIMARY KEY (`EskaRef` , `ArtKod`),
    KEY `fk_ArtKod_EskaeraLerroa` (`ArtKod`),
    CONSTRAINT `fk_ArtKod_EskaeraLerroa` FOREIGN KEY (`ArtKod`)
        REFERENCES `artikulua` (`ArtKod`)
        ON UPDATE CASCADE,
    CONSTRAINT `fk_EskaRef_EskaeraLerroa` FOREIGN KEY (`EskaRef`)
        REFERENCES `eskaera` (`EskaRef`)
        ON UPDATE CASCADE
);
-- 
-- Dumping data for table `eskaera_lerroa`
-- 
INSERT INTO `eskaera_lerroa` VALUES 
('E0001','A0043',10),
('E0001','A0078',12),
('E0002','A0043',5),
('E0003','A0075',20),
('E0004','A0012',15),
('E0004','A0043',5),
('E0004','A0089',50);