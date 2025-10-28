<?php
// conexion.php fitxategia ireki
require 'conexion.php';
session_start();
?>

<!DOCTYPE html>
<html lang="eu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Menua</title>
</head>
<body>
    <?php
        // Formularioko datuak berreskuratu ($_POST, $_GET, $_SESSION eta echo azaldu)
        $izena = $_POST['izena'];
        $abizena = $_POST['abizena'];
        ?> <p id="mezua"> Kaixo <?php echo $izena . " " . $abizena; 
    ?> ; aukeratu ikasketa arlo bat</p>
    <form>
        <label for="ikasketaArloak"></br>
        <select id="ikasketaArloak" name="ikasketaArloak">
            <option value="">--Hemen--</option>
                <?php
                //DATU BASETIK
                $sql = "select id, izena from arloak"; 
                $result = $conn->query($sql);
                if ($result->num_rows > 0) {
                    while ($row = $result->fetch_assoc()) {
                        echo "<option value='" . $row['id'] . "'>" . $row['izena'] . "</option>";
                    }
                }
                $conn->close();
                ?>
        </select>
    </form>
</body>
</html>