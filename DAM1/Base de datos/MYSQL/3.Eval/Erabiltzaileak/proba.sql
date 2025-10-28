use mysql;

describe user;

#Erakutsi erabiltzaile guztiak
SELECT 
    *
FROM
    user;

#Sortu erabiltzailea
CREATE USER julen IDENTIFIED BY '1234'
PASSWORD EXPIRE NEVER;

CREATE USER julen2 IDENTIFIED BY '1234'
WITH
MAX_QUERIES_PER_HOUR 100
PASSWORD EXPIRE NEVER;

CREATE USER julen3@'localhost' identified by '1234';

#Ezabatu erabiltzaile bat
drop user julen;
DROP USER julen3@'localhost';



#Baimenak ezarri
GRANT ALL PRIVILEGES ON db_burger.* TO julen; #Datu base bakarrari sarbidea eta taula guztiei sarbidea

grant select on db_pedidos.* to julen; #Datu base bakarrari select guztiak egin ahal izateko


#ROLak sortu
create user julen4 identified by '1234', julen5 identified by '1234'
default role RolVentas;