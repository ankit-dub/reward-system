insert into customer(id, email) values (1000, 'ankit@gmail.com');
insert into customer(id, email) values (1001, 'devank@gmail.com');
insert into customer(id, email) values (1002, 'sajal@gmail.com');

insert into my_transaction(description, amount, save_date,tenure, customer_id) values ('Emi 1', 100, '2019-10-17 10:20:10',3, 1000);
insert into my_transaction(description, amount, save_date,tenure, customer_id) values ('Emi 2', 50, '2019-10-01 10:20:10',3, 1000);
insert into my_transaction(description, amount, save_date,tenure, customer_id) values ('Emi 10', 175.32, now(),6, 1000);
insert into my_transaction(description, amount, save_date,tenure, customer_id) values ('Emi 30', 210.50, '2019-10-03 10:20:10',9, 1000);

insert into my_transaction(description, amount, save_date,tenure, customer_id) values ('Emi 200', 25.60, now(),6, 1002);
insert into my_transaction(description, amount, save_date,tenure, customer_id) values ('Emi 201', 80.50, '2019-10-05 15:00:10',6, 1002);
insert into my_transaction(description, amount, save_date,tenure, customer_id) values ('Emi 202', 116.14, now(),9, 1002);

insert into my_transaction(description, amount, save_date,tenure, customer_id) values ('Emi 5', 200, '2019-10-17 10:20:10',6, 1001);