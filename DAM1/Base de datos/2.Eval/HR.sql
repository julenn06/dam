use hr;

#1
select first_name, last_name, department_id, department_name
from employees inner join departments using (department_id);


#2
select first_name, last_name, city, region_name
from employees inner join departments using (department_id)
inner join locations using (location_id)
inner join countries using (country_id)
inner join regions using (region_id);


#3
select first_name, last_name, salary
from employees;


#4
select first_name, last_name, department_id, department_name
from employees inner join departments using (department_id)
where department_id = 40 or department_id = 80;


#5
select first_name, last_name, department_name, city, state_province
from employees inner join departments using (department_id)
inner join locations using (location_id)
where first_name like "%z%";


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
                
                
#8
select concat(e1.first_name, ' ', e1.last_name) as langilea, concat(e2.first_name, ' ', e2.last_name) as manager
from employees e1 inner join employees e2 on e2.employee_id = e1.manager_id;


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
select job_history.*, first_name, last_name
from job_history inner join employees using (employee_id)
where salary > 12000
order by salary asc;


#23
SELECT 
    employee_id, 
    department_name, 
    ROUND((DATEDIFF(CURDATE(), hire_date) / 365), 1) AS LanUrteak
FROM 
    employees 
INNER JOIN 
    departments USING (department_id);


#27
select concat(first_name, " ", last_name) as izenOsoa, country_id, country_name
from employees inner join departments using (department_id)
inner join locations using (location_id)
inner join countries using (country_id);