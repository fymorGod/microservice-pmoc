create table users(

    id bigint not null auto_increment,
    name varchar(100) not null,
    last_name varchar(100) not null,
    contact varchar(11) not null,
    company varchar(100) not null,
    contact_company varchar(100) not null,
    active tinyint not null,

    primary key(id)
);
