-- 코드를 입력하세요
SELECT animal_id, name
from  ANIMAL_INS
where INTAKE_CONDITION != 'Aged'
order by animal_id


# ANIMAL_INS
# ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
# 동물의 아이디, 생물 종,       보호 시작일, 보호 시작 시 상태,   이름, 성별 및 중성화 여부

# 동물 보호소에 들어온 동물 중 젊은 동물의 아이디와 이름을 조회하는 SQL 문을 작성해주세요. 이때 결과는 아이디 순으로 조회해주세요.
# 
