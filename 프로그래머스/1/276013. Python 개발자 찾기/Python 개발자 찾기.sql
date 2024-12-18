-- 코드를 작성해주세요
select id, email, first_name, last_name 
from DEVELOPER_INFOS
where skill_1 = 'Python' or 
        skill_2 = 'Python' or
        skill_3 = 'Python'

order by id

# DEVELOPER_INFOS
# ID, FIRST_NAME, LAST_NAME, EMAIL, SKILL_1, SKILL_2, SKILL_3
#  ID, 이름, 성, 이메일, 첫 번째 스킬, 두 번째 스킬, 세 번째 스킬


# DEVELOPER_INFOS 테이블에서 Python 스킬을 가진 개발자의 정보를 조회하려 합니다. Python 스킬을 가진 개발자의 ID, 이메일, 이름, 성을 조회하는 SQL 문을 작성해 주세요. 
# 결과는 id 오름차순

