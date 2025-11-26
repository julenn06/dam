create database db_enpresaProbak
charset utf8mb4
collate utf8mb4_spanish2_ci;

use db_enpresaProbak;

CREATE TABLE Dep (
    zbkD INT PRIMARY KEY,
    izena VARCHAR(30) NOT NULL,
    lang_kop INT NOT NULL DEFAULT 0
);

CREATE TABLE Langile (
    zbkL INT PRIMARY KEY,
    izena VARCHAR(40) NOT NULL,
    soldata FLOAT NOT NULL,
    dep_zbk INT NOT NULL,
    FOREIGN KEY (dep_zbk)
        REFERENCES Dep (zbkD)
        ON UPDATE CASCADE
);


CREATE 
    TRIGGER  LANGILEBERRIA
 AFTER INSERT ON langile FOR EACH ROW 
    UPDATE Dep SET lang_kop = lang_kop + 1 WHERE
        zbkD = NEW.dep_zbk;

show triggers;

insert into Dep (zbkD,izena) values 
(1, 'Erosketak'), 
(2, 'Salmentak');

insert into Langile values 
(1, 'Jone Arrien', 1250.45, 1);


delimiter //
create trigger DEP_ALDAKETA
after update on langile
for each row 
begin
if new.dep_zbk != old.dep_zbk then
update Dep 
set lang_kop = lang_kop + 1 
where zbkD= OLD.dep_zbk;
UPDATE Dep 
SET 
    lang_kop = lang_kop - 1
WHERE
    zbkD = NEW.dep_zbk;
end if;
end;
//



#db_herriak datu basearen gainean

use db_herriak;

#1)
CREATE TABLE HerriZaharrak (
    id_herria INT,
    izena VARCHAR(50) NOT NULL,
    populazioa INT,
    kod_probintzia INT NOT NULL,
    izena_prob VARCHAR(30) NOT NULL,
    baja_data DATE NOT NULL
);

delimiter //
CREATE 
    TRIGGER  HERRIAKEZABATU
 AFTER DELETE ON herriak 
 FOR EACH ROW 
 BEGIN 

    declare pIzena varchar(30);

SELECT 
    p.izena
INTO pIzena FROM
    probintziak p
WHERE
    kod_probintzia = old.kod_probintzia;

    insert into HerriZaharrak values (old.id_herria,old.izena, old.populazioa);

    END
//


#2)

CREATE TABLE PopulazioaAldaketak (
    testua VARCHAR(200),
    eguna DATE
);

drop trigger PopulazioaAldaketu;

delimiter //
create trigger PopulazioaAldaketu 
after update on herriak
for each row
begin

declare hIzena varchar(30);
declare pIzena varchar(30);
declare mezua varchar(100);

if new.populazioa != old.populazioa then

select izena into hIzena from herriak where populazioa = new.populazioa;

SELECT 
    izena
INTO pIzena FROM
    probintzia;

set mezua = CONCAT(pIzena + ' probintziako ' + hIzena + ' herriko biztanleria hazi egin da ' + old.populazioa * ' izatetik ' + new.populazioa + 'biztanle izatera');

insert into PopulazioaAldaketak values (mezua, curdate());

end if;

end //

select * from herriak;

UPDATE herriak
SET populazioa = populazioa + 1000
WHERE izena = "Agolada";

select * from PopulazioaAldaketak;


#3)

create table HerriDInamikoak (
id_herria int primary key,
izena varchar(50) not null,
populazioa int, 
kod_probintzia int not null,
sorrera_data date,
desagertze_data date);

drop trigger HerriaGehitu;
delimiter //
create trigger HerriaGehitu 
after insert on herriak
for each row
begin

declare nid_herria int;
declare nizena varchar(30);
declare npopulazioa int;
declare nkod_probintzia int;
declare sorreraData date;
declare desagertzeData date;

set sorreraData = curdate();
set desagertzeData = null;

select id_herria into nid_herria from herriak order by id_herria desc limit 1;
select izena into nizena from herriak order by id_herria desc limit 1;
select populazioa into npopulazioa from herriak order by id_herria desc limit 1;
select kod_probintzia into nkod_probintzia from herriak order by id_herria desc limit 1;

insert into HerriDInamikoak values (nid_herria, nizena, npopulazioa, nkod_probintzia, sorreraData, desagertzeData);

end //
select * from herriak;
insert into herriak values (6583, "aaqq", 10000,36);

select * from HerriDInamikoak;