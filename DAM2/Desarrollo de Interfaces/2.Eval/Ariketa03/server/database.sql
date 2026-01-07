-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS tareas_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Usar la base de datos
USE tareas_db;

-- Crear la tabla de tareas
CREATE TABLE IF NOT EXISTS tareas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    completada TINYINT(1) DEFAULT 0,
    fecha_creacion VARCHAR(20) NOT NULL,
    prioridad ENUM('baja', 'media', 'alta') DEFAULT 'media',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insertar datos de ejemplo
INSERT INTO tareas (titulo, descripcion, completada, fecha_creacion, prioridad) VALUES
('Aprender Angular 19', 'Estudiar las nuevas características de Angular 19 y crear un proyecto de ejemplo con las mejores prácticas', 0, '07/01/2026', 'alta'),
('Hacer ejercicio', 'Ir al gimnasio por la tarde y hacer 30 minutos de cardio más entrenamiento de fuerza', 1, '06/01/2026', 'media'),
('Comprar despensa', 'Comprar frutas, verduras, proteínas y productos básicos para la semana', 0, '07/01/2026', 'media'),
('Revisar correos', 'Responder correos pendientes del trabajo y organizar la bandeja de entrada', 1, '05/01/2026', 'baja'),
('Preparar presentación', 'Crear presentación para la reunión del viernes sobre el proyecto CRUD con actualización en tiempo real', 0, '07/01/2026', 'alta');
