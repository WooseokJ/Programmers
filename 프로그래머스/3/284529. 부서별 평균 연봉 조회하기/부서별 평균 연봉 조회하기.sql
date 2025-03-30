-- 코드를 작성해주세요
select hd.dept_id, hd.dept_name_en, round(avg(SAL),0) as AVG_SAL
from hr_department hd join HR_EMPLOYEES he
on hd.DEPT_ID = he.DEPT_ID
group by hd.DEPT_ID
order by avg_sal desc


# HR_DEPARTMENT
# DEPT_ID, DEPT_NAME_KR, DEPT_NAME_EN, LOCATION
# 부서 ID, 국문 부서명, 영문 부서명, 부서 위치

# HR_EMPLOYEES
# EMP_NO, EMP_NAME, DEPT_ID, POSITION, EMAIL, COMP_TEL, HIRE_DATE, SAL
# 사번, 성명, 부서 ID, 직책, 이메일, 전화번호, 입사일, 연봉

