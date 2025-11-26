#AGREGAZIO FUNTZIOAK

use hr;

SELECT 
    *
FROM
    employees
ORDER BY salary DESC
LIMIT 1;


SELECT 
    MAX(salary)
FROM
    employees;


SELECT 
    MIN(salary)
FROM
    employees;


SELECT 
    ROUND(AVG(salary), 1)
FROM
    employees;


SELECT 
    COUNT(*)
FROM
    employees;


SELECT 
    MAX(salary), department_id, department_name
FROM
    employees
        INNER JOIN
    departments USING (department_id)
GROUP BY department_id;



SELECT 
    MAX(salary), department_id, department_name, location_id
FROM
    employees
        INNER JOIN
    departments USING (department_id)
GROUP BY department_id , department_name , location_id;






#1
SELECT 
    job_title, SUM(salary) AS total_salary
FROM
    employees e
        INNER JOIN
    jobs USING (job_id)
        INNER JOIN
    departments d ON e.department_id = d.department_id
WHERE
    department_name = 'Sales'
GROUP BY job_id;


#2
SELECT 
    department_id, COUNT(employe_id)
FROM
    employees
GROUP BY department_id;


#3
SELECT 
    CONCAT(first_name, ' ', last_name) AS langilea
FROM
    employees e1
WHERE
    salary > (SELECT 
            AVG(salary)
        FROM
            employees e2
        WHERE
            e1.department_id = e2.department_id);
            
            
#5
select department_id, job_id, count(employee_id)
from employees
group by department_id, job_id
having count(employee_id) > 2;



#2. ARIKETAK

#1
select year(hire_date), month(hire_date), count(employee_id)
from employees
group by year(hire_date), month(hire_date)
order by 1, 2;


#2
select manager_id, count(employee_id)
from employees
where manager_id is not null
group by manager_id;


#4
SELECT 
    COUNT(employee_id), MONTH(hire_date)
FROM
    employees
WHERE
    DAY(hire_date) BETWEEN 15 AND 31
GROUP BY MONTH(hire_date);