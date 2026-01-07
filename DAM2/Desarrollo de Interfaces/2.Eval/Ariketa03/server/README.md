# Configuración del Servidor Backend PHP

## Requisitos
- XAMPP con MySQL y Apache instalado

## Pasos de instalación

### 1. Importar la base de datos
1. Abre **phpMyAdmin** (http://localhost/phpmyadmin)
2. Haz clic en "Nuevo" para crear una base de datos
3. O simplemente importa el archivo `database.sql`:
   - Ve a la pestaña "SQL"
   - Copia y pega el contenido de `server/database.sql`
   - Haz clic en "Continuar"

### 2. Copiar archivos PHP a XAMPP
Hay dos opciones:

#### Opción A: Copiar la carpeta del proyecto
Copia toda la carpeta `Ariketa03` a `C:\xampp\htdocs\`

La API estará disponible en: `http://localhost/Ariketa03/server/api.php`

#### Opción B: Copiar solo la carpeta server
Copia la carpeta `server` a `C:\xampp\htdocs\tareas-api\`

La API estará disponible en: `http://localhost/tareas-api/api.php`

### 3. Iniciar servicios XAMPP
1. Abre el **Panel de Control de XAMPP**
2. Inicia **Apache** y **MySQL**

### 4. Configurar la URL de la API en Angular
La configuración ya está lista. La aplicación Angular apuntará a:
- `http://localhost/Ariketa03/server/api.php`

Si usaste la opción B, deberás cambiar la URL en el servicio Angular.

### 5. Probar la API
Puedes probar la API directamente en el navegador:
- GET todas las tareas: http://localhost/Ariketa03/server/api.php
- GET una tarea: http://localhost/Ariketa03/server/api.php?id=1

## Configuración de la Base de Datos

Si necesitas cambiar las credenciales de MySQL, edita `server/config.php`:

```php
define('DB_HOST', 'localhost');
define('DB_USER', 'root');
define('DB_PASS', '');  // Cambiar si tienes contraseña
define('DB_NAME', 'tareas_db');
```

## Endpoints de la API

- `GET /api.php` - Obtener todas las tareas
- `GET /api.php?id={id}` - Obtener una tarea específica
- `POST /api.php` - Crear nueva tarea
- `PUT /api.php?id={id}` - Actualizar tarea
- `DELETE /api.php?id={id}` - Eliminar tarea
