drop database db_mundua;
create database if not exists db_mundua
character set utf8mb4 collate utf8mb4_general_ci;

use db_mundua;

CREATE TABLE IF NOT EXISTS city (
    ID INT PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL,
    COUNTRY_CODE VARCHAR(3) NOT NULL,
    DISTRICT VARCHAR(100) NOT NULL,
    POPULATION INT
);

CREATE TABLE IF NOT EXISTS country (
    CODE VARCHAR(3) PRIMARY KEY,
    NAME VARCHAR(150) NOT NULL,
    CONTINENT VARCHAR(40) NOT NULL,
    REGION VARCHAR(100) NOT NULL,
    SURFACE_AREA INT,
    INDEPENDENCE_YEAR YEAR,
    POPULATION INT,
    LIFE_EXPECTANCY FLOAT,
    GNP FLOAT,
    GNP_OLD VARCHAR(50),
    LOCAL_NAME VARCHAR(50),
    GOVERNMENT_FORM VARCHAR(200),
    HEAD_OF_STATE VARCHAR(100),
    CAPITAL INT,
    CODE2 VARCHAR(2)
);

CREATE TABLE IF NOT EXISTS language (
    CODE VARCHAR(3),
    LANGUAGE VARCHAR(30),
    OFFICIAL CHAR(1),
    PERCENTAGE FLOAT,
    PRIMARY KEY (CODE , LANGUAGE)
);


alter table city
	ADD FOREIGN KEY (COUNTRY_CODE) REFERENCES country(CODE) ON DELETE CASCADE ON UPDATE CASCADE;
    
alter table language 
	ADD FOREIGN KEY (CODE) REFERENCES country(CODE) ON DELETE CASCADE ON UPDATE CASCADE;



#######################################################

use db_mundua;

#1
select NAME
from country
where region = "Caribbean";


#2
select count(NAME), count(INDEPENDENCE_YEAR)
from country
where INDEPENDENCE_YEAR > 1900;


#3
select *
from country
where GOVERNMENT_FORM like "%Republic%";


#4
select *
from country
where POPULATION > 10000000 and CONTINENT = "Europe";


#5
select name, LANGUAGE, OFFICIAL, CONTINENT
from country inner join language on country.CODE = language.CODE
where CONTINENT = "Asia";


#6
select NAME, language
from language inner join country on country.CODE = language.CODE
where language = "English" and OFFICIAL = "T";