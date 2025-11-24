drop database if exists prueba2;
create database if not exists prueba2
charset utf8mb4
collate utf8mb4_spanish_ci;

use prueba2;

CREATE TABLE Clientes (
    id_cliente INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL CHECK (email LIKE '%@%'),
    telefono VARCHAR(9) CHECK (telefono REGEXP '^[0-9]{9}$'),
    direccion VARCHAR(50)
);

CREATE TABLE Productos (
    id_producto INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    precio DECIMAL(10 , 2 ) NOT NULL,
    categoria VARCHAR(50),
    stock INT DEFAULT 0
);

CREATE TABLE Pedidos (
    id_pedido INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_cliente INT NOT NULL,
    fecha_pedido DATE NOT NULL,
    estado ENUM('Preparando', 'Pendiente', 'Enviando') NOT NULL DEFAULT 'Pendiente',
    precio DECIMAL(10 , 2 ) NOT NULL,
    CONSTRAINT fk_id_cliente FOREIGN KEY (id_cliente)
        REFERENCES Clientes (id_cliente)
);

CREATE TABLE Detalle_Pedidos (
    id_detalle INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10 , 2 ) NOT NULL,
    CONSTRAINT fk_id_pedido_Detalle FOREIGN KEY (id_pedido)
        REFERENCES Pedidos (id_pedido),
    CONSTRAINT fk_id_producto FOREIGN KEY (id_producto)
        REFERENCES Productos (id_producto)
);

CREATE TABLE Pagos (
    id_pago INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    id_pedido INT NOT NULL,
    fecha_pago DATE NOT NULL,
    monto DECIMAL(10 , 2 ) NOT NULL,
    metodo_pago VARCHAR(25),
    CONSTRAINT fk_id_pedido_Pagos FOREIGN KEY (id_pedido)
        REFERENCES Pedidos (id_pedido)
);


INSERT INTO Clientes (nombre, email, telefono, direccion) VALUES
('Juan Pérez', 'juan.perez@example.com', '612345678', 'Calle Mayor 123, Madrid'),
('Ana Gómez', 'ana.gomez@example.com', '634567890', 'Avenida Andalucía 45, Sevilla'),
('Carlos López', 'carlos.lopez@example.com', NULL, 'Plaza Catalunya 10, Barcelona'),
('María Fernández', 'maria.fernandez@example.com', '698745632', 'Gran Vía 88, Valencia'),
('Pedro Martínez', 'pedro.martinez@example.com', '625478963', 'Calle Serrano 5, Bilbao');

INSERT INTO Productos (nombre, precio, categoria, stock) VALUES
('Smartphone Samsung', 599.99, 'Electrónica', 20),
('Portátil HP', 899.00, 'Informática', 15),
('Auriculares Sony', 99.50, 'Electrónica', 50),
('Silla Gaming', 199.99, 'Muebles', 10),
('Teclado Mecánico', 79.99, 'Informática', 30);

INSERT INTO Pedidos (id_cliente, fecha_pedido, estado, precio) VALUES
(1, CURDATE(), 'Pendiente', 699.99),
(2, CURDATE() - INTERVAL 5 DAY, 'Preparando', 99.50),
(3, CURDATE() - INTERVAL 10 DAY, 'Enviando', 899.00),
(4, CURDATE() - INTERVAL 2 DAY, 'Pendiente', 199.99),
(5, CURDATE() - INTERVAL 8 DAY, 'Enviando', 79.99);

INSERT INTO Detalle_Pedidos (id_pedido, id_producto, cantidad, subtotal) VALUES
(1, 1, 1, 599.99),
(2, 3, 2, 199.00),
(3, 2, 1, 899.00),
(4, 4, 1, 199.99),
(5, 5, 1, 79.99);

INSERT INTO Pagos (id_pedido, fecha_pago, monto, metodo_pago) VALUES
(1, CURDATE(), 699.99, 'Tarjeta de crédito'),
(3, CURDATE() - INTERVAL 9 DAY, 899.00, 'PayPal'),
(5, CURDATE() - INTERVAL 7 DAY, 79.99, 'Transferencia bancaria');



#Consultas

	#SELECT
    
#1)Muestra el nombre del cliente, la cantidad total de productos que ha comprado en todos sus pedidos 
# y el monto total gastado. Solo muestra los clientes que hayan comprado más de un producto en total.

SELECT 
    c.nombre,
    SUM(dp.cantidad) AS total_cantidad,
    SUM(pag.monto) AS total_pagado
FROM
    clientes c
        INNER JOIN
    pedidos ped ON c.id_cliente = ped.id_cliente
        INNER JOIN
    Detalle_Pedidos dp ON ped.id_pedido = dp.id_pedido
        INNER JOIN
    pagos pag ON ped.id_pedido = pag.id_pedido
GROUP BY c.nombre
HAVING total_cantidad > 0;