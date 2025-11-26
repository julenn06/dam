<?php
session_start();
require 'conexion.php';
if (!isset($_SESSION['izenaAgentzia'])) {
    header("Location: ../index.html");
    exit();
}
?>
<!DOCTYPE html>
<html lang="eu">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/maketazioa.css">
    <link rel="stylesheet" href="../css/registroak.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<body>
    <header>
        <img src="<?php echo htmlspecialchars($_SESSION['logoa']); ?>" alt="Logoa">
        <a href="registroak.php"><button id="atzeraButton">Atzera</button></a>
        <?php echo htmlspecialchars($_SESSION['izenaAgentzia']); ?>
        <button id="logoutButton" onclick="saioaItxi()">Itxi saioa</button>
    </header>
    <section id="registroBotoiak">
        <button id="botoiaBidaiak" onclick="window.location.href='bidaiaErregistratu.php'">Bidaiak
            Erregistratu</button>
        <button id="botoiaZerbitzuak" onclick="window.location.href='zerbitzuaErregistratu.php'">Zerbitzuak
            Erregistratu</button>
    </section>
    <div id="argiaIluna"></div>
    <script src="../js/script.js"></script>
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