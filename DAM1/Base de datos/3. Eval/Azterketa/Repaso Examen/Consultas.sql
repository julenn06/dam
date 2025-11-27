use pizzeriadb;

#BISTAK
#Crea una vista llamada Eskaera_Pizza_Bezero que muestre el zbk, eguna, izena_pizza y izena del cliente para cada pedido.
CREATE VIEW Eskaera_Pizza_Bezero AS
    SELECT 
        e.zbk, e.eguna, e.izena_pizza, b.izena
    FROM
        eskaerak e
            INNER JOIN
        bezeroak b ON e.nan = b.nan
            INNER JOIN
        pizza p ON e.izena_pizza = p.izena_pizza;

#Prueba:
SELECT 
    *
FROM
    Eskaera_Pizza_Bezero;


#Crea una vista llamada Pizzak_Osagai_Kopuruarekin que muestre el nombre de cada pizza y cuántos ingredientes (osagaiak) tiene.
CREATE VIEW Pizzak_Osagai_Kopuruarekin AS
    SELECT 
        p.izena_pizza, COUNT(e.id_osagaia) AS osagai_kantitatea
    FROM
        pizza p
            INNER JOIN
        eduki e ON p.izena_pizza = e.izena_pizza
    GROUP BY p.izena_pizza;
    
#Prueba:
	SELECT 
    *
FROM
    Pizzak_Osagai_Kopuruarekin;
    
    
    
    
    
#PROZEDURAK
#Crea un procedimiento SartuBezeroa que reciba los datos de un nuevo cliente y lo inserte en la tabla Bezeroak.
delimiter //
create procedure SartuBezeroa(in p_nan varchar(15), in p_izena varchar(50), in p_abizena varchar(30), in p_helbidea varchar(100), in p_herria varchar(50), in p_telefonoa varchar(20), in p_emaila varchar(100))
begin
insert into bezeroak values (p_nan, p_izena, p_abizena, p_helbidea, p_herria, p_telefonoa, p_emaila);
end //
delimiter ;


#Prueba:
CALL SartuBezeroa(
    '67890123F',
    'Olatz',
    'Arrieta',
    'Ametzagaña 45',
    'Donostia',
    '600678901',
    'olatz.arrieta@example.com'
);
select * from bezeroak;




#Crea un procedimiento llamado BezeroarenEskaerak que reciba el nan de un cliente y devuelva cuántos pedidos ha hecho.
delimiter //
create procedure BezeroarenEskaerak (in p_nan varchar(15))
begin
select count(izena_pizza) as Zenbat_Eskaerak from eskaerak where nan = p_nan;
end //
delimiter ;

call BezeroarenEskaerak("12345678A");



#FUNTZIOAK
#Crea una función PrezioarekinIVA que reciba un precio y devuelva ese precio con un IVA del 21%.
delimiter //
create function PrezioarekinIVA(zbk decimal(6,2)) returns decimal(6,2)
deterministic
no sql
begin
return zbk * 1.21;
end //
delimiter ;

SELECT PREZIOAREKINIVA(20) as prezioa_IVA;



#Crea una función BezeroarenEskaeraKopurua que reciba un nan y devuelva el número total de pedidos realizados por ese cliente.
delimiter //
create function BezeroarenEskaeraKopurua(p_nan varchar(15)) returns int
deterministic
no sql
begin
declare kantitatea int;
SELECT 
    COUNT(izena_pizza)
INTO kantitatea FROM
    eskaerak
WHERE
    nan = p_nan;
return kantitatea;
end //
delimiter ;

select BezeroarenEskaeraKopurua("12345678A") as Zenbat_Eskaerak;