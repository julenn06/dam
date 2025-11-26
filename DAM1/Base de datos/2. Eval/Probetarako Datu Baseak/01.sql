use db_probak_01;

select Kod_langilea, Izena, Abizena, Saila
from departamentuak, langileak
where departamentuak.Kod_dep = langileak.Kod_dep;

select Kod_langilea, Izena, Abizena, Saila
from departamentuak natural join langileak;


select *
from departamentuak inner join langileak using (Kod_dep);