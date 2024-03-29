Use Arcadia;

create table  [dbo].[condominio] (
       id integer IDENTITY(1,1),
        bairro varchar(255),
        cidade varchar(255),
        nome varchar(255),
        numero integer not null check (numero>=0),
        rua varchar(255),
        primary key (id)
    );

Insert into condominio (bairro,cidade,nome,numero,rua)
values ('Consolação','São Paulo','SpPalace',83,'Haddock Lobo'),
       ('Faria Lima','Rio de Janeiro', 'Rio Plazza', 9, 'Jõao de Andrade');

Insert into morador (email,nome,senha,telefone,bloco,status,responsaveis_id)
values ('bruno@gmail.com','Bruno Henrique','123','(11) 9970-3545','A',true,null),
       ('Thiago@gmail.com','Thiago Henrique','123','(11) 9873-1234','A',true,1),
       ('Nicolas@gmail.com','Nicolas','123','(11) 9566-4623','A',true,1);

Insert into porteiro (email,nome,senha,telefone,condominio_id)
values ('Willians@gmail.com','Willians Ribeiro','4321','(11) 9234-5376',1);

Insert into encomenda (codigo_de_rastreio, morador_id,condominio_id)
values ('SL123456789BR', 1, 1);
