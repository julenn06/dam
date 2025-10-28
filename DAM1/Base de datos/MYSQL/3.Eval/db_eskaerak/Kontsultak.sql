use db_eskaerak;

#01 Ariketa: pedidos

#a)
CREATE OR REPLACE VIEW artikuluMerkeak AS
    SELECT 
        artdes, artpvp
    FROM
        artikulua
    WHERE
        artpvp < 0.50;

SELECT 
    *
FROM
    artikuluMerkeak;
    


#b)
CREATE OR REPLACE VIEW artikuluMerkeak AS
    SELECT 
        a.ArtKod, a.ArtDes, COUNT(e.EskaRef), SUM(ArtKant)
    FROM
        artikulua a
            JOIN
        eskaera_lerroa e USING (artkod)
            JOIN
        eskaera USING (eskaref)
    GROUP BY a.ArtKod = a.ArtDes;
    
    
SELECT 
    *
FROM
    artikuluMerkeak;

    
#c)