--generated automatically using spring.jpa.properties.javax.persistence.schema-generation
create table beer (id varchar(36) not null, created_date timestamp, min_on_hand integer, modification_date timestamp,
name varchar(255), price double not null, quantity_to_brew integer, style varchar(255), upc varchar(255), version bigint, primary key (id))
alter table beer add constraint UK_p9mb364xktkjqmprmg89u2etr unique (upc)

drop database if exists beerservice;

drop user if exists `beerservice`@`%`;

create database if not exists beerservice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

create user if not exists `beerservice`@`%` identified with mysql_native_password by `password`;

grant select, insert, update, delete, create, drop, references, index, alter, execute, create view, show view,
create routine, alter routine, event, trigger on `beerservice`.* to `beerservice`@`%`;

flush privileges;
