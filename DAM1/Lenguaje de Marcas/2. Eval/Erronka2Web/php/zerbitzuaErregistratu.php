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
    <link rel="stylesheet" href="../css/maketazioa.css">
    <link rel="stylesheet" href="../css/ZerbitzuaErregistratu.css">
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
    <section class="zerbitzua-form">
        <div class="zerbitzua-formularioa">
            <form>
                <h4>Aukeratu bidaia</h4>
                <br>
                <select id="bidaiaMota" name="bidaiaMota">
                    <option value="">--Aukeratu--</option>
                    <?php
                            // DATU BASETIK
                            $sql = "select idBidaia, izenaBidaia from bidaia"; 
                            $result = $conn->query($sql);
                            if ($result->num_rows > 0) {
                                while ($row = $result->fetch_assoc()) {
                                    echo "<option value='" . $row['idBidaia'] . "'>" . $row['izenaBidaia'] . "</option>";
                                }
                            }
                            ?>
                </select>
                <br><br>
                <label>
                    <input type="radio" name="opcion" value="hegaldia"
                        onclick="formularioakIkusi('hegaldia-joanetorri')">
                    Hegaldia
                </label>
                <br>
                <label>
                    <input type="radio" name="opcion" value="ostatua" onclick="formularioakIkusi('form-ostatua')">
                    Ostatua
                </label>
                <br>
                <label>
                    <input type="radio" name="opcion" value="beste-bat" onclick="formularioakIkusi('form-beste-bat')">
                    Beste Batzuk
                </label>
                <br><br>

                <div id="hegaldia-joanetorri" class="hidden">
                    <label for="hegaldiMota">Zein hegaldia mota da?</label>
                    <br><br>
                    <label>
                        <input type="radio" name="hegaldiMota" onclick="formularioakIkusi('form-hegaldia')"> Joan
                    </label>
                    <label>
                        <input type="radio" name="hegaldiMota" onclick="formularioakIkusi('form-joan-etorri')">
                        Joan/Etorri
                    </label>
                    <br><br>
                </div>

                <div id="form-hegaldia" class="hidden">
                    <h4>Hegaldia (joana)</h4>
                    <br>
                    <label for="jatorria">Jatorrizko aireportua:</label>
                    <select id="jatorria" name="jatorria">
                        <option value="">--Aukeratu--</option>
                        <?php
                        // DATU BASETIK
                        $sql = "select KodAireportua, hiria from aireportua"; 
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['KodAireportua'] . "'>" . $row['KodAireportua'] . " -- " . $row['hiria'] . "</option>";
                            }
                        }
                        ?>
                    </select>
                    <br><br>
                    <label for="helmuga">Helmugako Aireportua</label>
                    <select name="helmuga" id="helmuga">
                        <option value="">--Aukeratu--</option>
                        <?php
                        // DATU BASETIK
                        $sql = "select KodAireportua, hiria from aireportua"; 
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['KodAireportua'] . "'>" . $row['KodAireportua'] . " -- " . $row['hiria'] . "</option>";
                            }
                        }
                        ?>
                    </select>
                    <br><br>
                    <label for="hegaldia-kodea">Hegaldi Kodea:</label>
                    <input type="text" id="hegaldiaKodea" name="hegaldiaKodea" placeholder="">
                    <br><br>
                    <label for="airelinea">Airelinea:</label>
                    <select id="airelinea" name="airelinea">
                        <option value="">--Aukeratu--</option>
                        <?php
                        // DATU BASETIK
                        $sql = "select KodAireLinea, izenaAirelinea from airelinea"; 
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['KodAireLinea'] . "'>" . $row['izenaAirelinea'] . "</option>";
                            }
                        }
                        ?>
                    </select>
                    <br><br>
                    <label for="prezioahegaldia">Prezioa (€):</label>
                    <input type="number" id="prezioahegaldia" name="prezioahegaldia" placeholder="" step="0.01">
                    <br><br>
                    <label for="data">Irteera Data:</label>
                    <input type="date" class="dataJoanHegaldia" name="data" required>
                    <br><br>
                    <label for="ordua">Irteera Ordua:</label>
                    <input type="time" id="ordua" name="ordua" required>
                    <br><br>
                    <label for="ordua">Bidaiaren Iraupena (h)</label>
                    <input type="number" id="denboraOrduak" name="denboraOrduak">
                    <br><br>
                </div>

                <div id="form-ostatua" class="hidden">
                    <label for="hotel-izena">Hotelaren Izena:</label>
                    <input type="text" id="hotel-izena" name="hotelIzena" placeholder="Sartu hotelaren izena">
                    <br><br>
                    <label for="ostatu-hiria">Hiria:</label>
                    <input type="text" id="ostatu-hiria" name="ostatuHiria" placeholder="Sartu hiriaren izena">
                    <br><br>
                    <label for="prezioaostatua">Prezioa (€):</label>
                    <input type="number" id="prezioaostatua" name="prezioaostatua" placeholder="" step="0.01">
                    <br><br>
                    <label for="datasarreraostatua">Sarrera Eguna:</label>
                    <input type="date" class="dataJoanOstatua" name="dataJoan" required>
                    <br><br>
                    <label for="datairteeraostatua">Irteera Eguna:</label>
                    <input type="date" class="dataEtorriOstatua" name="dataEtorri" required>
                    <br><br>
                    <label for="logelamota">Logela Mota:</label>
                    <select id="logelamota" name="logelamota">
                        <option value="">--Aukeratu--</option>
                        <?php
                        // DATU BASETIK
                        $sql = "select kodLogelaMota, deskribapenaLogelaMota from logela_mota"; 
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['kodLogelaMota'] . "'>" . $row['deskribapenaLogelaMota'] . "</option>";
                            }
                        }
                        ?>
                    </select>
                    <br><br>
                </div>

                <div id="form-beste-bat" class="hidden">
                    <label for="zerbitzu-izena">Zerbitzuaren Izena:</label>
                    <input type="text" id="zerbitzuIzena" name="zerbitzuIzena" placeholder="Sartu zerbitzuaren izena">
                    <br><br>
                    <label for="datak">Data:</label>
                    <br>
                    <input type="date" class="dataBesteBat" name="data">
                    <br><br>
                    <label for="deskribapena">Deskribapena:</label>
                    <br>
                    <textarea id="deskribapena" name="deskribapena"
                        placeholder="Idatzi zerbitzuaren deskribapena"></textarea>
                    <br><br>
                    <label for="kostua">Prezioa (€):</label>
                    <br>
                    <input type="number" id="kostua" name="kostua" placeholder="Sartu Prezioa" step="0.01">
                    <br><br>
                </div>

                <div id="form-joan-etorri" class="hidden">
                    <h4>Hegaldia (joana)</h4>
                    <br>
                    <label for="jatorria">Jatorrizko aireportua:</label>
                    <select id="jatorria-joan-etorri" name="jatorria">
                        <option value="">--Aukeratu--</option>
                        <?php
                        // DATU BASETIK
                        $sql = "select KodAireportua, hiria from aireportua"; 
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['KodAireportua'] . "'>" . $row['KodAireportua'] . " -- " . $row['hiria'] . "</option>";
                            }
                        }
                        ?>
                    </select>
                    <br><br>
                    <label for="helmuga">Helmugako Aireportua</label>
                    <select id="helmuga-joan-etorri" name="helmuga">
                        <option value="">--Aukeratu--</option>
                        <?php
                        // DATU BASETIK
                        $sql = "select KodAireportua, hiria from aireportua"; 
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['KodAireportua'] . "'>" . $row['KodAireportua'] . " -- " . $row['hiria'] . "</option>";
                            }
                        }
                        ?>
                    </select>
                    <br><br>
                    <label for="hegaldia-kodea">Hegaldi Kodea:</label>
                    <input type="text" id="hegaldia-kodea-joan-etorri" name="hegaldiaKodea" placeholder="">
                    <br><br>
                    <label for="airelinea">Airelinea:</label>
                    <select name="airelinea" id="airelinea-joan-etorri">
                        <option value="">--Aukeratu--</option>
                        <?php
                        // DATU BASETIK
                        $sql = "select KodAireLinea, izenaAirelinea from airelinea"; 
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['KodAireLinea'] . "'>" . $row['izenaAirelinea'] . "</option>";
                            }
                        }
                        ?>
                    </select>
                    <br><br>
                    <label for="prezioahegaldia">Prezioa (€):</label>
                    <input type="number" id="prezioahegaldia-joan-etorri" name="prezioahegaldia" placeholder=""
                        step="0.01">
                    <br><br>
                    <label for="data">Irteera Data:</label>
                    <input type="date" class="data-joan-etorri" name="data" required>
                    <br><br>
                    <label for="ordua">Irteera Ordua:</label>
                    <input type="time" id="ordua-joan-etorri" name="ordua" required>
                    <br><br>
                    <label for="ordua">Bidaiaren Iraupena (h)</label>
                    <input type="number" id="denboraOrduak-joan-etorri" name="denboraOrduak">
                    <br><br>
                    <h4>Hegaldia (Etorria)</h4>
                    <br>
                    <label for="itzulera-data">Itzulera Data:</label>
                    <input type="date" class="data-etorri-etorri" name="itzuleraData">
                    <br><br>
                    <label for="itzulera-ordua">Itzulera Ordua:</label>
                    <input type="time" id="itzulera-ordua" name="itzuleraOrdua">
                    <br><br>
                    <label for="itzulera-ordua">Buletako Bidaiaren Iraupena (h)</label>
                    <input type="number" id="itzulera-orduak" name="itzuleraOrduak">
                    <br><br>
                    <label for="bueltako-hegaldia-kodea">Bueltako Hegaldi Kodea:</label>
                    <input type="text" id="bueltako-hegaldia-kodea" name="bueltakoHegaldiaKodea" placeholder="">
                    <br><br>
                    <label for="bueltako-airelinea">Bueltako Airelinea:</label>
                    <select id="bueltako-airelinea" name="bueltakoAirelinea">
                        <option value="">--Aukeratu--</option>
                        <?php
                        // DATU BASETIK
                        $sql = "select KodAireLinea, izenaAirelinea from airelinea"; 
                        $result = $conn->query($sql);
                        if ($result->num_rows > 0) {
                            while ($row = $result->fetch_assoc()) {
                                echo "<option value='" . $row['KodAireLinea'] . "'>" . $row['izenaAirelinea'] . "</option>";
                            }
                        }
                        $conn->close();
                        ?>
                    </select>
                </div>
                <div class="zerbitzua-botoia">
                    <button type="button" id="formularioaBidali" onclick="datuakLortu()">Gorde Zerbitzua</button>
                </div>
            </form>
            <div class="taula-datuakJ">
                <table id="taulaJ" class="hidden">
                    <thead>
                        <tr>
                            <th>Zerbitzu Mota</th>
                            <th>Jatorria</th>
                            <th>Helmuga</th>
                            <th>Hegaldi Kodea</th>
                            <th>Prezioa Hegaldia</th>
                            <th>Data</th>
                            <th>Ordua</th>
                            <th>Denbora Orduak</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="taula-datuakJE">
                <table id="taulaJE" class="hidden">
                    <thead>
                        <tr>
                            <th>Zerbitzu Mota</th>
                            <th>Jatorria</th>
                            <th>Helmuga</th>
                            <th>Hegaldi Kodea</th>
                            <th>Prezioa Hegaldia</th>
                            <th>Data</th>
                            <th>Ordua</th>
                            <th>Denbora Orduak</th>
                            <th>Itzulera Data</th>
                            <th>Itzulera Ordua</th>
                            <th>Itzulera Orduak</th>
                            <th>Bueltako Hegaldi Kodea</th>
                            <th>Bueltako Airelinea</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="taula-datuakO">
                <table id="taulaO" class="hidden">
                    <thead>
                        <tr>
                            <th>Zerbitzu Mota</th>
                            <th>Izena</th>
                            <th>Hiria</th>
                            <th>Prezioa</th>
                            <th>Sarrera Eguna</th>
                            <th>Irteera Eguna</th>
                            <th>Logela Mota</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="taula-datuakB">
                <table id="taulaB" class="hidden">
                    <thead>
                        <tr>
                            <th>Zerbitzu Mota</th>
                            <th>Bidaia Mota</th>
                            <th>Zerbitzuaren Izena</th>
                            <th>Data</th>
                            <th>Deskribapena</th>
                            <th>Prezioa</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
    </section>
    <script src="../js/script.js"></script>
    <script src="../js/zerbitzuaErregistratu.js"></script>
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