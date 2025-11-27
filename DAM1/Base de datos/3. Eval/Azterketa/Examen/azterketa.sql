use db_elorrietafest;

#1)
drop view kontzertuakByGeneroa;
CREATE VIEW kontzertuakByGeneroa AS
    SELECT 
        t.generoa as Generoa,
        COUNT(k.idtalde)  AS KontzertuKopurua,
        round(AVG(t.cache),1) AS Cachea
    FROM
        talde t
            INNER JOIN
        kontzertu k ON t.idtalde = k.idtalde
    GROUP BY t.generoa
    ORDER BY Cachea DESC;
    
    select * from kontzertuakByGeneroa;


#2)
    alter view kontzertuakByGeneroa as
    
   SELECT 
        t.generoa as Generoa,
        COUNT(k.idtalde)  AS KontzertuKopurua, 
        round(AVG(t.cache), 1) AS Cachea, concat(floor(sum(k.iraupena) / 60) , ":" , minute(sec_to_time(sum(k.iraupena) *60))) as Iraupena
    FROM
        talde t
            INNER JOIN
        kontzertu k ON t.idtalde = k.idtalde
    GROUP BY t.generoa
    ORDER BY Cachea DESC;

    select * from kontzertuakByGeneroa;
    
#3)
create role ElorrietaProdukzioa;
grant select on db_elorrietafest.kontzertuakByGeneroa to ElorrietaProdukzioa;
grant alter on db_elorrietafest.kontzertu to ElorrietaProdukzioa;

create user 'Maialen' identified by 'HarriOrriHar' default role ElorrietaProdukzioa;


#4)
drop function BBUrteak;
delimiter //
create function BBUrteak(guneIzena varchar(30)) returns decimal(8,2)
deterministic
no sql
begin 
declare bt decimal(8,2);

select round((sum(year(curdate()) - t.sorreraUrtea) / count(t.sorreraUrtea)),2) into bt from talde t inner join kontzertu k on t.idtalde = k.idtalde inner join eszenatoki e on k.ideszenatoki = e.ideszenatoki inner join gune g on e.idgune = g.idgune where g.izena = guneIzena;

return bt;

end //
delimiter ;


select BBUrteak("LandaLuzea") as BatazBesteko;



#5)
delimiter //
create procedure antolakuntza(mEzizena varchar(30))
begin
declare izenataldea varchar(30);
declare kontzertuarenData date;
declare zeinordua time;
select t.izena, k.eguna, k.ordua into izenataldea, kontzertuarenData, zeinordua from kontzertu k inner join kolaborazio ko on k.idkontzertu = ko.idkontzertu inner join musikari m on ko.idmusikari = m.idmusikari inner join talde t on k.idtalde = t.idtalde where m.ezizena = mEzizena;

select concat("Taldearen izena: " , izenataldea , " Kontzertu data: " , kontzertuarenData , " eta Ordua: " , zeinordua) as Datuak;
end //
delimiter ;

call antolakuntza("AitorGo");



#6)
set sql_safe_updates = 0;
delimiter //
create trigger denboraGehitu
before insert on kolaborazio
for each row
begin
update kontzertu set iraupena = iraupena + 5;
end //
delimiter ;
insert into kolaborazio values(4,7,90);

delimiter //
create trigger denboraKendu
before delete on kolaborazio
for each row
begin
update kontzertu set iraupena = iraupena - 5;
end //
delimiter ;

delete from kolaborazio where idmusikari = 1;


#7)
delimiter //
create trigger kontzertuarenIraupena
before insert on kontzertu
for each row
begin
declare iraupenatotala int;
select iraupena into iraupenatotala from kontzertu;

if (iraupenatotala > 120) then
insert into kontzertu set iraupena = 120;
end if;
end //
delimiter ;