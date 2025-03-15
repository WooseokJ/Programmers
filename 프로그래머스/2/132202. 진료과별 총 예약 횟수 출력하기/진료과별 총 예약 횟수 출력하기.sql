
SELECT mcdp_cd 진료과코드, count(*) 5월예약건수
from APPOINTMENT
where date_format(APNT_YMD, "%y-%m" ) = "22-05"
group by MCDP_CD
order by count(PT_NO), 진료과코드

# APPOINTMENT
# APNT_YMD, APNT_NO, PT_NO, MCDP_CD, MDDR_ID, APNT_CNCL_YN, APNT_CNCL_YMD
# 진료예약일시, 진료예약번호, 환자번호, 진료과코드, 의사ID, 예약취소여부, 예약취소날짜

