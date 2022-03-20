
-- домашнее задание 

-- 1. Найти полеты (flights) из аэропорта Казани в Краснодар
select * from 
	flights where
	departure_airport =
	(select airport_code from airports_data where (airport_name->'ru')::jsonb ? 'Казань')
		and 
	arrival_airport = 
	(select airport_code from airports_data where (airport_name->'ru')::jsonb ? 'Магнитогорск');


-- 2. Найти все полеты из Москвы (все аэропорты) за 25 минут (за какую дату и час придумайте сами)

select * from flights 
	where departure_airport = 
	(select airport_code from airports_data where (airport_name->'ru')::jsonb ? 'Казань')
	and 
	(
		scheduled_departure between
		'2017-09-11 12:45:00+03'
	 	and timestamp '2017-09-11 12:45:00+03' + interval '25 minutes'
	)
	order by 
		scheduled_departure desc;


-- 3. Показать все полеты в одной временной зоне (полеты и аэропорты отобразить вместе)

select * from flights,airports_data
	where 	
	flights.departure_airport = airports_data.airport_code 
	and airports_data.timezone = 'Europe/Volgograd'
	order by 
		airports_data.timezone desc;