# -- 코드를 입력하세요
# SELECT product_id as PRODUCT_ID, product_name as PRODUCT_NAME , product_cd as PRODUCT_CD, category as CATEGORY, max(price) as PRICE from FOOD_PRODUCT ;

select * from FOOD_PRODUCT where price = (
    select max(price) from food_product
)
# P0051	맛있는배추김치	CD_KC00001	김치	19000