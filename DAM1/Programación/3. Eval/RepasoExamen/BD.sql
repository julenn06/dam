CREATE DATABASE Escuela;
USE Escuela;

CREATE TABLE profesores (
    id_profesor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    aula INT
);

CREATE TABLE alumnos (
    id_alumno INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    curso VARCHAR(20),
    aula INT
);

INSERT INTO profesores (nombre, apellido, aula) VALUES
('Laura', 'Martínez', 10),
('Carlos', 'Gómez', 5),
('Elena', 'Ruiz', 7),
('Miguel', 'Pérez', 3),
('Sofía', 'Navarro', 1),
('Andrés', 'Torres', 0);

INSERT INTO alumnos (nombre, apellido, curso, aula) VALUES
('Ana', 'López', '1º ESO', 10),
('Pedro', 'Sánchez', '1º ESO', 10),
('Lucía', 'Moreno', '2º ESO', 10),
('Mario', 'Fernández', '2º ESO', 0),
('Laura', 'Jiménez', '2º ESO', 0),
('Raúl', 'García', '3º ESO', 5),
('Eva', 'Castro', '3º ESO', 3);
