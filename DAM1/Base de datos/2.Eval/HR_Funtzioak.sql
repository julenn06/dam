use hr;


SELECT 
    *
FROM
    employees
WHERE
    LENGTH(first_name) > 8;


SELECT 
    first_name, last_name, employee_id, MONTH(hire_date)
FROM
    employees;


SELECT 
    SUBSTRING(phone_number, - 4), phone_number
FROM
    employees;


SELECT 
    first_name, LENGTH(first_name)
FROM
    employees
WHERE
    first_name LIKE 'J%'
        OR first_name LIKE 'M%'
        OR first_name LIKE 'A%'
ORDER BY 1;


SELECT 
    first_name, last_name, MONTHNAME(hire_date)
FROM
    employees
WHERE
    MONTH(hire_date) = 6
ORDER BY hire_date;


SELECT 
    job_id, GROUP_CONCAT(employee_id)
FROM
    employees
GROUP BY job_id;