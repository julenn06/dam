-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 13-02-2025 a las 10:10:03
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_bidaiak`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agentzia`
--

CREATE TABLE `agentzia` (
  `IDAgentzia` int(11) NOT NULL,
  `izenaAgentzia` varchar(50) NOT NULL,
  `logoa` varchar(200) DEFAULT NULL,
  `kolorea` varchar(7) DEFAULT NULL,
  `Pasahitza` varchar(50) NOT NULL,
  `Erabiltzaile` varchar(25) NOT NULL,
  `kodAgMota` varchar(2) NOT NULL,
  `kodLangKop` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `agentzia`
--

INSERT INTO `agentzia` (`IDAgentzia`, `izenaAgentzia`, `logoa`, `kolorea`, `Pasahitza`, `Erabiltzaile`, `kodAgMota`, `kodLangKop`) VALUES
(1, 'AGENTZIA1', 'https://www.mundodeportivo.com/urbantecno/hero/2023/10/estas-son-algunas-de-las-mejores-plataformas-para-crear-logos.jpg?width=1200&aspect_ratio=16:9', NULL, 'admin', 'admin', 'A1', 'L1'),
(2, 'qqqq', 'dfgdfg', NULL, 'admin2', 'admin2', 'A1', 'L2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agentzia_mota`
--

CREATE TABLE `agentzia_mota` (
  `kodAgMota` varchar(2) NOT NULL,
  `deskribapena` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `agentzia_mota`
--

INSERT INTO `agentzia_mota` (`kodAgMota`, `deskribapena`) VALUES
('A1', 'Mayorista'),
('A2', 'Minorista'),
('A3', 'Mayorista-minorista');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `airelinea`
--

CREATE TABLE `airelinea` (
  `KodAirelinea` varchar(5) NOT NULL,
  `izenaAirelinea` varchar(50) NOT NULL,
  `herrialdea` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `airelinea`
--

INSERT INTO `airelinea` (`KodAirelinea`, `izenaAirelinea`, `herrialdea`) VALUES
('2K', 'AVIANCA-Ecuador dba ', 'EC'),
('3P', 'World 2 Fly PT, S.A.', 'PT'),
('6B*', 'TUIfly Nordic AB', 'CN'),
('A.C.', 'Air France', 'FR'),
('A0', 'BA Euroflyer Limited', 'GB'),
('AA', 'American Airlines', 'USA'),
('AM', 'Aerovias de Mexico S', 'MX'),
('AR', 'Aerolineas Argentina', 'AR'),
('AV', 'Aerovias del Contine', 'CO'),
('AY', 'Finnair', 'FI'),
('AZ', 'Alitalia', 'IT'),
('BA', 'British Airways PLC', 'GB'),
('CL', 'Lufthansa CityLine G', 'DE'),
('DE', 'Condor Flugdienst Gm', 'DE'),
('DL', 'Delta Air Lines Inc', 'USA'),
('DS', 'Easyjet CH S.A', 'CH'),
('GL', 'Air GRL', 'GRL'),
('JJ', 'Tam Linhas Aereas SA', 'BR'),
('KL', 'KLM', 'NL'),
('KN', 'CN United Airlines', 'CN'),
('LH', 'Lufthansa', 'DE'),
('LX', 'SWISS International ', 'CH'),
('M3', 'BSA - Aerolinhas Bra', 'BR'),
('MS', 'Egyptair', 'EG'),
('MT', 'MT Air Travel Ltd db', 'MT'),
('N0', 'Norse Atlantic Airwa', 'NO'),
('OU', 'HR Airlines d.d.', 'HR'),
('PC', 'Pegasus Airlines', 'TR'),
('QR', 'QA Airways Group Q.C', 'QA'),
('RJ', 'Alia - The Royal JOn', 'JO'),
('RK', 'RYNAIR', 'GB'),
('S4', 'SATA Internacional -', 'PT'),
('SN', 'Brussels Airlines', 'BE'),
('SP', 'SATA (Air Acores)', 'PT'),
('TK', 'Turkish Airlines Inc', 'TR'),
('TP', 'TAP PT', 'PT'),
('TS', 'Air Transat', 'CA'),
('U2', 'EASYJET UK LIMITED', 'GB'),
('UA', 'United Airlines Inc', 'USA'),
('UX', 'Air Europa Lineas Ae', 'ES'),
('VOY', 'Aerolínea Vueling SA', 'ES'),
('VS', 'Virgin Atlantic Airw', 'GB'),
('WA', 'KLM Cityhopper', 'NL'),
('WFL', 'World2Fly', 'ES'),
('WK', 'Edelweiss Air AG', 'CH'),
('X3*', 'TUIfly Gmbh', 'DE'),
('X7', 'Challenge Airlines (', 'BE'),
('YW', 'Air Nostrum, Lineas ', 'ES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aireportua`
--

CREATE TABLE `aireportua` (
  `KodAireportua` varchar(5) NOT NULL,
  `hiria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `aireportua`
--

INSERT INTO `aireportua` (`KodAireportua`, `hiria`) VALUES
('ACA', 'MÉXICO (ACAPULCO)'),
('ACE', 'Lanzarote'),
('AGP', 'MALAGA'),
('ALC', 'Alicante'),
('AMM', 'JO (Ammán ) AMM'),
('AMS', 'HOLANDA Amsterdam'),
('ATH', 'GRECIA ( Atenas)'),
('BCN', 'Barcelona'),
('BER', 'ALEMANIA (Berlín )'),
('BIO', 'Bilbao'),
('BJZ', 'Badajoz'),
('BKK', 'TAILANDIA Bagkok'),
('BOG', 'COLOMBIA Bogotá'),
('BOS', 'Boston'),
('BRU', 'BELGICA (Bruselas )'),
('BSB', 'BRASIL (brasilia)'),
('BUE', 'Buenos Aires'),
('CAI', 'EG El Cairo'),
('CAS', 'MARRUECOS (Casablanca)'),
('CCS', 'VENEZUELA ( CARACAS)'),
('CDG', 'FRANCIA,París (aeropuerto Charles de Gaulle)'),
('CPH', 'DINAMARCA'),
('DTT', 'DETROIT'),
('DUB', 'IRLANDA (DUBLIN)'),
('DUS', 'ALEMANIA (Dusseldorf )'),
('EAS', 'SAN SEBASTIAN'),
('FRA', 'ALEMANIA (Frankfurt )'),
('FUE', 'FUERTEVENTURA'),
('GMZ', 'LA GOMERA'),
('GRO', 'Gerona'),
('GRX', 'Granada'),
('GVA', 'SUIZA (Ginebra )'),
('HAM', 'ALEMANIA (hamburgo)'),
('HEL', 'FINLANDIA (Helsinki )'),
('HOU', 'Houston'),
('IBZ', 'Ibiza'),
('IST', 'TR (ESTAMBUL)'),
('JFK', 'Nueva York'),
('KIN', 'JAMAICA (kingston)'),
('LAX', 'LOS ANGELES'),
('LBG', 'FRANCIA ,Le Bourget'),
('LCG', 'La Coruña LCG'),
('LGH', 'LONDRES (GATWICK)'),
('LHR', 'LONDRES Heathrow'),
('LIM', 'PERU ( Lima)'),
('LIS', 'PT (lisboa)'),
('LPA', 'GRAN CANARIA'),
('LYS', 'FRANCIA (lyon)'),
('MAD', 'Madrid'),
('MAH', 'MAHON'),
('MEL', 'AUSTRALIA Melbourne'),
('MEX', 'México D.F.'),
('MIA', 'Miami'),
('MIL', 'ITALIA (Milán )'),
('MJV', 'Murcia'),
('MOW', 'RUSIA (Moscú ) MOW'),
('MRS', 'FRANCIA (Marsella)'),
('MUC', 'ALEMANIA (Munich )'),
('NBO', 'KENIA ( Nairobi)'),
('ODB', 'Córdoba'),
('ORY', 'FRANCIA (ORLY)'),
('OSL', 'NORUEGA (oslo)'),
('OVD', 'Asturias'),
('PHL', 'Philadelphia PHL'),
('PMI', 'PALMA DE MALLORCA'),
('PNA', 'Pamplona'),
('PRG', 'REPÚBLICA CHECA (Praga )'),
('RAK', 'MARRUECOS (Marrakech)'),
('REU', 'REUS'),
('RIO', 'BRASIL (Rio de Janeiro )'),
('SAO', 'BRASIL (Sao Paulo )'),
('SCQ', 'Santiago de Compostela'),
('SDQ', 'REPÚBLICA DOMINICANA (Santo Domingo)'),
('SDR', 'SANTANDER'),
('SEA', 'Seattle'),
('SFO', 'SAN FRANCISCO'),
('SLM', 'Salamanca'),
('SPC', 'Santa Cruz de la Palma'),
('STN', 'LONDRES (Stanted)'),
('STO', 'SUECIA (Estocolmo)'),
('STR', 'ALEMANIA (Stuttgart)'),
('SYD', 'AUSTRALIA (SIYNEY)'),
('TFN', 'Tenerife Norte'),
('TFS', 'Tenerife Sur'),
('TUN', 'Túnez'),
('VDE', 'HIERRO'),
('VGO', 'Vigo'),
('VIE', 'AUSTRIA (Viena )'),
('VIT', 'VITORIA'),
('VLC', 'Valencia'),
('WAS', 'WASHINGTON'),
('WAW', 'POLONIA (Varsovia ) WAW'),
('XRY', 'JEREZ DE LA FRONTERA'),
('YMQ', 'Montreal, Québec'),
('YOW', 'CA Ottawa, Ontario YOW'),
('YTO', 'CA Toronto, Ontario YTO'),
('YVR', 'CA VANCOUVER'),
('ZAZ', 'Zaragoza'),
('ZRH', 'SUIZA (Zurich)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `beste_zerbitzuak`
--

CREATE TABLE `beste_zerbitzuak` (
  `IDBesteZerbitzuak` int(11) NOT NULL,
  `izenaBesteZerbitzuak` varchar(20) NOT NULL,
  `data` date NOT NULL,
  `deskribapenaBesteZerbitzuak` varchar(50) DEFAULT NULL,
  `prezioBesteZerbitzua` decimal(10,0) DEFAULT NULL,
  `bidaiaBe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `beste_zerbitzuak`
--

INSERT INTO `beste_zerbitzuak` (`IDBesteZerbitzuak`, `izenaBesteZerbitzuak`, `data`, `deskribapenaBesteZerbitzuak`, `prezioBesteZerbitzua`, `bidaiaBe`) VALUES
(1, 'hgfghfgh', '2026-10-09', 'gdfgdfg', 345, 2),
(2, 'aaaqa', '2025-02-20', 'dedfhjdfsdfskljdfsff', 78, 5),
(3, 'jjjjjhg', '2025-02-26', 'kghfgfhgfhghfghf', 82, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bidaia`
--

CREATE TABLE `bidaia` (
  `IDBidaia` int(11) NOT NULL,
  `izenaBidaia` varchar(50) NOT NULL,
  `deskribapenaBidaia` varchar(50) DEFAULT NULL,
  `dataIrteera` date NOT NULL,
  `dataAmaiera` date NOT NULL,
  `IDAgentzia` int(11) NOT NULL,
  `kodBidaiaMota` varchar(2) NOT NULL,
  `kodHerrialdea` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `bidaia`
--

INSERT INTO `bidaia` (`IDBidaia`, `izenaBidaia`, `deskribapenaBidaia`, `dataIrteera`, `dataAmaiera`, `IDAgentzia`, `kodBidaiaMota`, `kodHerrialdea`) VALUES
(2, 'aaaa', 'aaaaaaaaaaaaaaaaa', '2026-10-09', '2026-11-09', 1, 'B1', 'EG'),
(3, 'fsfds', 'dfssdfdsf', '2026-10-09', '2026-11-09', 1, 'B2', 'FR'),
(4, 'gffgdfg', 'gddfgdfgdgf', '2026-10-09', '2026-11-09', 1, 'B3', 'DE'),
(5, 'izena', 'aaaa', '2006-10-09', '2006-11-09', 1, 'B1', 'GB'),
(6, 'lehenengo bidaia', 'aaaaaaaaaaaaaaaaaaaaa', '2026-10-09', '2026-11-09', 1, 'B2', 'FR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bidaia_mota`
--

CREATE TABLE `bidaia_mota` (
  `kodBidaiaMota` varchar(2) NOT NULL,
  `deskribapenaBidaiMota` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `bidaia_mota`
--

INSERT INTO `bidaia_mota` (`kodBidaiaMota`, `deskribapenaBidaiMota`) VALUES
('B1', 'Ezkongaiak'),
('B2', 'Senior'),
('B3', 'Taldeak'),
('B4', 'Bidaia handiak (helmuga exotikoak + hegaldia + ost'),
('B5', 'Eskapada'),
('B6', 'Familiak (haur txikiekin)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hegaldia`
--

CREATE TABLE `hegaldia` (
  `IDHegaldia` int(11) NOT NULL,
  `HegaldiKodea` varchar(5) NOT NULL,
  `BidaiaIraupen` int(11) NOT NULL,
  `prezioaHegaldia` decimal(10,0) DEFAULT NULL,
  `IrteeraData` date NOT NULL,
  `IrteeraOrdutegia` time NOT NULL,
  `KodAirelinea` varchar(5) NOT NULL,
  `KodAireIrteera` varchar(5) NOT NULL,
  `KodAireHelmuga` varchar(5) NOT NULL,
  `bidaiaHe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `hegaldia`
--

INSERT INTO `hegaldia` (`IDHegaldia`, `HegaldiKodea`, `BidaiaIraupen`, `prezioaHegaldia`, `IrteeraData`, `IrteeraOrdutegia`, `KodAirelinea`, `KodAireIrteera`, `KodAireHelmuga`, `bidaiaHe`) VALUES
(4, 'gdfgd', 5, 45, '2026-10-09', '12:34:00', 'DL', 'ACA', 'AGP', 2),
(10, 'ghgfh', 5, 54, '2026-10-09', '12:34:00', 'BA', 'ACA', 'ACE', 2),
(11, 'dfssd', 4, 5, '2026-10-09', '12:34:00', 'CL', 'ACA', 'ALC', 2),
(12, 'dfsdf', 5, 45, '2026-10-09', '12:34:00', 'GL', 'AMM', 'ATH', 2),
(13, 'fgdfg', 5, 45, '2026-10-09', '12:34:00', 'DL', 'ACE', 'AMS', 2),
(14, 'dsfds', 4, 45, '2026-10-09', '12:34:00', 'DE', 'ACE', 'ATH', 2),
(15, 'aarrg', 5, 89, '2025-02-16', '09:58:49', 'A0', 'AMM', 'AMM', 5),
(16, 'edfth', 7, 60, '2025-02-18', '03:06:30', 'AA', 'MAD', 'MAD', 5),
(17, 'rrrrr', 4, 67, '2025-02-18', '02:10:33', '6B*', 'AMM', 'AMS', 2),
(18, 'aarv', 4, 45, '2025-02-17', '02:28:14', '3P', 'ALC', 'AGP', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `herrialdea`
--

CREATE TABLE `herrialdea` (
  `kodHerrialdea` varchar(2) NOT NULL,
  `deskribapena` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `herrialdea`
--

INSERT INTO `herrialdea` (`kodHerrialdea`, `deskribapena`) VALUES
('AR', 'ARGENTINA'),
('AT', 'AUSTRIA'),
('BE', 'BÉLGICA'),
('BR', 'BRASIL'),
('CA', 'CANADA'),
('CH', 'SUIZA'),
('CN', 'CHINA'),
('CU', 'CUBA'),
('CY', 'CHIPRE'),
('CZ', 'REPUBLICA CHECA'),
('DE', 'ALEMANIA'),
('DK', 'DINAMARCA'),
('EE', 'ESTONIA'),
('EG', 'EGIPTO'),
('ES', 'ESPAÑA'),
('FI', 'FINLANDIA'),
('FR', 'FRANCIA'),
('GB', 'REINO UNIDO'),
('GR', 'GRECIA'),
('GT', 'GUATEMALA'),
('HK', 'HONG-KONG'),
('HR', 'CROACIA'),
('HU', 'HUNGRIA'),
('ID', 'INDONESIA'),
('IE', 'IRLANDA'),
('IL', 'ISRAEL'),
('IN', 'INDIA'),
('IS', 'ISLANDIA'),
('IT', 'ITALIA'),
('JM', 'JAMAICA'),
('JP', 'JAPÓN'),
('KE', 'KENIA'),
('LU', 'LUXEMBURGO'),
('MA', 'MARRUECOS'),
('MC', 'MÓNACO'),
('MT', 'MALTA'),
('MV', 'MALDIVAS'),
('MX', 'MEXICO'),
('NL', 'PAISES BAJOS'),
('NO', 'NORUEGA'),
('PA', 'PANAMÁ'),
('PE', 'PERÚ'),
('PL', 'POLONIA'),
('PR', 'PUERTO RICO'),
('PT', 'PORTUGAL'),
('QA', 'QATAR'),
('RO', 'RUMANIA'),
('RU', 'RUSIA'),
('SC', 'SEYCHELLES'),
('SE', 'SUECIA'),
('SG', 'SINGAPUR'),
('TH', 'TAILANDIA'),
('TN', 'TÚNEZ'),
('TR', 'TURQUIA'),
('TZ', 'TANZANIA (INCLUYE ZANZIBAR)'),
('US', 'ESTADOS UNIDOS'),
('VE', 'VENEZUELA'),
('VN', 'VIETNAM'),
('ZA', 'SUDÁFRICA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `joanetorri`
--

CREATE TABLE `joanetorri` (
  `IDJoanEtorri` int(11) NOT NULL,
  `ItzuleraOrdua` time NOT NULL,
  `ItzuleraData` date NOT NULL,
  `BueltakoIraupena` int(11) NOT NULL,
  `HegaldiKodeaBuelta` varchar(5) NOT NULL,
  `KodAirelinea` varchar(5) NOT NULL,
  `KodAireIrteera` varchar(5) NOT NULL,
  `KodAireHelmuga` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `joanetorri`
--

INSERT INTO `joanetorri` (`IDJoanEtorri`, `ItzuleraOrdua`, `ItzuleraData`, `BueltakoIraupena`, `HegaldiKodeaBuelta`, `KodAirelinea`, `KodAireIrteera`, `KodAireHelmuga`) VALUES
(11, '12:34:00', '2026-11-09', 5, 'vdfvd', 'DS', 'ALC', 'ACA'),
(12, '23:45:00', '2026-11-09', 5, 'gfdg', 'KL', 'ATH', 'AMM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `langile_kopurua`
--

CREATE TABLE `langile_kopurua` (
  `kodLangKop` varchar(2) NOT NULL,
  `deskribapena` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `langile_kopurua`
--

INSERT INTO `langile_kopurua` (`kodLangKop`, `deskribapena`) VALUES
('L1', '5 gehienez (1 - 5 bitartean)'),
('L2', '10 gehienez (1 - 10 bitartean)'),
('L3', '20 gehienez (1 - 20 bitartean)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `logela_mota`
--

CREATE TABLE `logela_mota` (
  `kodLogelaMota` varchar(5) NOT NULL,
  `deskribapenaLogelaMota` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `logela_mota`
--

INSERT INTO `logela_mota` (`kodLogelaMota`, `deskribapenaLogelaMota`) VALUES
('DB', 'Bikoitza'),
('DUI', 'Bikoitza, erabilpen indibiduala'),
('SIN', 'Indibiduala'),
('TPL', 'Hirukoitza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ostatua`
--

CREATE TABLE `ostatua` (
  `IDostatua` int(11) NOT NULL,
  `izenaOstatua` varchar(20) NOT NULL,
  `hiria` varchar(20) NOT NULL,
  `prezioOstatua` decimal(10,0) DEFAULT NULL,
  `sarreraEguna` date NOT NULL,
  `irteeraEguna` date NOT NULL,
  `kodLogelaMota` varchar(5) NOT NULL,
  `bidaiaOs` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `ostatua`
--

INSERT INTO `ostatua` (`IDostatua`, `izenaOstatua`, `hiria`, `prezioOstatua`, `sarreraEguna`, `irteeraEguna`, `kodLogelaMota`, `bidaiaOs`) VALUES
(1, 'aaaaa', 'aaaaa', 68, '2025-02-20', '2025-02-27', 'DUI', 2),
(80, 'fffff', 'rtyfgh', 89, '2025-02-18', '2025-02-28', 'TPL', 5),
(81, 'rrrgf', 'jhjghj', 23, '2025-02-17', '2025-02-20', 'TPL', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `agentzia`
--
ALTER TABLE `agentzia`
  ADD PRIMARY KEY (`IDAgentzia`),
  ADD UNIQUE KEY `Erabiltzaile` (`Erabiltzaile`),
  ADD KEY `kodAgMota` (`kodAgMota`),
  ADD KEY `kodLangKop` (`kodLangKop`);

--
-- Indices de la tabla `agentzia_mota`
--
ALTER TABLE `agentzia_mota`
  ADD PRIMARY KEY (`kodAgMota`);

--
-- Indices de la tabla `airelinea`
--
ALTER TABLE `airelinea`
  ADD PRIMARY KEY (`KodAirelinea`);

--
-- Indices de la tabla `aireportua`
--
ALTER TABLE `aireportua`
  ADD PRIMARY KEY (`KodAireportua`);

--
-- Indices de la tabla `beste_zerbitzuak`
--
ALTER TABLE `beste_zerbitzuak`
  ADD PRIMARY KEY (`IDBesteZerbitzuak`),
  ADD KEY `bidaiaBe` (`bidaiaBe`);

--
-- Indices de la tabla `bidaia`
--
ALTER TABLE `bidaia`
  ADD PRIMARY KEY (`IDBidaia`),
  ADD KEY `IDAgentzia` (`IDAgentzia`),
  ADD KEY `kodBidaiaMota` (`kodBidaiaMota`),
  ADD KEY `kodHerrialdea` (`kodHerrialdea`);

--
-- Indices de la tabla `bidaia_mota`
--
ALTER TABLE `bidaia_mota`
  ADD PRIMARY KEY (`kodBidaiaMota`);

--
-- Indices de la tabla `hegaldia`
--
ALTER TABLE `hegaldia`
  ADD PRIMARY KEY (`IDHegaldia`),
  ADD UNIQUE KEY `HegaldiKodea` (`HegaldiKodea`),
  ADD KEY `KodAirelinea` (`KodAirelinea`),
  ADD KEY `KodAireIrteera` (`KodAireIrteera`),
  ADD KEY `KodAireHelmuga` (`KodAireHelmuga`),
  ADD KEY `bidaiaHe` (`bidaiaHe`);

--
-- Indices de la tabla `herrialdea`
--
ALTER TABLE `herrialdea`
  ADD PRIMARY KEY (`kodHerrialdea`);

--
-- Indices de la tabla `joanetorri`
--
ALTER TABLE `joanetorri`
  ADD PRIMARY KEY (`IDJoanEtorri`),
  ADD UNIQUE KEY `HegaldiKodeaBuelta` (`HegaldiKodeaBuelta`),
  ADD KEY `KodAirelinea` (`KodAirelinea`),
  ADD KEY `KodAireIrteera` (`KodAireIrteera`),
  ADD KEY `KodAireHelmuga` (`KodAireHelmuga`);

--
-- Indices de la tabla `langile_kopurua`
--
ALTER TABLE `langile_kopurua`
  ADD PRIMARY KEY (`kodLangKop`);

--
-- Indices de la tabla `logela_mota`
--
ALTER TABLE `logela_mota`
  ADD PRIMARY KEY (`kodLogelaMota`);

--
-- Indices de la tabla `ostatua`
--
ALTER TABLE `ostatua`
  ADD PRIMARY KEY (`IDostatua`),
  ADD KEY `bidaiaOs` (`bidaiaOs`),
  ADD KEY `kodLogelaMota` (`kodLogelaMota`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `agentzia`
--
ALTER TABLE `agentzia`
  MODIFY `IDAgentzia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `beste_zerbitzuak`
--
ALTER TABLE `beste_zerbitzuak`
  MODIFY `IDBesteZerbitzuak` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `bidaia`
--
ALTER TABLE `bidaia`
  MODIFY `IDBidaia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `hegaldia`
--
ALTER TABLE `hegaldia`
  MODIFY `IDHegaldia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `ostatua`
--
ALTER TABLE `ostatua`
  MODIFY `IDostatua` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `agentzia`
--
ALTER TABLE `agentzia`
  ADD CONSTRAINT `agentzia_ibfk_1` FOREIGN KEY (`kodAgMota`) REFERENCES `agentzia_mota` (`kodAgMota`),
  ADD CONSTRAINT `agentzia_ibfk_2` FOREIGN KEY (`kodLangKop`) REFERENCES `langile_kopurua` (`kodLangKop`);

--
-- Filtros para la tabla `beste_zerbitzuak`
--
ALTER TABLE `beste_zerbitzuak`
  ADD CONSTRAINT `beste_zerbitzuak_ibfk_1` FOREIGN KEY (`bidaiaBe`) REFERENCES `bidaia` (`IDBidaia`) ON DELETE CASCADE;

--
-- Filtros para la tabla `bidaia`
--
ALTER TABLE `bidaia`
  ADD CONSTRAINT `bidaia_ibfk_1` FOREIGN KEY (`IDAgentzia`) REFERENCES `agentzia` (`IDAgentzia`) ON DELETE CASCADE,
  ADD CONSTRAINT `bidaia_ibfk_2` FOREIGN KEY (`kodBidaiaMota`) REFERENCES `bidaia_mota` (`kodBidaiaMota`),
  ADD CONSTRAINT `bidaia_ibfk_3` FOREIGN KEY (`kodHerrialdea`) REFERENCES `herrialdea` (`kodHerrialdea`);

--
-- Filtros para la tabla `hegaldia`
--
ALTER TABLE `hegaldia`
  ADD CONSTRAINT `hegaldia_ibfk_1` FOREIGN KEY (`KodAirelinea`) REFERENCES `airelinea` (`KodAirelinea`),
  ADD CONSTRAINT `hegaldia_ibfk_2` FOREIGN KEY (`KodAireIrteera`) REFERENCES `aireportua` (`KodAireportua`),
  ADD CONSTRAINT `hegaldia_ibfk_3` FOREIGN KEY (`KodAireHelmuga`) REFERENCES `aireportua` (`KodAireportua`),
  ADD CONSTRAINT `hegaldia_ibfk_4` FOREIGN KEY (`bidaiaHe`) REFERENCES `bidaia` (`IDBidaia`) ON DELETE CASCADE;

--
-- Filtros para la tabla `joanetorri`
--
ALTER TABLE `joanetorri`
  ADD CONSTRAINT `joanetorri_ibfk_1` FOREIGN KEY (`IDJoanEtorri`) REFERENCES `hegaldia` (`IDHegaldia`) ON DELETE CASCADE,
  ADD CONSTRAINT `joanetorri_ibfk_2` FOREIGN KEY (`KodAirelinea`) REFERENCES `airelinea` (`KodAirelinea`),
  ADD CONSTRAINT `joanetorri_ibfk_3` FOREIGN KEY (`KodAireIrteera`) REFERENCES `hegaldia` (`KodAireHelmuga`),
  ADD CONSTRAINT `joanetorri_ibfk_4` FOREIGN KEY (`KodAireHelmuga`) REFERENCES `hegaldia` (`KodAireIrteera`);

--
-- Filtros para la tabla `ostatua`
--
ALTER TABLE `ostatua`
  ADD CONSTRAINT `ostatua_ibfk_1` FOREIGN KEY (`bidaiaOs`) REFERENCES `bidaia` (`IDBidaia`) ON DELETE CASCADE,
  ADD CONSTRAINT `ostatua_ibfk_2` FOREIGN KEY (`kodLogelaMota`) REFERENCES `logela_mota` (`kodLogelaMota`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
