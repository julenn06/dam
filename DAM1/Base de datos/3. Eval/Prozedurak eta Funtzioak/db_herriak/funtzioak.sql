use db_herriak;

#01 ARIKETA
delimiter //
drop procedure if exists ErkidegoaXehetasuna //
create procedure ErkidegoaXehetasuna (in izenaE varchar(20))
begin

declare probintzia_kop int;
declare herria_kop int;

select count(kod_probintzia) into probintzia_kop
from komunitateak inner join probintziak using(id_erkidegoa)
where id_erkidegoa = (select id_erkidegoa
                        from komunitateak
                        where izena = izenaE);

if probintzia_kop = 0 then
    select concat(izenaE, " erkidegoa ez dago datu basean") as Mezua;
else
    select count(herriak.id_herria) into herria_kop
    from komunitateak inner join probintziak using(id_erkidegoa)
                        inner join herriak using(kod_probintzia)
    where id_erkidegoa = (select id_erkidegoa
                            from komunitateak
                            where izena = izenaE);
    select concat(izenaE, " erkidegoak dituen probntzia kopurua: ",probintzia_kop, " ; eta herri kopurua: ", herria_kop) as Mezua;
end if;
end
//

call ErkidegoaXehetasuna('Galizia');
call ErkidegoaXehetasuna('Galiz');


#02 ARIKETA
delimiter //
drop procedure if exists ProbintziaNagusi //
create function ProbintziaNagusi (izenaE varchar(20))
returns varchar(20)
reads sql data
begin

declare izenaProb varchar(20);

select izena into izenaProb
from probintziak
where id_erkidegoa = (select id_erkidegoa
                        from komunitateak
                        where izena = izenaE)
and azalera = (select max(azalera)
                from probintziak
                where id_erkidegoa = (select id_erkidegoa
                                        from komunitateak
                                        where izena = izenaE));

return izenaProb;

end
//

select* from komunitateak;

select ProbintziaNagusi('Extremadura');