-- 코드를 입력하세요
SELECT date_format(start_date, "%m") as month, car_id, count(HISTORY_ID) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where date_format(start_date, "%Y-%m") between '2022-08' and '2022-10' and car_id in (
                select car_id
                from CAR_RENTAL_COMPANY_RENTAL_HISTORY
                where date_format(start_date, "%Y-%m") between '2022-08' and '2022-10'
    group by car_id
    having count(car_id) >= 5
            )

group by month, car_id
# having record > 0
order by month asc, car_id desc;

# where '2022-08-01' < start_date and start_date < '2022-11-01'
# order by car_id desc; 
