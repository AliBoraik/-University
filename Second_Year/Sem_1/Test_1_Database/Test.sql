
-- 2)
-- Max :
SELECT MAX(total_amount) FROM bookings
		where book_date >= '2017-06-01'::date
		   and book_date <= '2017-06-30'::date;


Min:
SELECT MIN(total_amount) FROM bookings
		where book_date >= '2017-06-01'::date
		   and book_date <= '2017-06-30'::date;		   

Average:
SELECT AVG(total_amount) FROM bookings
		where book_date >= '2017-06-01'::date
		   and book_date <= '2017-06-30'::date;		   

-- 3)

Select ti.passenger_name,MAX(b.total_amount) from tickets ti join bookings b on
    ti.book_ref = b.book_ref where book_date >= '2017-06-25'::date
           and book_date <= '2017-06-26'::date GROUP BY ti.passenger_name;


-- 5)

create database farm;
\c farm;

create table veterinary (
    id serial  primary key,
    name varchar ,
    experience int check(experience > 2)
);
create table animal (
    type varchar
);
create table stable (
    number serial primary key,
    stall integer check(stall > 9 and stall < 51),
    veterinary_id integer references veterinary(id)

create table room (
 id not null primary key,
 name varchar,
 age int check ( age < 51 )
);

-- 6)

 Select t.passenger_name,t.contact_data from tickets t 
	join ticket_flights tf on t.ticket_no = tf.ticket_no 
 	where tf.fare_conditions = 'Economy' and tf.flight_id = 
		(select f.flight_id from flights f where arrival_airport = 
			(select airport_code from airports_data where (airport_name->'ru')::jsonb ? 'Петрозаводск'));  


-- 7)

select f.departure_airport,f.arrival_airport,f.flight_no,f.scheduled_departure
    from flights f join seats s on f.aircraft_code = s.aircraft_code
            where s.seat_no = '20A';






