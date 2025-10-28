use mysql;

#a)
CREATE ROLE RolGizaBaliabideak;

GRANT SELECT ON db_enpresa.* TO RolGizaBaliabideak;

grant insert, update(postua, idBurua, soldata, komisioa, saila) on db_enpresa.langilea to RolGizaBaliabideak;

grant create, drop, alter on db_enpresa.* TO RolGizaBaliabideak;


#b)
create user 'GB1' identified by '1234', 'GB2' identified by '1234', 'GB3' identified by '1234'
default role RolGizaBaliabideak
password expire interval 30 day;


#c)
use db_enpresa;

select * from saila;

update langilea
set soldata = soldata + 10;