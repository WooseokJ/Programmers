-- 코드를 작성해주세요
select route, concat(round(sum(D_BETWEEN_DIST), 1),'km') as TOTAL_DISTANCE , concat(round(avg(D_BETWEEN_DIST),2),'km') as AVERAGE_DISTANCE
from subway_distance
group by ROUTE 
order by round(sum(D_BETWEEN_DIST), 2) desc
;


# LINE	VARCHAR(10)	FALSE 호선
# NO	NUMBER	FALSE 순번
# ROUTE	VARCHAR(50)	FALSE 노선
# STATION_NAME	VARCHAR(100)	FLASE 역이름
# D_BETWEEN_DIST	NUMBER	FLASE 역사이거리
# D_CUMULATIVE	NUMBER	FLASE 노선별누계거리
# 총누계거리 = D_BETWEEN_DIST의 합.
# 평균역사이거리 = D_BETWEEN_DIST의 평균