select history_id, car_id, start_date, end_date, if(DATEDIFF(end_date, start_date)+1 >=30, '장기 대여', '단기 대여') 'RENT_TYPE'
from car_rental_company_rental_history
where start_date like '2022-09%'
order by history_id desc