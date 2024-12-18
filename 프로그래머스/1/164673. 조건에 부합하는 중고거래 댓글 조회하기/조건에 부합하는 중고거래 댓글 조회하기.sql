-- 코드를 입력하세요
SELECT A.title, A.board_id, 
B.reply_id, B.writer_id, B.contents, date_format(B.CREATED_DATE, '%Y-%m-%d') as created_date
from USED_GOODS_BOARD as A join USED_GOODS_REPLY as B
on A.board_id = B.board_id
where Year(A.created_date) = 2022 and month(A.created_date) = 10

order by B.CREATED_DATE, A.TITLE
;


# USED_GOODS_BOARD 중고거래 게시판 정보 
# BOARD_ID, WRITER_ID, TITLE, CONTENTS, PRICE, CREATED_DATE, STATUS, VIEWS
# 게시글 ID, 작성자 ID, 게시글 제목, 게시글 내용, 가격, 작성일, 거래상태, 조회수

#USED_GOODS_REPLY
# REPLY_ID, BOARD_ID, WRITER_ID, CONTENTS, CREATED_DATE
# 댓글 ID, 게시글 ID, 작성자 ID, 댓글 내용, 작성일

# 2022년 10월에 작성된 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문을 작성해주세요. 
# 결과는 댓글 작성일을 기준으로 오름차순 정렬해주시고, 댓글 작성일이 같다면 게시글 제목을 기준으로 오름차순 정렬해주세요.