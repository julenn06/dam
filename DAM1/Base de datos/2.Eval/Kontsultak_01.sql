use hr;

#1
select * 
from employees;


#2
select *
from departments;


#3
select *
from employees
where job_id = "PU_CLERK" or job_id = "SH_CLERK" or job_id = "ST_CLERK";


#3.2
select *
from employees
where job_id like "%CLERK";
#% Edozein karaktere n aldiz
#_ Edozein karaktere behin

#3.3
select *
from employees
where job_id like "___CLERK";




#4
select *
from employees
where job_id like "___CLERK"
order by first_name asc;


#5
select *
from employees
where job_id like "___CLERK"
order by 2 asc;


#6
select first_name, employee_id, salary
from employees;


#7
select department_name
from departments;


#8
select department_name
from departments
order by 1;


#9
select department_name
from departments
order by location_id;


#10
select department_name
from departments
order by location_id desc;


#11
select first_name, job_id
from employees
order by salary;


#12
select first_name, job_id
from employees
order by job_id, salary;


#13
select first_name, job_id
from employees
order by job_id desc, salary asc;
describe employees;


#14
select salary, commission_pct
from employees
where department_id = 30;


#15
select salary, commission_pct
from employees
where department_id = 30
order by commission_pct;


#16
select distinct commission_pct
from employees;
#Distinct balioak ez errepikatzeko


#17
select distinct first_name, commission_pct
from employees;


#18
select distinct first_name, salary
from employees;


#19
select distinct commission_pct, department_id
from employees;


#20
select first_name
from employees
where commission_pct > 0.5;


#21
select first_name
from employees
where commission_pct is null or commission_pct <=0.25;


#22
select employee_id, salary, commission_pct
from employees
where employee_id > 200;


#23
select *
from employees
where first_name >= 'J';


#24
select salary, commission_pct commission, salary + (salary * commission_pct) as "Total Salary"
from employees
where commission_pct is not null
order by employee_id;


#25
select salary, commission_pct commission, salary + (salary * commission_pct) as "Total Salary"
from employees
where commission_pct is null
order by employee_id;


#26
select first_name
from employees
where manager_id = 120 and salary > 1000
order by employee_id;


#27
select *
from employees
where employee_id <> 120 or salary <= 1000
# where NOT (manager_id = 120 and salary > 1000)
order by employee_id;


#28
select first_name, concat( (commission_pct * 100), '%' )as commissionPCT
from employees
order by commission_pct;


#29
select first_name
from employees
where department_id = 10 and first_name not like '%LA%';


#30
select  concat (first_name, ' ', last_name) as employee
from employees
where manager_id is null;


#31
select department_name
from departments
where not (department_name = 'Sales' or department_name = 'Human Resources');


#32
select first_name, manager_id
from employees
where department_id != 10 and salary > 800
order by hire_date;


#33
select first_name, salary / commission_pct as zatidura
from employees
where commission_pct != 0
order by first_name;


#34
select *
from employees
where first_name like "_____";


#35
select *
from employees
where first_name like "_____%";


#36
select *
from employees
where (first_name like "A%" and salary > 1000) or (commission_pct !=0 and department_id = 80);


#37


#40
select *
from employees
where first_name like 'A%' and job_id like '%NAN';


#42
select concat (first_name, ' ', last_name) as employee
from employees
where employee_id in (78, 79, 75, 72, 177, 179, 178, 69);


#43
select concat(first_name, ' ', last_name) as employee, salary, department_id
from employees
where manager_id > employee_id and (salary between 1000 and 2000) or department_id = 30;