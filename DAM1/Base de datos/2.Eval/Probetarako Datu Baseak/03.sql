use db_probak_03;

select *
from departamentuak inner join langileak on departamentuak.Kode = langileak.Kod_dep;


select *
from langileak left outer join departamentuak on langileak.kod_dep = departamentuak.kode;


select *
from langileak right outer join departamentuak on langileak.kod_dep = departamentuak.kode;
