-- 코드를 입력하세요
SELECT month(start_date) as MONTH, CAR_ID, count(car_id) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE between '2022-08-01' and '2022-10-31' and
    car_id in (select car_id
              from CAR_RENTAL_COMPANY_RENTAL_HISTORY
               where START_DATE between '2022-08-01' and '2022-10-31'
                group by car_id
               having count(*) >= 5
            )
group by month, car_id

order by MONTH , car_id desc

# order by month(start_date)

# HISTORY_ID, CAR_ID, START_DATE, END_DATE
# 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일