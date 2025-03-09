-- 코드를 작성해주세요
select item_id, item_name
from ITEM_INFO
where item_id in (
    select item_id
    from ITEM_TREE
    where PARENT_ITEM_ID is null
)
order by item_id
;


# ITEM_INFO
# ITEM_ID, ITEM_NAME, RARITY, PRICE
# 아이템 ID, 아이템 명, 아이템의 희귀도, 아이템의 가격

# ITEM_TREE
# ITEM_ID, PARENT_ITEM_ID
# 아이템 ID, PARENT 아이템의 ID