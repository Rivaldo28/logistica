 CREATE TABLE produto (
     id BIGSERIAL PRIMARY KEY,
     nome VARCHAR(255) NOT NULL,
     quantidade INT NOT NULL,
     categoria VARCHAR(255) -- Adicionando uma vírgula aqui e especificando o tamanho
 );