<?php
session_start();
require 'conexion.php';
if (!isset($_SESSION['izenaAgentzia'])) {
    header("Location: ../index.html");
    exit();
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Viaje</title>
    <link rel="stylesheet" href="../css/maketazioa.css">
    <link rel="stylesheet" href="../css/BidaiaErregistratu.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<body>
    <header>
        <img src="<?php echo htmlspecialchars($_SESSION['logoa']); ?>" alt="Logoa">
        <a href="registroak.php"><button id="atzeraButton">Atzera</button></a>
        <?php echo htmlspecialchars($_SESSION['izenaAgentzia']); ?>
        <button id="logoutButton" onclick="saioaItxi()">Itxi saioa</button>
        <div id="argiaIluna"></div>
    </header>
    <section class="bidaia-formularioa">
        <form>
            <h1>Bidaia Formularioa</h1>
            <div id="form-bidaia">
                <label for="izena">Izena:</label>
                <input type="text" id="izena" name="izena" required>

                <label for="bidaiaMota">Bidaia mota:</label>
                <select id="bidaiaMota" name="bidaiaMota">
                    <option value="">--Aukeratu--</option>
                    <?php
                        $sql = "SELECT kodBidaiaMota, DeskribapenaBidaiMota FROM bidaia_mota"; 
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['kodBidaiaMota'] . "'>" . $row['DeskribapenaBidaiMota'] . "</option>";
                            }
                        }
                    ?>
                </select>

                <label for="hasieraData">Hasiera Data:</label>
                <input type="date" id="hasieraData" name="hasieraData" required>

                <label for="amaieraData">Amaiera Data:</label>
                <input type="date" id="amaieraData" name="amaieraData" onblur="egunakKalkulatu()" required>

                <label for="egunak">Egunak:</label>
                <input type="text" id="egunak" name="egunak" readonly>

                <label for="herrialdea">Herrialdea:</label>
                <select id="herrialdea" name="herrialdea">
                    <option value="">--Aukeratu--</option>
                    <?php
                        $sql = "SELECT kodHerrialdea, Deskribapena FROM herrialdea"; 
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['kodHerrialdea'] . "'>" . $row['Deskribapena'] . "</option>";
                            }
                        }
                        $conn->close();
                    ?>
                </select>

                <label for="deskribapena">Deskribapena:</label>
                <textarea id="deskribapena" name="deskribapena" rows="4"></textarea>
            </div>

            <div class="bidaia-botoia">
                <button type="button" onclick="bidaiaErregistratu(
                    document.getElementById('izena').value.trim(),
                    document.getElementById('bidaiaMota').value,
                    document.getElementById('hasieraData').value,
                    document.getElementById('amaieraData').value,
                    document.getElementById('egunak').value,
                    document.getElementById('herrialdea').value,
                    document.getElementById('deskribapena').value.trim()
                    )">Gorde</button>
            </div>
        </form>

        <div class="taula-datuak">
            <table id="taula" class="hidden">
                <thead>
                    <tr>
                        <th>Izena</th>
                        <th>Bidaia Mota</th>
                        <th>Hasiera Data</th>
                        <th>Amaiera Data</th>
                        <th>Egunak</th>
                        <th>Herrialdea</th>
                        <th>Deskribapena</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </section>

    <script src="../js/script.js"></script>
    <script src="../js/bidaiaErregistratu.js"></script>
    <style>
        @media (max-width: 768px) {
            header {
                background-image: url("<?php echo htmlspecialchars($_SESSION['logoa']); ?>");
                background-size: cover;
                background-repeat: no-repeat;
            }
        }

        @media (max-width: 480px) {

            header {
                background-image: url("<?php echo htmlspecialchars($_SESSION['logoa']); ?>");
                background-size: cover;
                background-repeat: no-repeat;
            }
        }
    </style>
</body>

</html>