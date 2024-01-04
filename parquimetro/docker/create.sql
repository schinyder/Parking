create table tb_cliente (nascimento date, dtcriacao timestamp(6) with time zone, id_cliente bigserial not null, email varchar(255), nome varchar(255), sexo varchar(255), primary key (id_cliente));
create table tb_endereco (numero integer not null, id_cliente bigint not null, id_endereco bigserial not null, bairro varchar(255), cep varchar(255), cidade varchar(255), endereco varchar(255), estado varchar(255), primary key (id_endereco));
create table tb_parquimetro (opcao_de_pagamento integer not null, tipo_tempo integer not null, data_hora_final timestamp(6), data_hora_inicial timestamp(6), id_cliente bigint not null, id_parquimetro bigserial not null, primary key (id_parquimetro));
create table tb_veiculo (id_cliente bigint not null, id_veiculo bigserial not null, cor varchar(255), ds_marca varchar(255), ds_modelo varchar(255), placa varchar(255), primary key (id_veiculo));
alter table if exists tb_endereco add constraint FKfybceun95o8l6dq559fji2q8n foreign key (id_cliente) references tb_cliente;
alter table if exists tb_parquimetro add constraint FK2uwck2lwvf7erjbgqj8styfbd foreign key (id_cliente) references tb_cliente;
alter table if exists tb_veiculo add constraint FKeokn901aq4as7an1nm32g7x89 foreign key (id_cliente) references tb_cliente;
