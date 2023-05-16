create table nobreaks(

    id bigint not null auto_increment,
    tag varchar(100) not null,
    marca varchar(100) not null,
    modelo varchar(100) not null,
    tensao_entrada bigint,
    tensao_saida bigint,
    category varchar(100) not null,
    active tinyint not null,

    primary key(id)
);
