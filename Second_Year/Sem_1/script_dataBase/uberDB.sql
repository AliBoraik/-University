-- ***** homework 2 ******* 

CREATE DATABASE uberdb
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1252'
    LC_CTYPE = 'Russian_Russia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

\c uberdb

create table car(car_id int not null primary key,
	 model varchar,
	 number_car varchar
);

insert into car (car_id, model, number_car) values (1, 'bmw', 'hh1231223');
insert into car (car_id, model, number_car) values (2, 'kai', 'HH343JJJ2');
insert into car (car_id, model, number_car) values (3, 'Toyota', '123456DD');
insert into car (car_id, model, number_car) values (4, 'Lada', '097DJFYRJ');
insert into car (car_id, model, number_car) values (5, 'Kia Rio', 'TEBDJ3554');
insert into car (car_id, model, number_car) values (6, 'bmw m12', 'hh1231trgb');
insert into car (car_id, model, number_car) values (7, 'kai L1', 'HH343J4545');
insert into car (car_id, model, number_car) values (8, 'Toyota camry', '126DDgfE');
insert into car (car_id, model, number_car) values (9, 'Lada H1', '097DJFakjkd');
insert into car (car_id, model, number_car) values (10, 'Kia MM2', 'TEBDJ0000');

create table client(client_id int not null primary key,
	 name varchar(255) not null,
	 phone varchar(15)
);

insert into client (client_id, name, phone) values (1, 'ALi', '896768594');
insert into client (client_id, name, phone) values (2, 'Ahmed', '896768234');
insert into client (client_id, name, phone) values (3, 'Evans', '876768556');
insert into client (client_id, name, phone) values (4, 'Raheeb', '845768594');
insert into client (client_id, name, phone) values (5, 'Hezam', '896764547');
insert into client (client_id, name, phone) values (6, 'Kamilo', '896767766');
insert into client (client_id, name, phone) values (7, 'Soaris', '896761122');
insert into client (client_id, name, phone) values (8, 'Manoyl', '876768556');
insert into client (client_id, name, phone) values (9, 'khaled', '845768594');
insert into client (client_id, name, phone) values (10, 'Keven', '896764547');

create table driver(driver_id int not null primary key,
	 car_id int not null references car (car_id),
	phone varchar(15), name varchar not null
);

insert into driver (driver_id, car_id, phone, name) values (1, 3,'845678765', 'Evan');
insert into driver (driver_id, car_id, phone, name) values (2, 2,'845672345', 'Denis');
insert into driver (driver_id, car_id, phone, name) values (3, 4,'812345678', 'Kirail');
insert into driver (driver_id, car_id, phone, name) values (4, 5,'809876543', 'Almas');
insert into driver (driver_id, car_id, phone, name) values (5, 1,'865434567', 'Timor');
insert into driver (driver_id, car_id, phone, name) values (6, 10,'84576854', 'Tom');
insert into driver (driver_id, car_id, phone, name) values (7, 9,'845345466', 'Mark');
insert into driver (driver_id, car_id, phone, name) values (8, 7,'824657686', 'Timo');
insert into driver (driver_id, car_id, phone, name) values (9, 8,'896755446', 'Salah');
insert into driver (driver_id, car_id, phone, name) values (10, 6,'8934453435', 'Marten');

create table trip(
	trip_id int not null primary key,
	client_id int not null references client (client_id),
	driver_id int not null references driver(driver_id),
	trip_date timestamp without time zone,
	trip_to varchar
);

insert into trip (trip_id, client_id, driver_id, trip_date, trip_to) values (1, 2, 2, '2021-03-12 09:53:21', 'kazan kalso 1');
insert into trip (trip_id, client_id, driver_id, trip_date, trip_to) values (2, 3, 3, '2021-09-23 04:54:11', 'kazan kalso 12');
insert into trip (trip_id, client_id, driver_id, trip_date, trip_to) values (3, 6, 4, '2021-04-12 08:55:31', 'kazan center 1');
insert into trip (trip_id, client_id, driver_id, trip_date, trip_to) values (4, 4, 5, '2021-07-21 11:52:21', 'kazan boshkna 12');
insert into trip (trip_id, client_id, driver_id, trip_date, trip_to) values (5, 8, 10, '2021-09-05 12:14:31', 'kazan karla marksa 5');
insert into trip (trip_id, client_id, driver_id, trip_date, trip_to) values (6, 2, 7, '2020-11-08 09:54:48', 'kazan derevny 2');
insert into trip (trip_id, client_id, driver_id, trip_date, trip_to) values (7, 9, 8, '2020-04-06 08:55:43', 'kazan kolso 21');
insert into trip (trip_id, client_id, driver_id, trip_date, trip_to) values (8, 3, 9, '2019-07-03 07:56:42', 'kazan center 2');
insert into trip (trip_id, client_id, driver_id, trip_date, trip_to) values (9, 10, 6, '2021-02-03 02:54:44', 'kazan boshkna 01');
insert into trip (trip_id, client_id, driver_id, trip_date, trip_to) values (10, 1, 1, '2020-03-23 03:44:42', 'kazan kalso 1');








