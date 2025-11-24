use db_enpresak;

#1) 
DROP FUNCTION IF EXISTS adina_lortu;

DELIMITER //

CREATE FUNCTION adina_lortu(_nan CHAR(9)) 
RETURNS DATE
DETERMINISTIC
BEGIN
    DECLARE jaiotza DATE;
    
    -- Buscar la fecha de nacimiento
    SELECT JaiotzaData INTO jaiotza
    FROM Langilea
    WHERE NAN = _nan;
    
    RETURN jaiotza;
END //

DELIMITER ;


SELECT adina_lortu('21451451V');


#2)
  SET SQL_SAFE_UPDATES= 0;
DROP PROCEDURE IF EXISTS SoldataIgoera;
DELIMITER //

CREATE PROCEDURE SoldataIgoera(
    IN dept_izena VARCHAR(50)
)
BEGIN
    DECLARE batez_besteko_soldata DECIMAL(10,2);
    DECLARE igoera DECIMAL(5,2);
    
SELECT 
    AVG(Soldata)
INTO batez_besteko_soldata FROM
    Langilea
WHERE
    Izena = dept_izena;

    IF batez_besteko_soldata > 35000 THEN
        SET igoera = 1.02;
    ELSE
        SET igoera = 1.04;
    END IF;
    
UPDATE Langilea 
SET 
    Soldata = Soldata * igoera
WHERE
    Izena = dept_izena;
    
SELECT 
    CONCAT(dept_izena,
            ' saileko langileen soldata. ',
            ROUND((igoera - 1) * 100, 0),
            '% igo da') AS Mezua;
END //

DELIMITER ;

CALL SoldataIgoera('Madariaga Bacterio, Luke');