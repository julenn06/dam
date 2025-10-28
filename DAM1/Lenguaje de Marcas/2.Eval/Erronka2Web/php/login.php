<?php
session_start();
require 'conexion.php';

$nombre = htmlspecialchars(trim($_POST['erabiltzailea']));
$pasahitza = htmlspecialchars(trim($_POST['pasahitza']));

$sql = "SELECT Erabiltzaile, Pasahitza, izenaAgentzia, logoa, IDAgentzia FROM agentzia WHERE Erabiltzaile = ?";
$stmt = $conn->prepare($sql);
$stmt->bind_param("s", $nombre);
$stmt->execute();
$result = $stmt->get_result();

if ($result->num_rows > 0) {
    $user = $result->fetch_assoc();

    if ((string)$pasahitza === (string)$user['Pasahitza']) {
        session_regenerate_id(true);
        $_SESSION['izenaAgentzia'] = $user['izenaAgentzia'];
        $_SESSION['logoa'] = $user['logoa'];
        $_SESSION['IDAgentzia'] = $user['IDAgentzia'];
        header("Location: registroak.php");
        exit();
    } else {
        header("Location: ../index.html?error=Pasahitza%20okerra%20da.%20Saiatu%20berriro.");
        exit();
    }         
} else {
    header("Location: ../index.html?error=Erabiltzailearen%20izena%20ez%20da%20existitzen.");
    exit();
}


$conn->close();
?>