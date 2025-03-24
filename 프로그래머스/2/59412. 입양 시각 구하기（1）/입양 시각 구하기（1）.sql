-- 코드를 입력하세요
SELECT Hour(datetime) HOUR, count(*) COUNT
from ANIMAL_OUTS
where date_format(DATETIME, '%H:%i') between '09:00' and '19:59'
group by HOUR
order by HOUR
# select * 
# from ANIMAL_OUTS
# where date_format(DATETIME, '%H:%i') between '09:00' and '19:59'
# order by datetime


# ANIMAL_OUTS
# ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME
#  동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부

