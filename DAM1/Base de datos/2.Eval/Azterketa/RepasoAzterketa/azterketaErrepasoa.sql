use azterketa;

#2.2

#a)
SELECT 
    J.nombre, fecha_nac, A.nombre
FROM
    jugadores AS J
        INNER JOIN
    Equipos AS A
WHERE
    J.id_Equipo = A.id_Equipo
ORDER BY fecha_nac DESC
LIMIT 1;


#b)
SELECT 
    J.nombre, fecha_nac, COUNT(G.id_Jugador) AS 'Nº Goles'
FROM
    jugadores J
        INNER JOIN
    goles g ON J.id_jugador = G.id_Jugador
WHERE
    G.id_Jugador > 2
GROUP BY J.nombre
ORDER BY COUNT(G.id_Jugador) DESC
LIMIT 2;

        
#c)
SELECT 
    G.minuto, G.descripción, J.nombre, E.nombre
FROM
    jugadores J
        INNER JOIN
    Equipos E on E.id_equipo = J.id_equipo
        INNER JOIN
        Goles G on G.id_jugador = j.id_jugador
ORDER BY G.minuto ASC
LIMIT 1;


#d)
SELECT 
    E.nombre,
    COUNT(P.Fecha) AS 'Nº Partidos',
    SUM(P.Goles_casa) AS 'Goles en Casa',
    SUM(P.Goles_fuera) AS 'Goles Fueras',
    (SUM(P.Goles_casa) - SUM(P.Goles_fuera)) AS 'Diferencia de Goles'
FROM
    equipos E
        INNER JOIN
    partidos P ON E.id_equipo = P.id_equipo_casa
WHERE
    año_fundación < 1970
GROUP BY E.nombre
ORDER BY (SUM(P.Goles_casa) - SUM(P.Goles_fuera)) DESC;


#e)
SELECT 
    J.nombre,
    J.fecha_nac,
    E.nombre AS equipo,
    J2.nombre AS 'Capitan'
FROM
    jugadores J
        INNER JOIN
    equipos E ON J.id_jugador = E.id_equipo
        INNER JOIN
    jugadores J2 ON J2.id_jugador = E.capitán
WHERE
    J.fecha_nac <= '1990-01-01'
GROUP BY J.nombre , J.fecha_nac , E.nombre , J2.nombre
ORDER BY J.fecha_nac DESC;

    
    
#f)
SELECT 
    E.nombre AS 'Equipo Local',
    E2.nombre AS 'Equipo Visitante',
    P.Fecha,
    P.Observaciones
FROM
    equipos E
        INNER JOIN
    partidos P
        INNER JOIN
    equipos E2
WHERE
    (P.id_equipo_casa = E.id_equipo)
        AND (P.Observaciones IS NOT NULL)
ORDER BY E2.nombre DESC
LIMIT 1;


#g)
SELECT 
    j.nombre,
    COUNT(g.descripción) AS 'Nº Goles',
    ROUND(AVG(g.minuto), 0) AS 'Minuto Medio'
FROM
    jugadores j
        LEFT JOIN
    equipos e ON j.id_equipo = e.id_equipo
        LEFT JOIN
    goles g ON j.id_jugador = g.id_jugador
WHERE
    e.nombre = 'Villa F.C.'
GROUP BY j.nombre
ORDER BY COUNT(g.descripción) DESC;


#h)
SELECT 
    j.nombre,
    TIMESTAMPDIFF(YEAR,
        j.fecha_nac,
        CURDATE()) AS 'Edad',
    COUNT(g.descripción) AS 'Goles'
FROM
    jugadores j
        INNER JOIN
    equipos e ON e.id_equipo = j.id_equipo
        INNER JOIN
    goles g ON g.id_jugador = j.id_jugador
WHERE
    e.nombre LIKE '%Villa%'
GROUP BY j.nombre
ORDER BY j.fecha_nac DESC;



#2.3

#1)
START TRANSACTION;
UPDATE equipos 
SET 
    aforo = aforo + 500
WHERE
    nombre = 'Retortillo';
ROLLBACK;


#2)
START TRANSACTION;
update jugadores
set id_equipo = (Select id_equipo from equipos where nombre = "Athletic Formeñosa")
where nombre = "Carrasco";
select * from jugadores;
ROLLBACK;


#3)
START TRANSACTION;
delete from jugadores
where nombre = "Fonseca";
ROLLBACK;


#4)
SET SQL_SAFE_UPDATES = 0;
START TRANSACTION;
delete from partidos
where Goles_casa = 0 and Goles_fuera = 0;
ROLLBACK;


#5)

START TRANSACTION;

select * from jugadores
where nombre = "Quirós";

update jugadores
set id_equipo = (select id_equipo from equipos where nombre = "Valdeajos");

select * from jugadores
where nombre = "Quirós";

delete from jugadores
where nombre = "Quirós";

select * from jugadores
where nombre = "Quirós";
ROLLBACK;