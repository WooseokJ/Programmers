-- 코드를 작성해주세요
select sum(score) as SCORE, hg.emp_no as EMP_NO, he.EMP_NAME as EMP_name, he.position as POSITION, he.email as EMAIL
from HR_EMPLOYEES as he left join HR_GRADE as hg
on he.emp_no = hg.emp_no
group by hg.EMP_NO, hg.emp_no, he.emp_name, he.position, he.email
order by score desc
limit 1
;