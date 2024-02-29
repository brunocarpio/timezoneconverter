drop table myzones if exists;

create table myzones
(
    id integer not null primary key AUTO_INCREMENT,
    zone varchar(20) not null
);
