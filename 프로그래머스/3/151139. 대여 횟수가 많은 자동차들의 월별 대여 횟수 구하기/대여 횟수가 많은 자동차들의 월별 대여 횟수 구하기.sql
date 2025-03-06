-- 코드를 입력하세요
SELECT month(start_date) as MONTH, car_id as CAR_ID, count(history_id) as RECORDS
from  CAR_RENTAL_COMPANY_RENTAL_HISTORY

where  start_date >= '2022-08-01' and start_date <= '2022-10-31' and car_id in (
    select car_id 
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date >= '2022-08-01' and start_date <= '2022-10-31' 
    group by car_id
    having count(history_id) >= 5
)
group by month, car_id

order by month, car_id desc;


# CAR_RENTAL_COMPANY_RENTAL_HISTORY
# HISTORY_ID,       CAR_ID, START_DATE, END_DATE
# 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일

#  2022.10>= start_date>=2022.8, count(history_id) >= 5
# group by car_id
# month()