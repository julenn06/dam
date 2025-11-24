use hr;


#1
select first_name, last_name
from employees
where salary > (select salary
				from employees where 
				employee_id = 163);
                
                
#2
select first_name, last_name, salary, department_id, job_id
from employees
where department_id in (select department_id
from employees
where employee_id = 169);


#3
select concat(first_name, " ", last_name) as IzenAbizena, employee_id, salary
from employees
where manager_id in (select employee_id 
					from employees
					where first_name = "Payam");
                    

#4
select concat(first_name, " ", last_name) as IzenAbizena
from employees
where department_id in (select department_id
						from departments
                        where department_name = "Finance");
                        
                        
#5
select *
from employees
where department_id = 134 or department_id = 159 or department_id = 183;


#6
select *
from employees
where department_id not in (select department_id
					from departments
                    where manager_id between 100 and 200);
                    
                    
#7
select * 
from employees
where department_id in (select department_id
		from employees
        where first_name like "%t%");
        
        
#8
select first_name, last_name, employee_id, job_id
from employees
where department_id = (select department_id
						from locations
                        where city = "Toronto");
                        
                        
#9
select first_name, last_name, salary
from employee
where salary > (0);


#10