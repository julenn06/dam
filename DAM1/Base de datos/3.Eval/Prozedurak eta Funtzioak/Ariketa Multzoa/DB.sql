create database db_eskaerak2
collate utf8mb4_spanish_ci;

use db_eskaerak2;

CREATE TABLE artikuluak (
    artikulukodea CHAR(4) PRIMARY KEY,
    deskribapena VARCHAR(25),
    salmentaprezioa FLOAT
);

insert into artikuluak values ('A001', 'Boli gorria', 1.25);
insert into artikuluak values ('A002', 'Boli urdina', 1.25);
insert into artikuluak values ('A003', 'Boli beltza', 1.25);
insert into artikuluak values ('A004', 'Arkatza', 1.25);
insert into artikuluak values ('A005', 'Koaderno txikia', 3.50);
insert into artikuluak values ('A006', 'Koaderno ertaina', 4.00);
insert into artikuluak values ('A007', 'Koaderno handia', 4.50);
insert into artikuluak values ('A008', 'Zorrozkailu', 1.50);
insert into artikuluak values ('A009', 'Borra goma txikia', 1.50);
insert into artikuluak values ('A010', 'Borra goma handia', 1.75);

CREATE TABLE eskaera (
    eskaerazbk INT PRIMARY KEY,
    eguna DATE
);

insert into eskaera values (1, '2023-03-01');
insert into eskaera values (2, '2023-03-01');
insert into eskaera values (3, '2023-03-01');
insert into eskaera values (4, '2023-03-01');
insert into eskaera values (5, '2023-03-02');
insert into eskaera values (6, '2023-03-02');
insert into eskaera values (7, '2023-03-02');
insert into eskaera values (8, '2023-03-03');
insert into eskaera values (9, '2023-03-03');
insert into eskaera values (10, '2023-03-03');

CREATE TABLE eskaeraItem (
    eskaerazbk INT,
    eskaeraitem INT,
    artikulukodea CHAR(4),
    kantitatea INT,
    PRIMARY KEY (eskaerazbk , eskaeraitem),
    FOREIGN KEY (eskaerazbk)
        REFERENCES eskaera (eskaerazbk),
    FOREIGN KEY (artikulukodea)
        REFERENCES artikuluak (artikulukodea)
);

insert into eskaeraItem values (1, 1, 'A001', 1);
insert into eskaeraItem values (1, 2, 'A002', 1);
insert into eskaeraItem values (1, 3, 'A003', 2);
insert into eskaeraItem values (1, 4, 'A004', 1);
insert into eskaeraItem values (2, 1, 'A003', 3);
insert into eskaeraItem values (3, 1, 'A001', 1);
insert into eskaeraItem values (3, 2, 'A002', 1);
insert into eskaeraItem values (3, 3, 'A003', 1);
insert into eskaeraItem values (3, 4, 'A005', 2);
insert into eskaeraItem values (4, 1, 'A002', 2);
insert into eskaeraItem values (5, 1, 'A003', 1);
insert into eskaeraItem values (6, 1, 'A004', 3);
insert into eskaeraItem values (6, 2, 'A005', 1);
insert into eskaeraItem values (7, 3, 'A006', 2);
insert into eskaeraItem values (7, 1, 'A007', 3);
insert into eskaeraItem values (8, 1, 'A008', 3);
insert into eskaeraItem values (9, 1, 'A009', 1);
insert into eskaeraItem values (10, 1, 'A010', 1);
insert into eskaeraItem values (10, 2, 'A001', 2);
insert into eskaeraItem values (10, 3, 'A002', 2);
insert into eskaeraItem values (10, 4, 'A003', 1);
insert into eskaeraItem values (10, 5, 'A004', 1);
insert into eskaeraItem values (10, 6, 'A005', 1);
insert into eskaeraItem values (10, 7, 'A006', 3);
insert into eskaeraItem values (10, 8, 'A007', 3);
insert into eskaeraItem values (10, 9, 'A008', 3);
