use db_eskaerak2;

#1)
#Into sirve para volcar lo que me devuelva el select en una variable
delimiter //
create procedure eskaerakEzabatu(in eskaeraRef int)
begin
declare v_eguna date;
select eguna into v_eguna from eskaera where eskaerazbk = eskaeraRef;

select concat(eskaeraRef, 'Eskaera Data: ', v_eguna, ' da.') as EskaeraData;

delete from eskaera
where eskaerazbk = eskaeraRef;

select concat(eskaeraRef, ' eskaera ezabatu egin da');
end
//

call eskaerakEzabatu(1);