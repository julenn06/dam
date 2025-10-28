use db_herriak;

# ADIBIDEA SALBUESPEN MANEJADOREAK: EXIT ETA CONTINUE

# 01 - CONTINUE 

DELIMITER //
CREATE PROCEDURE herriBilatu (IN idHerri INT)
BEGIN
    DECLARE izenaHerria VARCHAR(50);
    DECLARE aurkitua BOOLEAN DEFAULT TRUE;

    -- Ez bada lerrorik aurkitzen, manejadorea exekutatzen da eta aurkitua aldagaiari FALSE esleitzen zaio
    DECLARE CONTINUE HANDLER FOR NOT FOUND 
    SET aurkitua = FALSE;

    -- Saiatu herriaren izena aurkitzen
    SELECT izena INTO izenaHerria 
    FROM herriak WHERE id_herria = idHerri;

    -- Egiaztatu aurkitu den edo ez
    IF aurkitua THEN
        SELECT CONCAT("Herriaren izena da: ", izenaHerria) AS Emaitza;
    ELSE
        SELECT "Ez dago herririk id horrekin" AS ErroreMezua;
    END IF;
END //


# 02 - EXIT 


DELIMITER //
CREATE PROCEDURE herriBilatu (IN idHerri INT)
BEGIN
    DECLARE izenaHerria VARCHAR(50);
    DECLARE aurkitua BOOLEAN DEFAULT TRUE;

    -- Ez bada lerrorik aurkitzen, manejadorea exekutatzen da eta prozeduraren exekuziotik ateratzen da
    DECLARE exit HANDLER FOR NOT FOUND 
    SELECT "Ez dago herririk id horrekin" AS ErroreMezua;

    -- Saiatu herriaren izena aurkitzen
    SELECT izena INTO izenaHerria 
    FROM herriak WHERE id_herria = idHerri;

    SELECT CONCAT("Herriaren izena da: ", izenaHerria) AS Emaitza;
END //