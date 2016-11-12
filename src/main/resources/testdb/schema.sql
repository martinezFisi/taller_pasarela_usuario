drop table USUARIO if exists;

create table USUARIO (ID bigint identity primary key, CODE varchar(8),
                        NAME varchar(50) not null, EMAIL varchar(50) , EAP varchar(30) , unique(CODE));

