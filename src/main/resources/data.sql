INSERT INTO conta (id_conta, nome_responsavel) VALUES (1,'Fulano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (2,'Sicrano');

INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (1,'2019-01-01 12:00:00+03',30895.46,'DEPOSITO', '', 1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (2,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', '',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (3,'2019-05-04 08:12:45+03',-500.50,'SAQUE', '',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (4,'2019-08-07 08:12:45+03',-530.50,'SAQUE', '',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (5,'2020-06-08 10:15:01+03',3241.23,'TRANSFERENCIA', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (6,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (7,'2021-04-01 12:12:04+03',10.00,'TRANSFERENCIA', 'Josias',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (8,'2021-04-01 12:12:04+03',-100.00,'SAQUE', '',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (9,'2021-04-01 12:12:04+03',200.00,'DEPOSITO', '',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (10,'2021-04-01 12:12:04+03',200.00,'TRANSFERENCIA', 'Beltrano',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (11,'2021-04-01 12:12:04+03',200.00,'TRANSFERENCIA', 'Dercy',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (12,'2021-04-01 12:12:04+03',-100.00,'SAQUE', '',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (13,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', '',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (14,'2022-02-03 09:53:27+03',35.00,'TRANSFERENCIA', 'Josias',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (15,'2022-02-03 09:53:27+03',505.65,'TRANSFERENCIA', 'Ronnyscley',1);
