use db_burger;

#1)
SELECT 
    CONCAT(izena, ' ', abizena) AS 'Bezeroa',
    helbidea AS 'Helbidea',
    herria AS 'Herria',
    bg.izena_burger,
    CONCAT(bg.prezioa, ' €') AS 'Prezioa',
    izena_osagaia AS 'Osagai Gehigarria',
    YEAR(data) AS 'Estaera Urtea'
FROM
    bezeroak b
        INNER JOIN
    eskaerak e ON b.nan = e.nan
        INNER JOIN
    burger bg ON e.id_burger = bg.id
        INNER JOIN
    osagaia o ON e.id_osagai_gehiagarria = o.id
ORDER BY izena ASC;
    
    
#2)
SELECT 
    izena_burger AS 'Burger',
    CONCAT(b.preparazio_denbora, ' min') AS 'Denbora',
    CONCAT(prezioa, ' €') AS 'Prezioa',
    o.mota AS 'Mota',
    COUNT(e.kantitatea) AS 'Osagai Kantitatea'
FROM
    burger b
        INNER JOIN
    eduki e ON b.id = e.id_burger
        INNER JOIN
    osagaia o ON e.id_osagaia = o.id
WHERE
    (SELECT 
            (SUM(preparazio_denbora)) / COUNT(preparazio_denbora)
        FROM
            burger) < b.preparazio_denbora
GROUP BY izena_burger , b.preparazio_denbora , prezioa , o.mota;


#3)
SELECT 
    izena_burger AS 'Burger',
    CONCAT(prezioa, ' €') AS 'Prezioa',
    COUNT(e.kantitatea) AS 'Osagai Kantitatea'
FROM
    burger b
        INNER JOIN
    eduki e ON b.id = e.id_burger
WHERE
    izena_burger = 'Begetala'
GROUP BY izena_burger , prezioa
ORDER BY prezioa DESC;    
    
    
#4)
SELECT 
    izena_burger AS 'Izena', CONCAT(prezioa, ' €') AS 'Prezioa'
FROM
    burger b
        INNER JOIN
    eskaerak e ON b.id = e.id_burger
        INNER JOIN
    bezeroak bez ON e.nan = bez.nan
GROUP BY izena_burger , prezioa
HAVING (COUNT(e.id_burger) > 2);


#5)
set sql_safe_updates = 0;

start transaction;
delete from bezeroak b
where b.nan not in (select nan from eskaerak);
rollback;

#6)

start transaction;
update burger b
inner join eduki e on b.id = e.id_burger
set prezioa = (prezioa / 1.2)
where (select count(id_burger) from eduki) > 1;
rollback;