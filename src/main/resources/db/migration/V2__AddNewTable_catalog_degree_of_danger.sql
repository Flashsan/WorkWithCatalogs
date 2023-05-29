create table catalog_degree_of_danger
(
    id_degree_of_danger    int auto_increment,
    title_degree_of_danger varchar(30),
    constraint catalog_degree_of_danger_pk primary key (id_degree_of_danger)
);

insert into catalog_degree_of_danger(title_degree_of_danger)
values ('Чрезвычайно опасные'),
       ('Умеренно опасные'),
       ('Малоопасные'),
       ('н/о');







