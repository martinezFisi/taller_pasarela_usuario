drop table USUARIO if exists;

create table USUARIO (ID bigint identity primary key, CODIGO varchar(9),
                        NAME varchar(50) not null, unique(CODIGO));

