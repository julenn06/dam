use azterketaerrepasoa2;

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
GROUP BY J.nombre;

        
#c)
SELECT 
    minuto, descripción, J.nombre, E.nombre
FROM
    goles AS G
        INNER JOIN
    EquipoS AS E
        INNER JOIN
    jugadores AS J
ORDER BY G.minuto ASC
LIMIT 2;


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
    J.nombre, fecha_nac, E.nombre, J2.nombre AS 'Capitan'
FROM
    jugadores J
        INNER JOIN
    equipos E ON J.id_jugador = E.id_equipo
WHERE
    fecha_nac <= '1990-01-01'
GROUP BY J.Nombre
ORDER BY fecha_nac DESC;
    
    
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