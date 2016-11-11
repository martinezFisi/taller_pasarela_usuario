drop table USUARIO if exists;

create table USUARIO (ID bigint identity primary key, NUMBER varchar(9),
                        NAME varchar(50) not null, BALANCE decimal(8,2), unique(NUMBER));
                        
ALTER TABLE USUARIO ALTER COLUMN BALANCE SET DEFAULT 0.0;
