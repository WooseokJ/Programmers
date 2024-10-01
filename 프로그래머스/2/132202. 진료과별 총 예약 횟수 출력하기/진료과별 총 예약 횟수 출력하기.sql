-- 코드를 입력하세요
SELECT MCDP_CD as 진료과코드, count(APNT_NO) as 5월예약건수
from APPOINTMENT
where date_format(APNT_YMD, "%Y-%m") = '2022-05'
group by MCDP_CD
order by 5월예약건수, MCDP_CD 



# APNT_YMD, APNT_NO, PT_NO, MCDP_CD, MDDR_ID, APNT_CNCL_YN, APNT_CNCL_YMD
# 진료예약일시, 진료예약번호, 환자번호, 진료과코드, 의사ID, 예약취소여부, 예약취소날짜