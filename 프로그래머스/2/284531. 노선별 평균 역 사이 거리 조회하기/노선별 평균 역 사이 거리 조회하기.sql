-- 코드를 작성해주세요
select ROUTE, concat(round(sum(D_BETWEEN_DIST),1),"km") TOTAL_DISTANCE, 
                concat(round(avg(D_BETWEEN_DIST),2),"km") as AVERAGE_DISTANCE
from SUBWAY_DISTANCE
group by ROUTE
order by round(sum(D_BETWEEN_DIST),1) desc


# SUBWAY_DISTANCE
# LINE, NO, ROUTE, STATION_NAME, D_BETWEEN_DIST, D_CUMULATIVE
#  호선, 순번, 노선, 역 이름, 역 사이 거리, 노선별 누계 거리