CREATE TABLE conta
(
    id_conta IDENTITY NOT NULL PRIMARY KEY,
    nome_responsavel VARCHAR(50) NOT NULL
);


CREATE TABLE transferencia
(
    id IDENTITY NOT NULL PRIMARY KEY,
    data_transferencia TIMESTAMP WITH TIME ZONE NOT NULL,
    valor NUMERIC (20,2) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    nome_operador_transacao VARCHAR (50),
    conta_id INT NOT NULL,

        CONSTRAINT FK_CONTA
        FOREIGN KEY (conta_id)
        REFERENCES conta(id_conta)
);

INSERT INTO conta (id_conta, nome_responsavel) VALUES (1,'Fulano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (2,'Sicrano');

INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (1,'2019-01-01 12:00:00+03',30895.46,'DEPOSITO', 'Jonas', 1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (2,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', 'Anne',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (3,'2019-05-04 08:12:45+03',-500.50,'SAQUE', 'Júlia',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (4,'2019-08-07 08:12:45+03',-530.50,'SAQUE','Kleber',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (5,'2020-06-08 10:15:01+03',3241.23,'TRANSFERENCIA', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (6,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (7,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley',2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (8, '2021-05-15 09:30:00+03', 1000.00, 'DEPOSITO', 'Maria', 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (9, '2021-06-20 14:45:00+03', 500.50, 'SAQUE', 'João', 2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (10, '2021-07-01 16:00:00+03', 2000.00, 'DEPOSITO', 'Pedro', 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (11, '2021-07-10 11:30:00+03', -300.75, 'SAQUE', 'Mariana', 2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (12, '2021-07-15 13:45:00+03', 1500.00, 'DEPOSITO', 'Kleber', 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (13, '2021-07-22 10:00:00+03', -1000.50, 'SAQUE', 'Gustavo', 2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (14, '2021-08-05 09:30:00+03', 800.00, 'DEPOSITO', 'Fernanda', 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (15, '2021-08-12 14:45:00+03', -250.25, 'SAQUE', 'Kleber', 2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (16, '2021-08-20 16:00:00+03', 3000.00, 'DEPOSITO', 'Kleber', 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (17, '2021-09-05 11:30:00+03', -500.50, 'SAQUE', 'Antônio', 2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (18, '2021-09-10 13:45:00+03', 1200.00, 'DEPOSITO', 'Isabela', 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (19, '2021-09-18 10:00:00+03', -750.75, 'SAQUE', 'Kleber', 2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (20, '2021-10-02 09:30:00+03', 600.00, 'DEPOSITO', 'Beatriz', 1);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (21, '2021-10-08 14:45:00+03', -150.25, 'SAQUE', 'Vinicius', 2);
INSERT INTO transferencia (id, data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (22, '2021-10-15 16:00:00+03', 4000.00, 'DEPOSITO', 'Kleber', 1);
