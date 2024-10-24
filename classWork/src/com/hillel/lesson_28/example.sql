SHOW TABLES;

-- Получить список всех городов
SELECT *
from city;

-- Получить список всех видов спорта:
SELECT *
from sport
order by sport_name;

-- Найти все игры, которые проходили в определенном году:
select *
from games
where games_year = 2016;

--  Найти имена спортсменов определенного пола:
select full_name, count(full_name)
from person
where gender = 'M'
group by full_name
order by full_name desc;

select SUBSTRING_INDEX(full_name, ' ', 1)  as first_name,
       SUBSTRING_INDEX(full_name, ' ', -1) as last_name
from person;


select SUBSTRING_INDEX(full_name, ' ', 1) as first_name
     , nr.region_name
from person p
         left join person_region pr on pr.person_id = p.id
         left join noc_region nr on nr.id = pr.region_id;


select SUBSTRING_INDEX(full_name, ' ', 1) as first_name,
       nr.region_name,
       count(full_name)
from person p
         left join person_region pr on pr.person_id = p.id
         left join noc_region nr on nr.id = pr.region_id
where nr.region_name = 'Ukraine'
group by first_name
order by count(full_name) desc
limit 10 offset 10;


select p.full_name, nr.region_name
from person p
         left join person_region pr on pr.person_id = p.id
         left join noc_region nr on nr.id = pr.region_id
where (full_name like 'Igor%' or full_name like 'Ihor%')
  AND nr.region_name = 'Ukraine';


select p.full_name,
       nr.region_name,
       g.games_name,
       c.city_name,
       event_name,
       sport_name,
       medal_name
from person p
         left join person_region pr on pr.person_id = p.id
         left join noc_region nr on nr.id = pr.region_id
         left join olympics.games_competitor gcomp on p.id = gcomp.person_id
         left join olympics.games g on g.id = gcomp.games_id
         left join olympics.games_city gc on g.id = gc.games_id
         left join olympics.city c on gc.city_id = c.id
         left join competitor_event ce on ce.competitor_id = gcomp.id
         left join olympics.event e on ce.event_id = e.id
         left join olympics.sport s on e.sport_id = s.id
         left join medal m on ce.medal_id = m.id
# where  nr.region_name = 'Ukraine' and (m.medal_name = 'Gold' or medal_name = 'Silver' or medal_name = 'Bronze')
where nr.region_name = 'USA'
  and m.medal_name in ('Gold', 'Silver', 'Bronze')
order by g.games_name;


-- Получить количество спортсменов, участвовавших в каждом виде спорта:
SELECT sport_name,
       count(distinct person_id)                    as uniq_count,
       count(person_id)                             as count,
       count(person_id) / count(distinct person_id) as times
from sport
         left join olympics.event e on sport.id = e.sport_id
         left join olympics.competitor_event ce on e.id = ce.event_id
         left join games_competitor gc on ce.competitor_id = gc.id
group by sport_name
order by count(person_id) desc;


-- Получить список всех городов, в которых проводились игры летом:
Select distinct c.city_name
from city c
         left join olympics.games_city gc on c.id = gc.city_id
         left outer join olympics.games g on g.id = gc.games_id
where g.season = 'Summer' order by city_name;
