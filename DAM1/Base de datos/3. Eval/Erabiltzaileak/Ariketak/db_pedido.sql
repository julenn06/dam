use mysql;

#a)
create user adminEskaerak identified by '1234';

#Al asignar all privileges no se asigna el privilegio de grant option, por eso se lo tenemos que añadir nosotros para que tenga permisos de todo
#with grant option para que pueda crear usuarios y que hereden sus privilegios en la misma BD;
grant all privileges on db_eskaerak.* to adminEskaerak
with 
grant option;

#Para ver los permisos que tiene el usuario
show grants for adminEskaerak;


#b)
create user consulEskaerak identified by '1234';

#Permisos para crear, cambiar y eliminar tablas (create. alter, drop), para crear o eliminar los index (index) y para crear o eliminar vistas (create view)
grant create, alter, drop, index, create view on db_eskaerak.* to consulEskaerak;


#c)
#Con @localhost solo se puede conectar desde el equipo local a la base de datos
#Con el with, puede hacer un maximo de 30 consultas por hora, y solo puede haber un maximo de 4 conexiones simultaneas con el mismo usuario
CREATE USER 'procEskaerak'@'localhost' IDENTIFIED BY '1234';
GRANT USAGE ON *.* TO 'procEskaerak'@'localhost'
WITH 
  MAX_QUERIES_PER_HOUR 30
  MAX_USER_CONNECTIONS 4;



#Para crear y modificar rutinas
#Las rutinas son funciones y procedimientos que están almacenadas en el servidor de bases de datos y que pueden ser ejecutadas posteriormente
grant create routine, alter routine on db_eskaerak.* to 'procEskaerak'@'localhost';


#d)
create user modifEskaerak identified by '1234';

#Solo le vamos a dar permisos a una tabla espedifica de la base de datos
#Con el update solo vamos a poder cambiar dos atributos especificos
#References es ...
grant select, delete, update(artDes, artPVP), references(artKod) on db_eskaerak.artikulua to modifEskaerak;


#e)
#Para eliminar los permisos que nosotros queramos
revoke create routine, alter routine on db_eskaerak.* from 'procEskaerak'@'localhost';

#Eliminar usuario
drop user 'procEskaerak'@'localhost';


#f)
#Para ver los permisos que tiene el usuario
show grants for consulEskaerak;

revoke create, alter, drop on db_eskaerak.* from consulEskaerak;