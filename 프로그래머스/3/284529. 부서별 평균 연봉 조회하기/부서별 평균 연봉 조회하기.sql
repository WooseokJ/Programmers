-- 코드를 작성해주세요

select hd.dept_id, hd.dept_name_en, Round(AVG(sal), 0) as AVG_SAL
from HR_DEPARTMENT as hd join HR_EMPLOYEES as he
on hd.dept_id = he.dept_id
group by DEPT_ID
order by AVG_SAL desc
;