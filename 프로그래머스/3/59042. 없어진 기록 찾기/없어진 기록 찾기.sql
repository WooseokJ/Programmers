-- 코드를 입력하세요
# SELECT animal_id
select ANIMAL_OUTS.animal_id, ANIMAL_OUTS.name
from ANIMAL_INS right join ANIMAL_OUTS
on ANIMAL_INS.animal_id = ANIMAL_OUTS.animal_id
where ANIMAL_INS.animal_id is null

order by ANIMAL_INS.animal_id

# 입영간 기록 

# ANIMAL_INS: 보건소 들어온 
# ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE
# 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부

# ANIMAL_OUTS: 보호소에서 입양보낸 (입영간)
# ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME
#  동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부
