DROP DATABASE IF EXISTS prueba;
CREATE DATABASE IF NOT EXISTS prueba CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;

USE prueba;

CREATE TABLE Clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL CHECK (email LIKE '%_@_%._%'),
    telefono VARCHAR(9) NULL CHECK (telefono REGEXP '^[0-9]{9}$')
);

CREATE TABLE Reservas (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    fecha_reserva DATE NOT NULL,
    total DECIMAL(10 , 2 ) NOT NULL CHECK (total > 1),
    CONSTRAINT fk_cliente FOREIGN KEY (id_cliente)
        REFERENCES Clientes (id_cliente)
        ON DELETE CASCADE
);


CREATE TABLE Servicios (
    id_servicio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo ENUM('Vuelo', 'Hotel', 'Tour'),
    precio DECIMAL(10 , 2 )
);

CREATE TABLE Detalle_Reserva (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_reserva INT,
    id_servicio INT,
    cantidad INT NOT NULL CHECK (cantidad > 0),
    CONSTRAINT fk_reserva FOREIGN KEY (id_reserva)
        REFERENCES Reservas (id_reserva),
    CONSTRAINT fk_servicio FOREIGN KEY (id_servicio)
        REFERENCES Servicios (id_servicio)
);
-- Insertar clientes
INSERT INTO Clientes (nombre, email, telefono) 
VALUES 
    ('Juan Pérez', 'juanperez@example.com', '612345678'),
    ('Ana Gómez', 'anagomez@example.com', '623456789'),
    ('Carlos López', 'carloslopez@example.com', '634567890');

-- Insertar servicios
INSERT INTO Servicios (nombre, tipo, precio) 
VALUES 
    ('Vuelo a París', 'Vuelo', 150.50),
    ('Hotel en Madrid', 'Hotel', 85.00),
    ('Tour en Barcelona', 'Tour', 45.00);

-- Insertar reservas
INSERT INTO Reservas (id_cliente, fecha_reserva, total) 
VALUES 
    (1, CURDATE(), 150.50),
    (2, CURDATE(), 170.00),
    (3, CURDATE(), 130.00);

-- Insertar detalles de las reservas (con los servicios contratados)
INSERT INTO Detalle_Reserva (id_reserva, id_servicio, cantidad) 
VALUES 
    (1, 1, 1),  -- Juan Pérez reserva un vuelo
    (1, 2, 1),  -- Juan Pérez también reserva un hotel
    (2, 2, 2),  -- Ana Gómez reserva dos noches de hotel
    (3, 3, 1);  -- Carlos López reserva un tour


#Ejercicios:


#Select

#a) Obtener el nombre de los clientes y el total de su reserva más reciente.
SELECT 
    nombre, r.total
FROM
    clientes c
        INNER JOIN
    reservas r ON c.id_cliente = r.id_cliente;


#b)
SELECT 
    nombre, SUM(DR.cantidad) AS 'Cantidad Total'
FROM
    servicios S
        INNER JOIN
    Detalle_Reserva DR ON S.id_servicio = DR.id_servicio
GROUP BY nombre;


#c)
	SELECT 
    c.nombre,
    s.nombre AS 'Servicio',
    dr.cantidad,
    r.fecha_reserva
FROM
    clientes c
        INNER JOIN
    reservas r ON c.id_cliente = r.id_cliente
        INNER JOIN
    detalle_reserva dr ON r.id_reserva = dr.id_reserva
        INNER JOIN
    servicios s ON dr.id_servicio = s.id_servicio
ORDER BY r.fecha_reserva DESC;


#d)

SELECT 
    c.nombre, dr.cantidad, sum(dr.cantidad * s.precio) as "Total Gastado"
FROM
    clientes c
        INNER JOIN
    reservas r ON c.id_cliente = r.id_cliente
        INNER JOIN
    detalle_reserva dr ON r.id_reserva = dr.id_reserva
        INNER JOIN
    servicios s ON dr.id_servicio = s.id_servicio
    group by c.nombre, dr.cantidad;
    
    
    
    SELECT 
    c.nombre AS 'Cliente',
    SUM(dr.cantidad * s.precio) AS 'Total Reserva'
FROM
    clientes c
        INNER JOIN
    reservas r ON c.id_cliente = r.id_cliente
        INNER JOIN
    detalle_reserva dr ON r.id_reserva = dr.id_reserva
        INNER JOIN
    servicios s ON dr.id_servicio = s.id_servicio
GROUP BY c.nombre;






#Update

#a) Actualizar el precio del "Vuelo a París" a 160.00.

select * from Servicios;

SET SQL_SAFE_UPDATES = 0;
start transaction;
update Servicios
set precio = 160
where nombre = "Vuelo a París";
rollback;


#b)
select * from Detalle_Reserva;

SET SQL_SAFE_UPDATES = 0;
start transaction;
update Detalle_Reserva
set cantidad = 3
where id_reserva = (select id_reserva from reservas where id_cliente = (select id_cliente from clientes where nombre like "%Ana%"));
rollback;


#c)
select * from clientes;

SET SQL_SAFE_UPDATES = 0;
start transaction;
update clientes
set telefono = 699123456
where nombre like "%Juan%";
rollback;



#d)

select * from reservas;


SET SQL_SAFE_UPDATES = 0;

start transaction;
update reservas
set total = 140 
where id_cliente = (select id_cliente from clientes where nombre like "%Carlos%" );
rollback;


#e)
select * from Servicios;

SET SQL_SAFE_UPDATES = 0;

start transaction;
update Servicios
set tipo = "Vuelo"
where nombre = "Tour en Barcelona";
rollback;





#Delete


#a)
select * from reservas;

start transaction;
delete from 
reservas
where id_cliente = (select id_cliente from clientes where nombre like "%Carlos%");

rollback;



#Update

#a) Actualizar el precio del "Vuelo a París" a 160.00.

select * from Servicios;

SET SQL_SAFE_UPDATES = 0;
start transaction;
update Servicios
set precio = 160
where nombre = "Vuelo a París";
rollback;


#b)
select * from Detalle_Reserva;

SET SQL_SAFE_UPDATES = 0;
start transaction;
update Detalle_Reserva
set cantidad = 3
where id_reserva = (select id_reserva from reservas where id_cliente = (select id_cliente from clientes where nombre like "%Ana%"));
rollback;


#c)
select * from clientes;

SET SQL_SAFE_UPDATES = 0;
start transaction;
update clientes
set telefono = 699123456
where nombre like "%Juan%";
rollback;



#d)

select * from reservas;


SET SQL_SAFE_UPDATES = 0;

start transaction;
update reservas
set total = 140 
where id_cliente = (select id_cliente from clientes where nombre like "%Carlos%" );
rollback;









#Mas Ejercicios

#Select

#1)
SELECT 
    c.nombre, sum(dr.cantidad) as "Num_Servicios", (sum(dr.cantidad) * s.precio) as "total_gastado"
FROM
    clientes c
        INNER JOIN
    reservas r ON c.id_cliente = r.id_cliente
        INNER JOIN
    detalle_reserva dr ON r.id_reserva = dr.id_reserva
        INNER JOIN
    servicios s ON dr.id_servicio = s.id_servicio
    group by c.nombre, s.precio
    having (sum(dr.cantidad) > 1);


#2)
SELECT 
    c.nombre,
    s.nombre,
    dr.cantidad,
    (s.precio * dr.cantidad) AS 'Precio_Total'
FROM
    clientes c
        INNER JOIN
    reservas r ON c.id_cliente = r.id_cliente
        INNER JOIN
    detalle_reserva dr ON r.id_reserva = dr.id_reserva
        INNER JOIN
    servicios s ON dr.id_servicio = s.id_servicio
WHERE
    s.nombre LIKE '%Hotel%'
ORDER BY Precio_Total DESC;


#3)
	SELECT 
		c.nombre AS 'nombre_cliente', (s.precio * sum(dr.cantidad)) as "total_reserva", s.nombre as "nombre_servicio", dr.cantidad
	FROM
		clientes c
			INNER JOIN
		reservas r ON c.id_cliente = r.id_cliente
			INNER JOIN
		detalle_reserva dr ON r.id_reserva = dr.id_reserva
			INNER JOIN
		servicios s ON dr.id_servicio = s.id_servicio
        group by c.nombre, s.precio, s.nombre, dr.cantidad;



#Update


#1)
select * from servicios;

start transaction;
update servicios
set precio = precio * 1.15
where precio < 100;
rollback;


#2)
start transaction;
select * from detalle_reserva;
UPDATE detalle_reserva dr
JOIN reservas r ON dr.id_reserva = r.id_reserva
JOIN clientes c ON r.id_cliente = c.id_cliente
JOIN servicios s ON dr.id_servicio = s.id_servicio
SET dr.cantidad = 3  -- Nuevas cantidad del servicio
WHERE c.nombre = 'Ana Gómez'
  AND s.nombre = 'Hotel en Madrid'
  AND r.total > 200;
rollback;