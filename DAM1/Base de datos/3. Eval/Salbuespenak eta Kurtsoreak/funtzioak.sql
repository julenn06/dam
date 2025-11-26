use hr;

#01
delimiter //
drop procedure if exists DptoIzenaHerria //
create procedure DptoIzenaHerria(in dpto_id int) 
begin

declare aurkitua boolean default 1;
declare herria varchar(30);
declare izena varchar(30);

declare continue handler for 1329
set aurkitua = 1;

SELECT 
    city, department_name
INTO herria , izena FROM
    departments
        JOIN
    locations USING (location_id)
WHERE
    department_id = dpto_id;

if aurkitua = 0 then
SELECT 
    CONCAT(dpto_id,
            ' departamentuaren izena: ',
            izena, ' da. Eta ',
            herria,
            'n dago') as Mezua;
else
select concat(dpto_id, ' Departamentuaren izena ez da datu basean existitzen.') as Errorea;
end if;
end //

call DptoIzenaHerria(80);


#2)
delimiter //
drop procedure if exists dptoDesk //
create procedure dptoDesk (in dpto_id int, in dpto_desk varchar(30))
begin
declare izena varchar(30);
declare aurkitua boolean default 0;
declare continue handler for 1329
set aurkitua = 1;
SELECT 
    department_name
INTO izena FROM
    departments
WHERE
    department_id = dpto_id;
if aurkitua = 1 then
select ("errorea: departamentua ez da existitzen") as ErroreMezua;
else
if izena = dpto_desk then
select ("ezin da departamentuaren izena aldatu") as ErroreMezua2;
else
update departments
set department_name = dpto_desk
where department_id = dpto_id;
SELECT 
    CONCAT(dpto_id,
            ' departamentuaren izena aldatu egin da.') AS Mezua;
end if;
end if;

end
//
call dptoDesk (80, "SalesProba");
call dptoDesk (80, "Sales");
call dptoDesk (1200, "Sales"); 