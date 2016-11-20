drop table USUARIO if exists;
drop table CONCEPTO if exists;

create table USUARIO (ID bigint identity primary key, CODE varchar(8),
                        NAME varchar(50) not null, EMAIL varchar(50) , EAP varchar(30) , unique(CODE));

create table CONCEPTO (ID_P bigint identity primary key, descripcion varchar(30), id_concepto varchar(10), monto varchar(4), unique(id_concepto));
