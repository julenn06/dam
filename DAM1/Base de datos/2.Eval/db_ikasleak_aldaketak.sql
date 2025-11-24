use db_ikasleak01ikasleak;

#a)

alter table ikasleak
add NAN char(9) not null;


#b)

alter table ikaskeak
add unique (NAN);


#c)

alter table ikasleak
add hizkuntza varchar(10) not null;

alter table ikasleak
modify hizkuntza varchar(28) not null;

#d + e) )

alter table ikasleak 
modify hizkuntza enum ('euskera','gaztelania','ingelesa','frantsesa') default 'ingelesa';

#g)

alter table ikasleak
drop hizkuntza;


#h)
alter table ikasle_zikloa
rename ika_zik;