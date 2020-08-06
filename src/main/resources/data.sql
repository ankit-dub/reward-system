insert into customer(id, email) values (1000, 'ankit@gmail.com');
insert into customer(id, email) values (1001, 'devank@gmail.com');
insert into customer(id, email) values (1002, 'vaishnavi@gmail.com');

insert into my_transaction(id, description, amount, save_date, customer_id) values (1001, 'Purchase 1', 100, '2019-10-17 10:20:10', 1000);
insert into my_transaction(id, description, amount, save_date, customer_id) values (1002, 'Purchase 2', 50, '2019-10-01 10:20:10', 1000);
insert into my_transaction(id, description, amount, save_date, customer_id) values (1004, 'Purchase 10', 175.32, '2019-10-07 10:20:10', 1000);
insert into my_transaction(id, description, amount, save_date, customer_id) values (1006, 'Purchase 30', 210.50, '2019-10-03 10:20:10', 1000);

insert into my_transaction(id, description, amount, save_date, customer_id) values (1200, 'Purchase 200', 25.60, '2019-10-01 12:20:10', 1002);
insert into my_transaction(id, description, amount, save_date, customer_id) values (1201, 'Purchase 201', 80.50, '2019-10-05 15:00:10', 1002);
insert into my_transaction(id, description, amount, save_date, customer_id) values (1202, 'Purchase 202', 116.14, '2019-10-10 11:30:10', 1002);

insert into my_transaction(id, description, amount, save_date, customer_id) values (1008, 'Purchase 5', 200, '2019-10-17 10:20:10', 1001);