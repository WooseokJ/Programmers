-- 코드를 작성해주세요
# select hg.score, hg.EMP_NO,  he.emp_name,he.position, he.email
select sum(hg.score) as score, HE.EMP_NO, HE.EMP_NAME, HE.POSITION, HE.EMAIL
from hr_grade hg join HR_EMPLOYEES he
on hg.emp_no = he.emp_no
where hg.year = '2022'
group by hg.EMP_NO
order by score desc
limit 1

# having max(hg.score) = hg.score

# HR_DEPARTMENT
# DEPT_ID, DEPT_NAME_KR, DEPT_NAME_EN, LOCATION
# 부서 ID, 국문 부서명, 영문 부서명, 부서 위치

# HR_EMPLOYEES
# EMP_NO, EMP_NAME, DEPT_ID, POSITION, EMAIL, COMP_TEL, HIRE_DATE, SAL
# 사번, 성명, 부서 ID, 직책, 이메일, 전화번호, 입사일, 연봉

# HR_GRADE
# EMP_NO, YEAR, HALF_YEAR, SCORE
# 사번, 연도, 반기, 평가 점수