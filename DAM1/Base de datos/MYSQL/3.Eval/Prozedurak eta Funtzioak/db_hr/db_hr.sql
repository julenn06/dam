use hr;

#01. Ariketa
delimiter //
drop procedure if exists SoldataAldatu //
create procedure SoldataAldatu()
begin

declare soldata120 decimal(8,2);
declare soldata122 decimal(8,2);

select salary into soldata120
from employees
where employee_id = 120;

select salary into soldata122
from employees
where employee_id = 122;

update employees
set salary = soldata122
where employee_id = 120;

update employees
set salary = soldata120
where employee_id = 122;

end
//

call SoldataAldatu();