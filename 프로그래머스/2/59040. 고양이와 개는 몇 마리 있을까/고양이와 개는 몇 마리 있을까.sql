-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(*) count
from ANIMAL_INS
group by ANIMAL_TYPE
order by ANIMAL_TYPE


# ANIMAL_INS
# ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
# 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부

# 