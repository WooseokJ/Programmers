-- 코드를 작성해주세요

select id, case 
            when SIZE_OF_COLONY <= 100 then "LOW"
            when SIZE_OF_COLONY <= 1000 then "MEDIUM"
            else "HIGH"
        end SIZE
from ECOLI_DATA

# ECOLI_DATA
 # ID, PARENT_ID, SIZE_OF_COLONY, DIFFERENTIATION_DATE, GENOTYPE
 # 대장균 개체의 ID, 부모 개체의 ID, 개체의 크기, 분화되어 나온 날짜, 개체의 형질
 