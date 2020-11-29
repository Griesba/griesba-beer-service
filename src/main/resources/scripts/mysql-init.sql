drop database if exists beerservice;

drop user if exists `beerservice`@`%`;

create database if not exists beerservice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

create user if not exists `beerservice`@`%` identified with mysql_native_password by `password`;

grant select, insert, update, delete, create, drop, references, index, alter, execute, create view, show view,
create routine, alter routine, event, trigger on `beerservice`.* to `beerservice`@`%`;

flush privileges;