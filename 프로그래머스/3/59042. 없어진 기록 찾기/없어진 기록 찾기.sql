# from -> join-> where -> groupby-> having -> select -> order
SELECT ao.animal_id, ao.name
from ANIMAL_OUTS as ao left join ANIMAL_INS as ai 
on ao.animal_id = ai.animal_id
where ai.animal_id is null;