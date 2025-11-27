use pizzeriadb;

#Bistak
#1) Vista de pedidos con datos de cliente y pizza

CREATE VIEW Eskaera_Infoa AS
    SELECT 
        b.izena, b.abizena, izena_pizza, eguna
    FROM
        bezeroak b
            INNER JOIN
        eskaerak e ON b.nan = e.nan;

select * from Eskaera_Infoa;


#2) Alterar una vista para añadir el email del cliente
ALTER VIEW Eskaera_Infoa AS 
SELECT 
        b.izena, b.abizena, b.emaila izena_pizza, eguna
    FROM
        bezeroak b
            INNER JOIN
        eskaerak e ON b.nan = e.nan;
        
        SELECT * FROM Eskaera_Infoa;
        
#3) Eliminar una vista
drop view Eskaera_Infoa;



#Prozedurak
#1) Crea un procedimiento que reciba como parámetros la fecha, el nan, el nombre de una pizza y el id de un ingrediente adicional, y registre el pedido en la tabla Eskaerak.
delimiter //
create procedure prozedura1 (in sartuData date, in sartuNan varchar(15), in sartuIzena varchar(30), in sartuOsagaia int)
begin
insert into Eskaerak (eguna, nan, izena_pizza, id_osagai_gehigarria) values (sartuData, sartuNan, sartuIzena, sartuOsagaia);
end //
delimiter ;

call prozedura1("2025-04-01", "12345678A", "Vegetariana", 2);

select * from Eskaerak;


#2) Crea un procedimiento que, dado el nan de un cliente, elimine todos sus pedidos de la tabla Eskaerak.
delimiter //
create procedure prozedura2 (in sartuNan varchar(15))
begin
delete from Eskaerak where nan = sartuNan;
end //
delimiter ;

call prozedura2("12345678A");

select * from eskaerak;


#3) Crea un procedimiento que reciba el id de un ingrediente adicional y aumente en 1€ el precio de todas las pizzas que han sido pedidas con ese ingrediente como extra (Eskaerak).

delimiter //
create procedure prozedura3 (in sartuId int)
begin
update pizza p inner join eskaerak e on p.izena_pizza = e.izena_pizza and e.id_osagai_gehigarria = sartuId set prezioa = prezioa + 1;
end //
delimiter ;

call prozedura3(4);

select * from pizza;


#Funtzioak
#1)Crea una función que reciba el nombre de una pizza y devuelva su precio.
delimiter //
create function funtzio1 (izenaPizza varchar(30)) returns decimal(8,2)
deterministic
no sql
begin
declare prezioPizza decimal(8,2);

select prezioa into prezioPizza from pizza where izena_pizza = izenaPizza;

return prezioPizza;
end //
delimiter ;

select * from pizza;

SELECT FUNTZIO1('Barbekoa') AS Prezioa_Pizza;


#2)Crea una función que reciba el nombre de una pizza y devuelva cuántos ingredientes distintos lleva según la tabla Eduki.
delimiter //
create function funtzio2(izenaPizza varchar(30)) returns int
deterministic
no sql
begin
declare zenbatOsagai int;

select count(izena_pizza) into zenbatOsagai from eduki where izena_pizza = izenaPizza;

return zenbatOsagai;
end //
delimiter ;

select funtzio2("Barbekoa") as kantitate_Osagai;


#3) Crea una función que reciba el nan de un cliente y devuelva el total gastado sumando los precios de todas las pizzas que ha pedido.
delimiter //
create function funtzio3 (nanBezero varchar(15))returns decimal(8,2)
deterministic
no sql
begin
declare totala decimal (8,2);
SELECT 
    SUM(p.prezioa)
INTO totala FROM
    pizza p
        INNER JOIN
    eskaerak e ON p.izena_pizza = e.izena_pizza
WHERE
    e.nan = nanBezero;

return totala;
end //
delimiter ;

SELECT FUNTZIO3('23456789B') AS TotalaOrdaintuta;


#Kursoreak
#1)Crea un cursor para listar las pizzas que tienen más de 2 ingredientes.
delimiter //
create procedure procedure1()
begin
declare izenaPizza varchar(30);
declare amaituta boolean default 0;
declare c cursor for
 SELECT p.izena_pizza
        FROM pizza p
        INNER JOIN eduki e ON p.izena_pizza = e.izena_pizza
        GROUP BY p.izena_pizza
        HAVING COUNT(e.izena_pizza) > 2;
declare continue handler for not found set amaituta = 1;
open c;
fetch c into izenaPizza;

while amaituta = 0 do
select concat(izenaPizza);
fetch c into izenaPizza;
end while;

close c;
end //
delimiter ;

call procedure1();


#2) Calcular el gasto total por cliente usando un cursor.
drop procedure procedure2;
delimiter //
create procedure procedure2()
begin
declare nanBezero varchar(15);
declare totala decimal(8,2);
declare amaiera boolean default 0;
declare c cursor for 
select b.nan, sum(p.prezioa) from bezeroak b inner join eskaerak e on b.nan = e.nan inner join pizza p on e.izena_pizza = p.izena_pizza group by b.nan;

declare continue handler for not found set amaiera = 1;
open c;
fetch c into nanBezero, totala;

while amaiera = 0 do
select concat("Bezeroaren NAN: " , nanBezero , ", Ordaindu duen Totala: " , totala) as Datuak;
fetch c into nanBezero, totala;
end while;

close c;
end //
delimiter ;

call procedure2();


#3) Crear un cursor que actualice precios dinámicamente según ingredientes.
drop procedure procedure3;
delimiter //
create procedure procedure3()
begin
    declare izena varchar(30);
    declare denbora int;
    declare prezioa decimal(8,2);
    declare osagai_Kantitatea int;
    declare amaiera boolean default 0;

    declare c cursor for
        select p.izena_pizza, p.preparazio_denbora, p.prezioa, count(e.izena_pizza) as OsagaiKantitatea
        from pizza p
        inner join eduki e on p.izena_pizza = e.izena_pizza
        group by p.izena_pizza, p.preparazio_denbora, p.prezioa;

    declare continue handler for not found set amaiera = 1;

    open c;
    fetch c into izena, denbora, prezioa, osagai_Kantitatea;

    while amaiera = 0 do
        if (osagai_Kantitatea >= 3) then
            update pizza set prezioa = prezioa * 1.1 where izena_pizza = izena;
SELECT 
    CONCAT('Izena: ',
            izena,
            ' Denbora: ',
            denbora,
            ' Prezio Berria: ',
            prezioa,
            ' Osagai Kantitatea: ',
            osagai_Kantitatea) AS Datuak;
        end if;

        if (osagai_Kantitatea <= 2) then
            update pizza set prezioa = prezioa * 0.95 where izena_pizza = izena;
SELECT 
    CONCAT('Izena: ',
            izena,
            ' Denbora: ',
            denbora,
            ' Prezio Berria: ',
            prezioa,
            ' Osagai Kantitatea: ',
            osagai_Kantitatea) AS Datuak;
        end if;

        fetch c into izena, denbora, prezioa, osagai_Kantitatea;
    end while;

    close c;
end //
delimiter ;

call procedure3();


#4) Recorre todas las pizzas y compara su precio con la media de todas las pizzas.
drop procedure procedure4;
delimiter //
create procedure procedure4()
begin
    declare media decimal(8,2);
    declare precioOriginal decimal(8,2);
    declare amaiera boolean default 0;
    declare izena varchar(30);
    declare modificado boolean;
    
    declare c cursor for
        select izena_pizza, prezioa from pizza;

    declare continue handler for not found set amaiera = 1;

SELECT 
    AVG(prezioa)
INTO media FROM
    pizza;

    open c;
    fetch c into izena, precioOriginal;

    while amaiera = 0 do
        if (precioOriginal <= media) then
            update pizza 
            set prezioa = prezioa * 1.05 
            where izena_pizza = izena;

            set modificado = true;
        else
            set modificado = false;
        end if;

SELECT 
    CONCAT('Pizzaren Izena: ',
            izena,
            ' - Prezioa Aldatu Da? ',
            IF(modificado, 'Bai', 'Ez')) AS Datuak;

        fetch c into izena, precioOriginal;
    end while;

    close c;
end //

delimiter ;

call procedure4();


#5) Para cada cliente, muestra qué pizza ha pedido más veces.
drop procedure procedure5;
delimiter //
create procedure procedure5()
begin
declare izena varchar(30);
declare zenbatOsagai int;
declare prezioBerria decimal(8,2);
declare amaiera boolean default 0;
declare aldatuDa boolean default false;


declare c cursor for
select izena_pizza, count(id_osagaia) from eduki group by izena_pizza;

declare continue handler for not found set amaiera = 1;

open c;

fetch c into izena, zenbatOsagai;
while amaiera = 0 do
if (zenbatOsagai = 1) then
update pizza set prezioa = prezioa * 0.90 where izena_pizza = izena;
SELECT 
    prezioa
INTO prezioBerria FROM
    pizza
WHERE
    izena_pizza = izena;
    set aldatuDa = true;
end if;

if (zenbatOsagai between 2 and 4) then
select prezioa into prezioBerria from pizza where izena_pizza = izena;
    set aldatuDa = false;
end if;

if (zenbatOsagai > 4) then
update pizza set prezioa = prezioa * 1.15 where izena_pizza = izena;
SELECT 
    prezioa
INTO prezioBerria FROM
    pizza
WHERE
    izena_pizza = izena;
    set aldatuDa = true;
end if;

SELECT 
    CONCAT('Pizzaren izena: ',
            izena,
            ', Zenbat Osagai: ',
            zenbatOsagai,
            ', Prezio Berria: ',
            prezioBerria,
            ', Prezioa Aldatu Da? ',
            IF(aldatuDa, 'Bai', 'Ez')) AS Datuak;

fetch c into izena, zenbatOsagai;

end while;

end //
delimiter ;

call procedure5();


#6) Crea un procedimiento con un cursor que recorra las pizzas con un precio superior a 15.
set SQL_SAFE_UPDATES = 0;
drop procedure procedure6;
delimiter //
create procedure procedure6()
begin

declare izena varchar(30);
declare prezioOriginala decimal(8,2);
declare prezioFinala decimal(8,2);
declare amaiera boolean default 0;

declare c cursor for 
select izena_pizza, prezioa from pizza where prezioa >= 15;

declare continue handler for not found set amaiera = 1;

open c;

fetch c into izena, prezioOriginala;

while amaiera = 0 do

update pizza set prezioa = prezioa * 1.1 where izena_pizza = izena;

SELECT 
    prezioa
INTO prezioFinala FROM
    pizza
WHERE
    izena_pizza = izena;

SELECT 
    CONCAT('Pizzaren Izena: ',
            izena,
            ', Hasierako Prezioa: ',
            prezioOriginala,
            ', Amaierako Prezioa: ',
            prezioFinala) as Datuak;

fetch c into izena, prezioOriginala;

end while;

close c;

end //
delimiter ; 

call procedure6(); 

#7) Procedimiento para eliminar pedidos de clientes inactivos
DROP PROCEDURE IF EXISTS procedure7;
DELIMITER //
CREATE PROCEDURE procedure7()
BEGIN
    DECLARE zenbatEgun DATE;
    DECLARE idEskaera INT;
    DECLARE amaiera BOOLEAN DEFAULT FALSE;

    DECLARE c CURSOR FOR 
        SELECT id_eskaera, eguna FROM eskaerak;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET amaiera = TRUE;

    OPEN c;

    fetch_loop: LOOP
        FETCH c INTO idEskaera, zenbatEgun;
        IF amaiera THEN
            LEAVE fetch_loop;
        END IF;

        IF DATEDIFF(CURDATE(), zenbatEgun) > 30 THEN
            DELETE FROM eskaerak WHERE id_eskaera = idEskaera;
        END IF;
    END LOOP;

    CLOSE c;
END //
DELIMITER ;


call procedure7();

select * from eskaerak;

#kursoreak kudeatzeko salbuespenak
#1) Manejo de excepción al actualizar precios de pizzas
drop procedure ext1;
delimiter //
create procedure ext1()
begin
    declare izena varchar(30);
    declare prezioPizza decimal(8,2);
    declare amaitu boolean default 0;
    declare errorea boolean default 0;
    
    declare c cursor for
    select izena_pizza, prezioa from pizza;
    
    declare continue handler for not found set amaitu = 1;
    
    declare continue handler for 1365 set errorea = 1;
    
    open c;
    fetch c into izena, prezioPizza;
    
    while amaitu = 0 do
    
        update pizza set prezioa = prezioa * 1.1 where izena_pizza = izena;
        
        if prezioPizza > 30 then
            update pizza set prezioa = prezioa / 0;
        end if;
        
        if errorea = 1 then
            select concat("No se puede dividir entre 0 para la pizza: ", izena);
            set errorea = 0;
        end if;
        
        fetch c into izena, prezioPizza;
    end while;
    
    close c;
end //
delimiter ;


call ext1();



#2)Manejo de excepción al eliminar registros de eskaerak.
drop procedure ext2;
delimiter //
create procedure ext2()
begin
    declare eguna date;
    declare nan varchar(15);
    declare izena varchar(30);
    declare id_osagai int;

    declare amaiera boolean default 0;

    declare c cursor for 
    select eguna, nan, izena_pizza, id_osagai_gehigarria from eskaerak;

    declare continue handler for not found set amaiera = 1;
    declare continue handler for 1451 set amaiera = 1;

    open c;

    fetch c into eguna, nan, izena, id_osagai;

    while amaiera = 0 do
        delete from eskaerak where izena_pizza = izena;

        if amaiera = 1 then
            select concat('Error al eliminar registro con izena_pizza: ', izena);
        end if;

        fetch c into eguna, nan, izena, id_osagai;
    end while;

    close c;

end //
delimiter ;

call ext2();



#3) Procedimiento para eliminar pedidos de clientes inactivos.