# Unai Caño

#LEHENENGO ZATIA
drop database if exists ElorrietaAutoak_UnaiCaño;
create database if not exists ElorrietaAutoak_UnaiCaño
charset utf8mb4
collate utf8mb4_spanish2_ci;
use ElorrietaAutoak_UnaiCaño;

create table autoa(
kode_autoa char(5) primary key not null,
matrikula char(7) unique not null,
marka enum('Maruti', 'Ford', 'Hyundai') not null,
modeloa varchar(30) not null,
bertsioa text not null,
modelo_urtea date not null,
kolorea enum('Beltza', 'Zuria', 'Gorria', 'Urdina') not null,
erosketa_urtea date not null,
kilometroak int not null ,

constraint kilometroak_check check (kilometroak < 50000)
);

create table jabea(
kode_jabea int auto_increment primary key not null,
lizentzia_zbk char(5) unique not null,
izena varchar (30) not null,
abizena varchar(30) not null,
helbidea varchar (50) not null,
herria varchar(40) not null,
posta_kode int not null check(posta_kode > 48015),
telefonoa varchar(15) not null


);

create table auto_jabea(
kode_autoa char(5)  not null,
kode_jabea int not null,
erosketa_prezioa int not null check(erosketa_prezioa < 25000),

constraint auto_jabea_pks primary key (kode_autoa, kode_jabea),
constraint kode_autoa_fk foreign key (kode_autoa) references autoa(kode_autoa) on update cascade on delete restrict,
constraint kode_jabea_fk foreign key (kode_jabea) references jabea(kode_jabea) on update cascade on delete restrict
);

create table eskaintzak(
id int auto_increment primary key,
kode_autoa char(5) not null,
kode_jabea int not null,
eguna date not null ,

constraint auto_jabea_fks foreign key (kode_autoa,kode_jabea) references auto_jabea(kode_autoa, kode_jabea)on update cascade on delete restrict
);

#BIGARREN ZATIA
use db_burger;
-- 1
select concat(bz.izena ,' ', bz.abizena)as Bezeroa, bz.helbidea as Helbidea , bz.herria as Herria , bg.izena_burger as Burger, concat(bg.prezioa, ' €') as Prezioa, os.izena_osagaia as 'Osagai Gehigarria', year(esk.data ) as 'Eskaera Urtea'
from bezeroak bz join eskaerak esk using(nan)
				 join burger bg on esk.id_burger = bg.id
                 join osagaia os on esk.id_osagai_gehiagarria = os.id
order by bz.izena;
                 

-- 2
select bg.izena_burger as Burger, concat(bg.preparazio_denbora, ' min') as Denbora , concat(bg.prezioa, ' €') as Prezioa, os.mota as Mota,count(os.mota) as 'Osagai Kantitatea'
from burger bg join eduki ed on bg.id = ed.id_burger
			   join osagaia os on ed.id_osagaia = os.id
where bg.preparazio_denbora > (select avg(bg.preparazio_denbora) from burger bg)
group by bg.izena_burger, bg.preparazio_denbora, bg.prezioa, os.mota;


-- 3
select bg.izena_burger as Burger,  concat(bg.prezioa, ' €') as Prezioa, count(os.id) as 'Osagai Kantitatea'
from burger bg join eduki ed on bg.id = ed.id_burger
			   join osagaia os on ed.id_osagaia = os.id
where bg.id not in (select distinct bg.id
					from burger	bg join eduki ed on bg.id = ed.id_burger
									join osagaia os on ed.id_osagaia = os.id	
					where os.mota = 'Haragia')
					and 
					os.id not in (select os.id 
										  from osagaia os 
										  where os.mota = 'Esnekia')
group by bg.izena_burger, bg.prezioa;

-- 4
select bg.izena_burger as Burger,  concat(bg.prezioa, ' €') as Prezioa
from bezeroak bz join eskaerak esk using(nan)
				 join burger bg on esk.id_burger = bg.id      
where bg.id in (select bg.id
				  from bezeroak bz join eskaerak esk using(nan)
								   join burger bg on esk.id_burger = bg.id 
				  group by bg.id
				 having count(bz.izena) > 2)
group by bg.izena_burger, bg.prezioa
order by count(*) desc;

-- 5
set SQL_SAFE_UPDATES = 0;
Start transaction;


delete
from bezeroak 
where nan not in (select nan
				  from eskaerak esk);



rollback;

-- 6
Start transaction;

update burger 
set prezioa = prezioa * 0.8
where id in (select ed.id_burger
			from  eduki ed join osagaia os on ed.id_osagaia = os.id
			where os.mota = "Barazkia"
			group by ed.id_burger
			having count(*) > 1);



rollback;

