<?php
session_start();
require 'conexion.php';
if (!isset($_SESSION['izenaAgentzia'])) {
    header("Location: ../index.html");
    exit();
}
$idFormulario = $_POST['idFormulario'];

if ($idFormulario == 'form-hegaldia') {
    
    $bidaiaMota = $conn->real_escape_string($_POST['bidaiaMota']);
    $jatorria = $conn->real_escape_string($_POST['jatorria']);
    $helmuga = $conn->real_escape_string($_POST['helmuga']);
    $hegaldia_kodea = $conn->real_escape_string($_POST['hegaldiaKodea']);
    $airelinea = $conn->real_escape_string($_POST['airelinea']);
    $prezioahegaldia = $conn->real_escape_string($_POST['prezioahegaldia']);
    $data = $conn->real_escape_string($_POST['data']);
    $ordua = $conn->real_escape_string($_POST['ordua']);
    $denboraOrduak = $conn->real_escape_string($_POST['denboraOrduak']);

    $sqlbidaia = "SELECT IDBidaia FROM bidaia WHERE IDBidaia = ?";
    $stmt = $conn->prepare($sqlbidaia);
    $stmt->bind_param("i", $bidaiaMota);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $IDBidaia = $row['IDBidaia'];
    } else {
        echo "Bidaia mota ez da aurkitu.";
        exit;
    }

    $sql = "INSERT INTO hegaldia (HegaldiKodea, BidaiaIraupen, prezioaHegaldia, IrteeraData, IrteeraOrdutegia, KodAirelinea, KodAireIrteera, KodAireHelmuga, bidaiaHe) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("sidsssssi", $hegaldia_kodea, $denboraOrduak, $prezioahegaldia, $data, $ordua, $airelinea, $jatorria, $helmuga, $IDBidaia);
    
    if ($stmt->execute()) {
        echo "Hegaldia ongi sartu da!";
    } else {
        echo "Errorea hegaldiaren sartzean.";
    }
}elseif ($idFormulario == 'form-ostatua') {

    $bidaiaMota = $conn->real_escape_string($_POST['bidaiaMota']);
    $hotel_izena = $conn->real_escape_string($_POST['hotelIzena']);
    $ostatu_hiria = $conn->real_escape_string($_POST['ostatuHiria']);
    $prezioaostatua = $conn->real_escape_string($_POST['prezioaostatua']);
    $data_joan = $conn->real_escape_string($_POST['dataJoan']);
    $data_etorri = $conn->real_escape_string($_POST['dataEtorri']);
    $logelamota = $conn->real_escape_string($_POST['logelamota']);

    $sqlbidaia = "SELECT IDBidaia FROM bidaia WHERE IDBidaia = ?";
    $stmt = $conn->prepare($sqlbidaia);
    $stmt->bind_param("i", $bidaiaMota);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $IDBidaia = $row['IDBidaia'];
    } else {
        echo "Bidaia mota ez da aurkitu.";
        exit;
    }

    $sql = "INSERT INTO ostatua (izenaOstatua, hiria, prezioOstatua, sarreraEguna, irteeraEguna, kodLogelaMota , bidaiaOs) 
            VALUES (?, ?, ?, ?, ?, ?, ?)";

    $stmt = $conn->prepare($sql);
    $stmt->bind_param("ssdsssi", $hotel_izena, $ostatu_hiria, $prezioaostatua, $data_joan, $data_etorri, $logelamota, $IDBidaia);

    if ($stmt->execute()) {
        echo "Ostatua datuak gordeta daude.";
    } else {
        echo "Errorea gertatu da ostatuaren datuak gordetzerakoan.";
    }
} elseif ($idFormulario == 'form-beste-bat') {

    $bidaiaMota = $conn->real_escape_string($_POST['bidaiaMota']);
    $zerbitzu_izena = $conn->real_escape_string($_POST['zerbitzuIzena']);
    $data = $conn->real_escape_string($_POST['data']);
    $deskribapena = $conn->real_escape_string($_POST['deskribapena']);
    $kostua = $conn->real_escape_string($_POST['kostua']);

    $sqlbidaia = "SELECT IDBidaia FROM bidaia WHERE IDBidaia = ?";
    $stmt = $conn->prepare($sqlbidaia);
    $stmt->bind_param("i", $bidaiaMota);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $IDBidaia = $row['IDBidaia'];
    } else {
        echo "Bidaia mota ez da aurkitu.";
        exit;
    }

    $sql = "INSERT INTO beste_zerbitzuak (izenaBesteZerbitzuak, data, deskribapenaBesteZerbitzuak, prezioBesteZerbitzua, bidaiaBe) 
            VALUES (?, ?, ?, ?, ?)";

    $stmt = $conn->prepare($sql);
    $stmt->bind_param("sssdi", $zerbitzu_izena, $data, $deskribapena, $kostua, $IDBidaia);

    if ($stmt->execute()) {
        echo "Beste bat zerbitzua gordeta daude";
    } else {
        echo "Errorea gertatu da beste bat zerbitzuaren datuak gordetzerakoan.";
    }
} elseif ($idFormulario == 'form-joan-etorri') {

    $bidaiaMota = $conn->real_escape_string($_POST['bidaiaMota']);
    $jatorria = $conn->real_escape_string($_POST['jatorria']);
    $helmuga = $conn->real_escape_string($_POST['helmuga']);
    $hegaldia_kodea = $conn->real_escape_string($_POST['hegaldiaKodea']);
    $airelinea = $conn->real_escape_string($_POST['airelinea']);
    $prezioahegaldia = $conn->real_escape_string($_POST['prezioahegaldia']);
    $data = $conn->real_escape_string($_POST['data']);
    $ordua = $conn->real_escape_string($_POST['ordua']);
    $denboraOrduak = $conn->real_escape_string($_POST['denboraOrduak']);

    $itzulera_data = $conn->real_escape_string($_POST['itzuleraData']);
    $itzulera_ordua = $conn->real_escape_string($_POST['itzuleraOrdua']);
    $itzulera_orduak = $conn->real_escape_string($_POST['itzuleraOrduak']);  // orduak
    $bueltako_hegaldia_kodea = $conn->real_escape_string($_POST['bueltakoHegaldiaKodea']);
    $bueltako_airelinea = $conn->real_escape_string($_POST['bueltakoAirelinea']);

    $sqlbidaia = "SELECT IDBidaia FROM bidaia WHERE IDBidaia = ?";
    $stmt = $conn->prepare($sqlbidaia);
    $stmt->bind_param("i", $bidaiaMota);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $IDBidaia = $row['IDBidaia'];
    } else {
        echo "Bidaia Joan Etorri mota ez da aurkitu.";
        exit;
    }

    $sql = "INSERT INTO hegaldia (HegaldiKodea, BidaiaIraupen, prezioaHegaldia, IrteeraData, IrteeraOrdutegia, KodAirelinea, KodAireIrteera, KodAireHelmuga, bidaiaHe) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("sidsssssi", $hegaldia_kodea, $denboraOrduak, $prezioahegaldia, $data, $ordua, $airelinea, $jatorria, $helmuga, $IDBidaia);
    
    if ($stmt->execute()) {
        echo "Joan Etorri ongi sartu da!";
    } else {
        echo "Errorea Joan Etorri sartzean.";
    }

    $sqlhegaldia = "SELECT IDHegaldia FROM hegaldia WHERE HegaldiKodea = ?";
    $stmt = $conn->prepare($sqlhegaldia);
    $stmt->bind_param("i", $hegaldia_kodea);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        $IDJoanEtorri = $row['IDHegaldia'];
    } else {
        echo "Bidaia mota ez da aurkitu.";
        exit;
    }

    $sql = "INSERT INTO joanetorri (IDJoanEtorri, ItzuleraOrdua, ItzuleraData, BueltakoIraupena, HegaldiKodeaBuelta, KodAirelinea, KodAireIrteera, KodAireHelmuga) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            $stmt = $conn->prepare($sql);
    $stmt->bind_param("isssssss", $IDJoanEtorri, $itzulera_ordua, $itzulera_data, $itzulera_orduak, $bueltako_hegaldia_kodea, $bueltako_airelinea, $helmuga, $jatorria);

    if ($stmt->execute()) {
        echo "Joan Etorri datuak gordeta daude.";
    } else {
        echo "Errorea gertatu da joan etorri datuak gordetzerakoan.";
    }
} else {
    echo "Formularioa ez da bidali, mesedez berriro probatu.";
}
?>