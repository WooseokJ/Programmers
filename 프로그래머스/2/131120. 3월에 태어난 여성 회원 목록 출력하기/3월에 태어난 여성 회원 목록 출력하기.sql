-- 코드를 입력하세요
SELECT member_id, member_name, gender, date_format(date_of_birth, '%Y-%m-%d') as date_of_birth
from MEMBER_PROFILE
where month(date_of_birth) = 3 and tlno is not null and gender = 'W'
order by member_id 
;


# MEMBER_PROFILE

# MEMBER_ID, MEMBER_NAME, TLNO, GENDER, DATE_OF_BIRTH
# 회원 ID, 회원 이름, 회원 연락처, 성별, 생년월일

# 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회하는 SQL문을 작성해주세요.
# 이때 전화번호가 NULL인 경우는 출력대상에서 제외시켜 주시고, 결과는 회원ID를 기준으로 오름차순 정렬해주세요.


