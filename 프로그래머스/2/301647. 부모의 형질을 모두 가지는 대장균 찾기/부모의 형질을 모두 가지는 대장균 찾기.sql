-- 코드를 작성해주세요

select a.id, a.genotype, b.genotype as PARENT_GENOTYPE
from ecoli_data a join ecoli_data b
on b.id = a.parent_id
where (a.genotype & b.genotype) = b.genotype
order by a.id

;
# ECOLI_DATA
# ID, PARENT_ID, SIZE_OF_COLONY, DIFFERENTIATION_DATE, GENOTYPE
# 대장균 개체의 ID, 부모 개체의 ID, 개체의 크기, 분화되어 나온 날짜, 개체의 형질

#     1
#    2 3
#   4 7 6 
# 