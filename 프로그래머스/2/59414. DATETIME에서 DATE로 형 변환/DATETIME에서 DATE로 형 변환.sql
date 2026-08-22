select animal_id, name, DATE_FORMAT(datetime, "%Y-%m-%d") '날짜'
from animal_ins
order by animal_id