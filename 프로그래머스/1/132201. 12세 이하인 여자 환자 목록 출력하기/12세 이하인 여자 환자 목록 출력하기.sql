-- 코드를 입력하세요
SELECT pt_name, pt_no, gend_cd, age, case when tlno is null then 'NONE'
                                                else tlno 
                                                end as tlno
from PATIENT
where GEND_CD = 'W' 
    and age <= 12
order by age desc, pt_name
    
    
;


# PATIENT
# PT_NO, PT_NAME, GEND_CD, AGE, TLNO
# 환자번호, 환자이름, 성별코드, 나이, 전화번호

# 12세 이하인 여자환자의 환자이름, 환자번호, 성별코드, 나이, 전화번호를 조회하는 SQL문을 작성해주세요. 
# 이때 전화번호가 없는 경우, 'NONE'으로 출력시켜 주시고 결과는 나이를 기준으로 내림차순 정렬하고, 나이 같다면 환자이름을 기준으로 오름차순 정렬해주세요.

