insert into customer(id, email,Apprvamount) values (1000, 'ankit@gmail.com',500000);
insert into customer(id, email,Apprvamount) values (1001, 'devank@gmail.com',350000);
insert into customer(id, email,Apprvamount) values (1002, 'sajal@gmail.com',600000);

insert into my_transaction(description, amount, tenure, customer_id) values ('Emi 1', 100000 ,3, 1000);
insert into my_transaction(description, amount, tenure, customer_id) values ('Emi 2', 50000 ,3, 1000);
insert into my_transaction(description, amount, tenure, customer_id) values ('Emi 10', 175320,6, 1000);
insert into my_transaction(description, amount, tenure, customer_id) values ('Emi 30', 210500,9, 1000);

insert into my_transaction(description, amount, tenure, customer_id) values ('Emi 200', 25600,6, 1002);
insert into my_transaction(description, amount, tenure, customer_id) values ('Emi 201', 80500,6, 1002);
insert into my_transaction(description, amount, tenure, customer_id) values ('Emi 202', 11614,9, 1002);

insert into my_transaction(description, amount, tenure, customer_id) values ('Emi 5', 20000,6, 1001);