DROP DATABASE IF EXISTS db_test;
CREATE DATABASE db_test CHARACTER SET utf8mb4;
USE db_test;

CREATE TABLE kontuak (
    id INTEGER UNSIGNED PRIMARY KEY,
    saldo DECIMAL(11,2) CHECK (saldo >= 0)
);

INSERT INTO kontuak VALUES (1, 1000);
INSERT INTO kontuak VALUES (2, 2000);
INSERT INTO kontuak VALUES (3, 0);

-- 1. Kontuen egoera orokorra aztertuko dugu
SELECT *
FROM kontuak;

-- 2. Demagun diru-transferentzia bat egin nahi dugula bi kontuen artean, honako transakzio honekin:
START TRANSACTION;

UPDATE kontuak 
SET saldo = saldo - 100 
WHERE id = 1;

UPDATE kontuak 
SET saldo = saldo + 100 
WHERE id = 2;

COMMIT;

-- 3. Zein izango da kontsultaren emaitza?
SELECT *
FROM kontuak;
