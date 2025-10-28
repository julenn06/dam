use hr;

#1
delimiter //
drop procedure if exists langileSoldata //
create procedure langileSoldata(in SoldataMax decimal(8,2), in SoldataMin decimal(8,2))
begin

declare izena varchar(20);
declare abizena varchar(25);
declare soldata decimal(8,2);
declare departamentua varchar(30);

select first_name, last_name, salary, department_name 
into izena, abizena, soldata, departamentua 
from employees join departments using (department_id) where salary between SoldataMin and SoldataMax;

select concat(izena, " ", abizena, ". Soldata: ", soldata, ". Departamentua: ", departamentua) as Emaitza;
end //

call langileSoldata(2100, 2400);


#kurtsorea
delimiter //
drop procedure if exists langileSoldata//
create procedure langileSoldata
(in SoldataMin decimal(8,2), in SoldataMax decimal(8,2))
begin
declare izena varchar(20);
declare abizena varchar(25);
declare soldata decimal(8,2);
declare departamentua varchar(30);
declare amaiera boolean default 1;

declare c cursor for
select first_name, last_name, salary, department_name
from employees join departments using (department_id)
where salary between SoldataMin and SoldataMax;

declare continue handler for not found
set amaiera = 0;
declare exit handler for 1329
select "Ez dago soldata hori duen langilerik" as ErroreMezua;

open c;
while amaiera = 1 do
fetch c into izena, abizena, soldata, departamentua;
select concat(izena, " ", abizena ,". Soldata: ", soldata, ". Departamentua: ", departamentua)
as Emaitza;
end while;

close c;
end//

call langileSoldata(2100, 2100);
call langileSoldata(2100, 2900);
call langileSoldata(1600, 2000);



#2
delimiter //
drop procedure if exists langileGehien //
create procedure langileGehien ()
begin

declare langileKop int;
declare depto_izena varchar(30);
declare soldata decimal(8,2);
declare amaiera boolean default 0;

declare c cursor for
select count(employee_id), department_name, avg(salary)
from employees join departments using (department_id)
group by department_name
order by count(employee_id) desc
limit 2;

declare continue handler for not found
set amaiera = 1;

open c;


fetch c into langileKop, depto_izena, soldata;

while amaiera = 0 do
select concat(depto_izena, "k duen langile kopurua: ", langileKop,
" eta batazbesteko soldata: ", soldata) as Emaitza;
fetch c into langileKop, depto_izena, soldata;
end while;
close c;

end //

call langileGehien();


#3
delimiter //
drop procedure if exists langileDatuak //
create procedure langileDatuak(in n int)
begin
declare amaiera boolean default 0;
declare izena varchar(20);
declare lana varchar(25);
declare salary decimal(9,2);
end //