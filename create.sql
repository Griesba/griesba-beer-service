--generated automatically using spring.jpa.properties.javax.persistence.schema-generation
create table beer (id varchar(36) not null, created_date timestamp, min_on_hand integer, modification_date timestamp,
name varchar(255), price double not null, quantity_to_brew integer, style varchar(255), upc varchar(255), version bigint, primary key (id))
alter table beer add constraint UK_p9mb364xktkjqmprmg89u2etr unique (upc)


