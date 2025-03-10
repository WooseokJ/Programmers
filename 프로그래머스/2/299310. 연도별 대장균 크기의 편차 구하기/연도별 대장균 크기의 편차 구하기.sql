-- 코드를 작성해주세요
select year(DIFFERENTIATION_DATE) as YEAR, (
select max(SIZE_OF_COLONY)
from ECOLI_DATA
where year(DIFFERENTIATION_DATE) = YEAR

) - SIZE_OF_COLONY as YEAR_DEV, ID
from ECOLI_DATA
order by YEAR, YEAR_DEV
;

# ECOLI_DATA
# ID, PARENT_ID, SIZE_OF_COLONY, DIFFERENTIATION_DATE, GENOTYPE
# 개체의 ID, 부모 개체의 ID, 개체의 크기, 분화되어 나온 날짜, 개체의 형질

# 