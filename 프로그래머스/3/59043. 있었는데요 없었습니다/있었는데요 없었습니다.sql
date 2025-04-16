-- 코드를 입력하세요
# SELECT * 
select ai.animal_id, ai.name
from ANIMAL_INS ai  join ANIMAL_OUTS ao 
on ai.animal_id = ao.animal_id
where ai.datetime >= ao.datetime
order by ai.DATETIME 
;




# ANIMAL_INS
# ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
# 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부

# ANIMAL_OUTS
# ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME
# 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부

# 보호시작일(2000) < 입양일 (2010)

# 1700708 > 170609
# 170813 < 18