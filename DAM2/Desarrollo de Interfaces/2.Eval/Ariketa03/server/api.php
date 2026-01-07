<?php
require_once 'config.php';

$conn = getConnection();
$method = $_SERVER['REQUEST_METHOD'];
$request = [];

// Obtener el ID si existe en la URL
if (isset($_GET['id'])) {
    $request[] = $_GET['id'];
}

// Parsear el body para POST, PUT, DELETE
$input = json_decode(file_get_contents('php://input'), true);

switch ($method) {
    case 'GET':
        if (!empty($request)) {
            // GET - Obtener una tarea por ID
            getTarea($conn, $request[0]);
        } else {
            // GET - Obtener todas las tareas
            getTareas($conn);
        }
        break;
    
    case 'POST':
        // POST - Crear nueva tarea
        crearTarea($conn, $input);
        break;
    
    case 'PUT':
        // PUT - Actualizar tarea
        if (!empty($request)) {
            actualizarTarea($conn, $request[0], $input);
        } else {
            http_response_code(400);
            echo json_encode(['error' => 'ID requerido para actualizar']);
        }
        break;
    
    case 'DELETE':
        // DELETE - Eliminar tarea
        if (!empty($request)) {
            eliminarTarea($conn, $request[0]);
        } else {
            http_response_code(400);
            echo json_encode(['error' => 'ID requerido para eliminar']);
        }
        break;
    
    default:
        http_response_code(405);
        echo json_encode(['error' => 'Método no permitido']);
        break;
}

// Función para obtener todas las tareas
function getTareas($conn) {
    try {
        $stmt = $conn->prepare("SELECT id, titulo, descripcion, completada, fecha_creacion as fechaCreacion, prioridad FROM tareas ORDER BY id DESC");
        $stmt->execute();
        $tareas = $stmt->fetchAll();
        
        // Convertir completada a boolean
        foreach ($tareas as &$tarea) {
            $tarea['completada'] = (bool)$tarea['completada'];
            $tarea['id'] = (int)$tarea['id'];
        }
        
        echo json_encode($tareas);
    } catch(PDOException $e) {
        http_response_code(500);
        echo json_encode(['error' => 'Error al obtener tareas: ' . $e->getMessage()]);
    }
}

// Función para obtener una tarea por ID
function getTarea($conn, $id) {
    try {
        $stmt = $conn->prepare("SELECT id, titulo, descripcion, completada, fecha_creacion as fechaCreacion, prioridad FROM tareas WHERE id = ?");
        $stmt->execute([$id]);
        $tarea = $stmt->fetch();
        
        if ($tarea) {
            $tarea['completada'] = (bool)$tarea['completada'];
            $tarea['id'] = (int)$tarea['id'];
            echo json_encode($tarea);
        } else {
            http_response_code(404);
            echo json_encode(['error' => 'Tarea no encontrada']);
        }
    } catch(PDOException $e) {
        http_response_code(500);
        echo json_encode(['error' => 'Error al obtener tarea: ' . $e->getMessage()]);
    }
}

// Función para crear una nueva tarea
function crearTarea($conn, $data) {
    try {
        if (!isset($data['titulo']) || !isset($data['descripcion'])) {
            http_response_code(400);
            echo json_encode(['error' => 'Titulo y descripción son requeridos']);
            return;
        }
        
        $stmt = $conn->prepare("INSERT INTO tareas (titulo, descripcion, completada, fecha_creacion, prioridad) VALUES (?, ?, ?, ?, ?)");
        $stmt->execute([
            $data['titulo'],
            $data['descripcion'],
            isset($data['completada']) ? (int)$data['completada'] : 0,
            $data['fechaCreacion'] ?? date('d/m/Y'),
            $data['prioridad'] ?? 'media'
        ]);
        
        $id = $conn->lastInsertId();
        
        // Devolver la tarea creada
        getTarea($conn, $id);
    } catch(PDOException $e) {
        http_response_code(500);
        echo json_encode(['error' => 'Error al crear tarea: ' . $e->getMessage()]);
    }
}

// Función para actualizar una tarea
function actualizarTarea($conn, $id, $data) {
    try {
        // Verificar que la tarea existe
        $stmt = $conn->prepare("SELECT id FROM tareas WHERE id = ?");
        $stmt->execute([$id]);
        
        if (!$stmt->fetch()) {
            http_response_code(404);
            echo json_encode(['error' => 'Tarea no encontrada']);
            return;
        }
        
        // Construir la consulta de actualización dinámicamente
        $fields = [];
        $values = [];
        
        if (isset($data['titulo'])) {
            $fields[] = "titulo = ?";
            $values[] = $data['titulo'];
        }
        if (isset($data['descripcion'])) {
            $fields[] = "descripcion = ?";
            $values[] = $data['descripcion'];
        }
        if (isset($data['completada'])) {
            $fields[] = "completada = ?";
            $values[] = (int)$data['completada'];
        }
        if (isset($data['prioridad'])) {
            $fields[] = "prioridad = ?";
            $values[] = $data['prioridad'];
        }
        
        if (empty($fields)) {
            http_response_code(400);
            echo json_encode(['error' => 'No hay datos para actualizar']);
            return;
        }
        
        $values[] = $id;
        $sql = "UPDATE tareas SET " . implode(', ', $fields) . " WHERE id = ?";
        
        $stmt = $conn->prepare($sql);
        $stmt->execute($values);
        
        // Devolver la tarea actualizada
        getTarea($conn, $id);
    } catch(PDOException $e) {
        http_response_code(500);
        echo json_encode(['error' => 'Error al actualizar tarea: ' . $e->getMessage()]);
    }
}

// Función para eliminar una tarea
function eliminarTarea($conn, $id) {
    try {
        $stmt = $conn->prepare("DELETE FROM tareas WHERE id = ?");
        $stmt->execute([$id]);
        
        if ($stmt->rowCount() > 0) {
            echo json_encode(['success' => true, 'message' => 'Tarea eliminada correctamente']);
        } else {
            http_response_code(404);
            echo json_encode(['error' => 'Tarea no encontrada']);
        }
    } catch(PDOException $e) {
        http_response_code(500);
        echo json_encode(['error' => 'Error al eliminar tarea: ' . $e->getMessage()]);
    }
}
?>
