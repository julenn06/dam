#hr KONTSULTAK

#1
select first_name, last_name, department_id, department_name
from employees inner join departments USING (department_id);

#2
select first_name, last_name, department_name, city, region_name
from employees inner join departments using (department_id)
				inner join locations using (location_id)
                inner join countries using (country_id)
                inner join regions using (region_id);
                
#3
select first_name as izena, last_name as abizena, concat(round(salary,0), " €") as soldata
from employees;

#4
select first_name as izena, last_name as abizena, department_id as 'kode departamentu', department_name as 'departamentu izena'
from employees inner join departments using (department_id)
where department_id = 80 or department_id = 40;

#5
select first_name as izena, last_name as abizena, department_name as 'departamentu izena', city as hiria, state_province as 'estatuko probintzia'
from employees inner join departments using (department_id)
				inner join locations using (location_id)
where first_name like '%z%';

#6
select first_name, last_name, employee_id, department_name, d.department_id
from employees as e right outer join departments as d on e.department_id = d.department_id
where employee_id is null;

#7
select employee_id, first_name, last_name, salary
from employees
where salary < (select salary
				from employees
                where employee_id = 182);

#8 (REFLEXIBOA)
select concat(e1.first_name, ' ', e1.last_name) as langilea, concat(e2.first_name, ' ', e2.last_name) as manager
from employees as e1 inner join employees as e2 on e2.employee_id = e1.manager_id;

#9
select department_name, city, state_province
from departments inner join locations using (location_id);
                
#10
select first_name, last_name, department_id, department_name
from employees left outer join departments using (department_id);

#11
select concat(e1.first_name, e1.last_name) as langilea, concat(e2.first_name, e2.last_name) as manager
from employees as e1 left outer join employees e2 on e2.employee_id = e1.manager_id;

#12
# se utiliza 'in' en vez de '=' porque me tiene que devolver mas de un valor
select first_name, last_name, department_id
from employees
where department_id in (select department_id
						from employees
                        where last_name = 'Taylor');
                        
#14
select first_name, last_name, job_title, max_salary - salary
from employees inner join jobs using (job_id)
order by max_salary - salary asc;

#16
select concat(first_name, ' ', last_name) as langilea, job_title, concat(max_salary - salary) as 'soldata aldeak', department_id
from employees inner join jobs using (job_id)
where department_id = 80
order by (max_salary - salary) asc;

#17
select city, country_name, department_name
from departments inner join locations using (location_id)
				inner join countries using (country_id);
                
#18
select department_name, departments.manager_id, concat(first_name, ' ', last_name) as manager
from employees inner join departments on departments.manager_id = employees.employee_id;

#20
select job_history.*, first_name, last_name, salary
from job_history inner join employees using (employee_id)
where salary >= 12000
order by salary asc;

#27
select concat(first_name, ' ', last_name) as langilea, country_id, country_name
from employees inner join departments using (department_id)
				inner join locations using (location_id)
				inner join countries using (country_id);
                
#23
select employee_id, job_id, current_date(), hire_date, datediff(current_date(), hire_date) as datak
from employees
where department_id = 80;


#AZPIKONTSULTAK
#1
select first_name, last_name
from employees
where salary > (select salary
				from employees
				where employee_id = 163);
                
#2
select concat(first_name, ' ', last_name) as langilea, salary, department_id, job_id
from employees
where department_id in (select department_id
						from employees
						where employee_id = 169);

select employee_id, department_id
from employees
where employee_id = 169;

#3 reflexiba
select concat(first_name, ' ', last_name) as langilea, employee_id, salary
from employees
where manager_id in (select employee_id
					from employees
                    where first_name = 'Payam'
                    order by salary asc );
                    
#4
select concat(first_name, ' ', last_name) as langilea, department_id, department_name, job_id
from employees inner join departments using (department_id)
where department_id in (select department_id
							from departments
							where department_name = 'Finance');
                            
select concat(first_name, ' ', last_name) as langilea, department_id, department_name, job_id
from employees inner join departments using (department_id)
where department_name = 'Finance';

#5
select *
from employees
where department_id = 134 or department_id = 159 or department_id = 183;

#in: lista de valores
select *
from employees
where department_id in (134, 159, 183);

#6
select *
from employees
where department_id not in (select department_id
						from departments
						where manager_id between 100 and 200);
					
#7
select employee_id, concat(first_name, ' ', last_name) as langilea, department_id
from employees
where department_id in (select distinct department_id
						from employees
						where first_name like '%T%');
                        
select department_id, first_name
from employees
where first_name like '%T%';

#8
select*
from locations
where city = 'Toronto';

select concat(first_name, ' ', last_name) as langilea, employee_id
from employees
where department_id = (select department_id
						from departments
						where location_id = (select location_id
											from locations
                                            where city = 'Toronto'));
                        
#9
select first_name, last_name, salary
from employees
where salary > (select salary
				from employees
				where last_name = 'Ozer');

#10
select *
from employees
where employee_id = ANY (select manager_id from departments);

select *
from employees
where employee_id in (select manager_id
						from departments);
                        
                        

#FUNTZIOAK
#1
select*
from employees
where length(first_name) >= 8;

#2
select first_name, last_name, employee_id, monthname(hire_date) as hilabetea
from employees;

select first_name, last_name, employee_id, mid(hire_date, 6, 2) as hilabetea
from employees;

#3
select substring(phone_number, -4), phone_number
from employees;

select right(phone_number, 4), phone_number
from employees;

#4 order by 2 ordenar por nombre porque es la segunda columna en el select
select distinct first_name, length(first_name)
from employees
where first_name like 'J%' or first_name like 'M%' or first_name like 'A%'
order by 2;

#5
select first_name, last_name, monthname(hire_date)
from employees
where month(hire_date) = 6
order by hire_date;

#6
select job_id, group_concat(employee_id)
from employees
group by job_id;


#AGREGAZIO FUNTZIOAK
#01 ARIKETA
#1
select job_title, sum(salary) as total_salary
from employees e inner join jobs using (job_id)
				inner join departments d on e.department_id =d.department_id
where department_name = 'Sales'
group by job_id;
    
#2
select department_id, count(employee_id)
from employees
group by department_id;

#3
select concat(first_name, ' ', last_name) as langilea
from employees e1
where salary > (select avg(salary)
				from employees e2
				where e1.department_id = e2.department_id);
                
#5
select department_id, job_id, count(employee_id)
from employees
group by department_id, job_id
having count(employee_id) > 2;



#02 Ariketa: hr datu basea
#1.	Bistaratu zenbat langilek bat egin duten enpresarekin urte bakoitzeko hile bakoitzean.
select * 
from employees;

select year(hire_date), month(hire_date), count(*)
from employees
group by year(hire_date), month(hire_date)
order by year(hire_date), month(hire_date);


#2.	Erakutsi managerraren identifikatzailea eta manager horrek kudeatzen dituen langile kopurua.
select manager_id, count(*)
from employees
where manager_id is not null
group by manager_id
order by COUNT(*) DESC;


#4.	Erakutsi hilabeteen bigarren hamabostaldian bat egin duten langile totalaren kopurua. 
select count(employee_id) as 'langile kopurua', concat(monthname(hire_date), ', (', month(hire_date), ')') as 'hilabetea'
from employees
where day(hire_date) between 15 and 31
group by concat(monthname(hire_date), ', (', month(hire_date), ')');


#5.	Erakutsi country ID eta herrialde bakoitzean datu basean dauden hiri kantitatea. 
select *
from countries;

select *
from locations;

select country_id, count(city) herriak
from locations
group by country_id
order by count(city);


#6. Erakutsi komisioa duten langileen batazbesteko soldata departementuz sailkatuta.
select * 
from departments;

select *
from employees;

select round(avg(salary),2) as 'bb soldata', department_id
from employees
where commission_pct is not null
group by department_id;


#7.	Erakutsi job ID, langile kopurua, soldataren batura, eta lanpostuko soldatarik altuena eta bajuenaren arteko aldea.
select *
from employees;

select job_id, count(*) 'langile kopurua', sum(salary), max(salary) - min(salary) 'max-min soldaten arteko aldea'
from employees
group by job_id
order by count(*) desc;


#8. Erakutsi job_id non lanpostuaren batazbesteko soldata 12000 baino handiagoa den.
select job_id, round(avg(salary), 2) as 'bb soldata'
from employees
group by job_id
having avg(salary) > 12000
order by avg(salary);


#9.	Erakutsi zein urtetan kontratatu diren 10 langile baino gehiago. 
select *
from employees;

select year(hire_date), count(*) 'langile kopurua'
from employees
group by year(hire_date)
having count(*) > 10
order by year(hire_date);


#10. Erakutsi zein departamentutan bere 5 langilek baino gehiagok komisioa kobratzen duten. 
select job_id, commission_pct, count(*) 'langile kopurua'
from employees
where commission_pct is not null
group by job_id, commission_pct
having count(*) > 5;


#11. Erakutsi iraganean lan bat baino gehiago izan duten langileen zerrenda
select employee_id
from job_history
group by employee_id
having count(*) > 1;

select employee_id, concat(first_name, ' ', last_name) as langilea, count(*) as 'lan kopurua'
from job_history inner join employees using (employee_id)
group by employee_id
having count(*) > 1;


#12.1 Erakutsi job ID baldin eta lana 3 pertsonak baino gehiagok egina izan bada 100 egunetan zehar
select *
from job_history;

select job_id, count(employee_id)
from job_history
where (end_date-start_date) >= 100
group by job_id
having count(employee_id) > 3;

#12.2 Erakutsi job ID baldin eta lana 1 pertsonak baino gehiagok egina izan bada 100 egunetan zehar
select *
from job_history;

select job_id, count(employee_id)
from job_history
where (end_date-start_date) >= 100
group by job_id
having count(employee_id) > 1;