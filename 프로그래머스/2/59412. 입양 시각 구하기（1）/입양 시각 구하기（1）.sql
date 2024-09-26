-- 코드를 입력하세요
SELECT hour(datetime) as hour, count(*)
from ANIMAL_OUTS
where date_format(datetime, '%H%i') between '09:00' and '20:00'
group by hour
order by hour 
;

# ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME
# 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부