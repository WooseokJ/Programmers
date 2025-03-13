-- 코드를 작성해주세요
select id, case 
            when percent_rank() over (order by size_of_colony desc) <= 0.25 then 'CRITICAL'
            when percent_rank() over (order by size_of_colony desc) <= 0.5 then "HIGH"
            when percent_rank() over (order by size_of_colony desc) <= 0.75 then 'MEDIUM'
            else  'LOW'
        end as COLONY_NAME
from ECOLI_DATA


# from ECOLI_DATA
order by ID 


# ECOLI_DATA
#  ID, PARENT_ID, SIZE_OF_COLONY, DIFFERENTIATION_DATE, GENOTYPE
# 대장균 개체의 ID, 부모 개체의 ID, 개체의 크기, 분화되어 나온 날짜, 개체의 형질

