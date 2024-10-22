-- 코드를 입력하세요
SELECT MEMBER_ID, member_name as MEMBER_NAME, gender, date_format(date_of_birth, '%Y-%m-%d') as date_of_birth

from member_profile
where date_format(date_of_birth, '%m') = '03' && tlno is not null && gender = 'W'
order by member_id
;
