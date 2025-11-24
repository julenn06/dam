use db_enpresa;

#02 Ariketa: db_enpresa

#a)
CREATE OR REPLACE VIEW Langile20 AS
    SELECT 
        izena, postua, komisioa, soldata
    FROM
        langilea
    WHERE
        saila = 20;


SELECT 
    *
FROM
    Langile20;



#b)
insert into Langile20
values("Gartzia", "langilea", 1200, 100);



#c)
