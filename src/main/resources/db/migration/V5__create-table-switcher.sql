create table switch(

    id bigint not null auto_increment,
    tag varchar(100) not null,
    marca varchar(100) not null,
    modelo varchar(100) not null,
    qtd_portas bigint not null,
    category varchar(100) not null,
    active tinyint not null,

    primary key(id)
);
