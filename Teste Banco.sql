-- o código não é compilado, selecione inteiramente as linhas de comando e clique no raio para iniciar o comando
CREATE DATABASE locadora;

USE locadora;

DROP TABLE filmes; -- deleta criações de tabelas no banco de dados (se DROP DATABASE, ele deleta o banco de dados)

CREATE TABLE  IF NOT EXISTS filmes (
codigo varchar(5) primary key,
titulo varchar(30) not null,
genero varchar(30) not null,
produtora varchar(30) not null,
dataCompra date not null); -- Está criando uma tabela no banco de dados

USE locadora;

INSERT INTO filmes(codigo,titulo,genero,produtora,dataCompra)
VALUES('1','Duro de matar','ação','Universal','2019-01-10'),
('2','Bad Boys','ação','Universal','2017-02-18'),
('3','Máquina Mortífera','ação','Sony','2015-07-14'),
('4','Vingadores','ação','Marvel','2014-12-23');

SELECT * FROM filmes;

SELECT * FROM filmes 
WHERE codigo >= 1 AND codigo <= 2
ORDER BY codigo;
