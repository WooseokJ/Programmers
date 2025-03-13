-- 코드를 입력하세요
SELECT ugb.WRITER_ID, ugu.nickname, sum(ugb.price) TOTAL_SALES
# select *
from USED_GOODS_BOARD ugb join USED_GOODS_USER ugu
on ugb.WRITER_ID = ugu.USER_ID
where ugb.STATUS = 'DONE'  
group by ugb.writer_id
having sum(ugb.price) >= 700000
order by TOTAL_SALES

# USED_GOODS_BOARD
# BOARD_ID, WRITER_ID, TITLE, CONTENTS, PRICE, CREATED_DATE, STATUS, VIEWS
# 게시글 ID, 작성자 ID, 게시글 제목, 게시글 내용, 가격, 작성일, 거래상태, 조회수
# USED_GOODS_USER
# USER_ID, NICKNAME, CITY, STREET_ADDRESS1, STREET_ADDRESS2, TLNO
# 회원 ID, 닉네임, 시, 도로명 주소, 상세 주소, 전화번호