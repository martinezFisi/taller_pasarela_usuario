drop table USUARIO if exists;

create table USUARIO (ID bigint identity primary key, CODIGO varchar(9) not null, NOMBRE varchar(50) not null, CORREO varchar(50),ESCUELA VARCHAR(30) not null, unique(CODIGO));
                        
ALTER TABLE USUARIO ALTER COLUMN BALANCE SET DEFAULT 0.0;
