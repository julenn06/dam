USE DB_IKASLEAK02;

# 1) Lehenengo Scripta exekutatu


#2)
select * from ikasleak;
select * from ikasgaiak;
select * from notak;

#3) Bigarren Scripta exkeutatu

#4)
SELECT * FROM ikasleak;
SELECT * FROM.ikasgaiak;
SELECT * FROM notak;


#5)
select izenabizena, kurtsoa, izena, nota
from ikasleak inner join ikasgaiak using (kurtsoa)
inner join notak using (kod)
order by kurtsoa;


#6)
#INSERT INTO IKASLEAK 
#VALUES ('12345678T', 'Galarreta Gorostiaga, Galder', 'Artekale, 10', 'Bilbao', '631999333', 1, 'D', '1999-01-23');

#Beste modu batean idatzita
INSERT INTO IKASLEAK 
(DNI, Izena, Helbidea, Hiria, Telefonoa, Maila, Taldea, JaiotzeData) 
VALUES ('12345678T', 'Galarreta Gorostiaga, Galder', 'Artekale, 10', 'Bilbao', '631999333', 1, 'D', '1999-01-23');


#7)
ALTER TABLE IKASLEAK
MODIFY IZENABIZENA VARCHAR(50);

INSERT INTO IKASLEAK
VALUES ('12345321A', 'Ajuriagoxeaskoaetxebarria Amezaga, Ane Miren', 'Artekale, 12', 'Bilbao', '631999444', 1,'D', '1999-04-25');

describe ikasleak;


#8)
INSERT INTO IKASLEAK (IZENABIZENA,HELB,HERRIA,TELEF,KURTSOA,EREDUA,JAIO_DATA)
VALUES ('Zarate Eizmendi, Olatz', 'Artekale, 14', 'Bilbao', '631999000', 1,'D', '1998-04-25');
#Errorea eman du NAN gako nagusia delako eta beharrezkoa delako


#9)
INSERT INTO IKASLEAK (NAN, IZENABIZENA,KURTSOA,EREDUA)
VALUES ('11111111Y','Zarate Eizmendi, Olatz', 1,'D');
#Bai txertatu ahalko ditugu, datu guztiak beteta daudelako



#10)
#Zergatik ematen du errorea hurrengo aginduak?
INSERT INTO IKASLEAK (NAN, IZENABIZENA,KURTSOA,EREDUA)
VALUES ('11111111Y','Guridi Diaz, Maialen', 2,'D');
#9 atalean NAN zenbaki hori txertatu dugulako, eta gako nagusia denez, ezin da errepikatu, beraz, "duplicate entry" errorea ematen digu.


#Zergatik ematen du errorea hurrengo aginduak?
INSERT INTO IKASLEAK (NAN, IZENABIZENA, HELB, HERRIA, TELEF,KURTSOA, EREDUA, JAIO_DATA)
VALUES ('22222222L', NULL , 'Goikoa,2 2B', 'Bilbao', '944442244', 2, 'D', '1998-03-15');
#Ez dit errorea eman

#Baina ondorengo aginduan ere NULL datuak daude, eta ez dute errorerik ematen. Zergatik?
INSERT INTO IKASLEAK (NAN, IZENABIZENA, HELB, HERRIA, TELEF,KURTSOA, EREDUA, JAIO_DATA)
VALUES ('22222222L','Guridi Diaz, Mikel' , 'Goikoa,2 2B', 'Bilbao',NULL, 2, 'D', '1998-03-15');
#Bai eman dit errorea


#11)

SET SQL_SAFE_UPDATES = 0;
#Hau exekutatu behar da bestela errorea ematen dit

select * 
from notak;

UPDATE NOTAK
INNER JOIN IKASGAIAK ON IKASGAIAK.IZENA = "Sistema Informatikoak"
SET NOTAK.NOTA = NOTAK.NOTA + 1
WHERE NOTAK.NOTA >= 5 AND NOTAK.NOTA <= 7;


#12)
DELETE FROM IKASGAIAK
WHERE KOD NOT IN (
    SELECT DISTINCT KOD
    FROM NOTAK
);

#Ikusteko zein datuak ezabatuko diren
#SELECT *
#FROM IKASGAIAK
#LEFT JOIN NOTAK ON IKASGAIAK.KOD = NOTAK.KOD
#WHERE NOTAK.KOD IS NULL;