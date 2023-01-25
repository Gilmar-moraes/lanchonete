create table pedido(
	id bigint not null auto_increment,
    endereco varchar(255) not null,
    nome_cliente varchar(60) not null,
    lanche varchar(20) not null,
    ingrediente varchar(20) not null,
    total float not null,
    
    primary key (id)
);