INSERT INTO MEMBER (MID, MPW, MNAME, MEMAIL, MADDR1, MADDR2, MCONSENT)
    VALUES ('ADMIN', 'ADMIN', '관리자', 'a@a.com', '서울시', '아파트', 7);

INSERT INTO CATEGORY VALUES (10, '노트/다이어리', 0, NULL);
INSERT INTO CATEGORY VALUES (20, '문구', 0, NULL);
INSERT INTO CATEGORY VALUES (30, '취미', 0, NULL);
INSERT INTO CATEGORY VALUES (40, '키친/홈데코', 0, NULL);
INSERT INTO CATEGORY VALUES (50, '패브릭/생활', 0, NULL);

INSERT INTO CATEGORY VALUES (11, '노트', 1, 10);
INSERT INTO CATEGORY VALUES (12, '단어장/수첩', 1, 10);
INSERT INTO CATEGORY VALUES (13, '메모지', 1, 10);
INSERT INTO CATEGORY VALUES (14, '다이어리', 1, 10);
INSERT INTO CATEGORY VALUES (15, '스케줄러/플래너', 1, 10);

INSERT INTO CATEGORY VALUES (21, '필기구', 1, 20);
INSERT INTO CATEGORY VALUES (22, '필통', 1, 20);
INSERT INTO CATEGORY VALUES (23, '스티커', 1, 20);
INSERT INTO CATEGORY VALUES (24, '마스킹테이프', 1, 20);
INSERT INTO CATEGORY VALUES (25, '파일', 1, 20);
INSERT INTO CATEGORY VALUES (26, '사무용품', 1, 20);
INSERT INTO CATEGORY VALUES (27, '데스크소품', 1, 20);
INSERT INTO CATEGORY VALUES (28, '카드/편지지', 1, 20);

INSERT INTO CATEGORY VALUES (31, 'FUN/TOY', 1, 30);
INSERT INTO CATEGORY VALUES (32, 'DIY 취미', 1, 30);
INSERT INTO CATEGORY VALUES (33, 'PARTY', 1, 30);
INSERT INTO CATEGORY VALUES (34, '피규어', 1, 30);

INSERT INTO CATEGORY VALUES (41, '키친용품', 1, 40);
INSERT INTO CATEGORY VALUES (42, '텀블러', 1, 40);
INSERT INTO CATEGORY VALUES (43, '머그/컵', 1, 40);
INSERT INTO CATEGORY VALUES (44, '시계', 1, 40);
INSERT INTO CATEGORY VALUES (45, '조명', 1, 40);
INSERT INTO CATEGORY VALUES (46, '디퓨저/방향제', 1, 40);
INSERT INTO CATEGORY VALUES (47, '인테리어소품', 1, 40);

INSERT INTO CATEGORY VALUES (51, '담요/방석', 1, 50);
INSERT INTO CATEGORY VALUES (52, '욕실용품', 1, 50);
INSERT INTO CATEGORY VALUES (53, '청소/정리용품', 1, 50);
INSERT INTO CATEGORY VALUES (54, '칫솔 케이스/살균기', 1, 50);

COMMIT;
----------------------------------------------------------------------------------------------------------------
-- 테스트용
DESC MEMBER;
DESC CATEGORY;
DESC PRODUCT;
DESC PRODUCT_WISH;
DESC REVIEW;
DESC REVIEW_IMAGE;
DESC REVIEW_LIKE;

SELECT * FROM PRODUCT;
select * from product where cid='54';
delete from product where pprice=0;
delete from product;
SELECT * FROM MEMBER;
SELECT * FROM CATEGORY order by cid asc;

INSERT INTO MEMBER VALUES ('cksun', 'cksun', '최경선', 'b@b.com', '서울시', '아파트', 0, 1997, 03, 28, 7, SYSDATE);

INSERT INTO PRODUCT VALUES ('A12345678901', 11, '&', '&', '&', 1000, '하나(외환)카드 결제 시 최대 8개월 무이자', '2,500원 (30,000원 이상 무료배송)', '&');

INSERT INTO REVIEW VALUES ((SELECT NVL(MAX(RNO),0)+1 FROM REVIEW), 'A12345678901', 'CKSUN', 'CONTENT', SYSDATE);

--------------------------------------------------------------------------------

-- <마이페이지>

-- 찜한 상품 목록
SELECT P.PIMG1, P.PNAME, P.PPRICE -- 상품이미지, 상품명, 상품가격
    FROM PRODUCT_WISH W JOIN PRODUCT P ON W.PID = P.PID
    WHERE W.MID = '회원아이디'
;
-- 찜한 상품 삭제
DELETE 
    FROM PRODUCT_WISH
    WHERE MID = '회원아이디' AND PID = '상품아이디'
;

-- 후기 목록
SELECT P.PIMG1, P.PNAME, R.RCONTENT, R.RDATE -- 상품이미지, 상품명, 후기내용, 글등록시간
    FROM REVIEW R JOIN PRODUCT P ON R.PID = P.PID
    WHERE R.MID = '회원아이디'
    ORDER BY R.RNO DESC  -- 최근이 먼저
; 
-- 후기 목록 - 사진
SELECT RFILEPATH
    FROM REVIEW_IMAGE
    WHERE RNO = 후기번호
;
-- 후기 삭제
DELETE 
    FROM REVIEW
    WHERE RNO = 후기번호
;    

-- <카테고리페이지>

-- 카테고리 대분류 전체보기
SELECT P.PIMG1, P.PNAME, P.PPRICE -- 상품이미지, 상품명, 가격
    FROM PRODUCT P JOIN CATEGORY C ON P.CID = C.CID
    WHERE P.CPID = 부모카테고리아이디
; 
    
-- 카테고리 소분류
SELECT PIMG1, PNAME, PPRICE -- 상품이미지, 상품명, 가격
    FROM PRODUCT
    WHERE CID = 카테고리아이디
; 

-- 필터 (배송)
SELECT PIMG1, PNAME, PPRICE
    FROM PRODUCT
    WHERE PDELIVERY = '무료배송'
;
SELECT PIMG1, PNAME, PPRICE
    FROM PRODUCT
    WHERE PDELIVERY NOT = '무료배송'
;
-- 필터 (가격)
SELECT PIMG1, PNAME, PPRICE
    FROM PRODUCT
    WHERE PPRICE <= 10000
;
SELECT PIMG1, PNAME, PPRICE
    FROM PRODUCT
    WHERE PPRICE BETWEEN 10000 AND 30000
;
SELECT PIMG1, PNAME, PPRICE
    FROM PRODUCT
    WHERE PPRICE BETWEEN 30000 AND 50000
;
SELECT PIMG1, PNAME, PPRICE
    FROM PRODUCT
    WHERE PPRICE >= 50000
;

-- 낮은가격순 / 높은가격순 정렬
SELECT PIMG1, PNAME, PPRICE
    FROM PRODUCT
    ORDER BY PPRICE ASC -- WHERE CID = 카테고리아이디  같은 옵션 있을수있음
;
SELECT PIMG1, PNAME, PPRICE
    FROM PRODUCT
    ORDER BY PPRICE DESC
;

-- <상품상세페이지>

-- 후기 작성


-- 후기 목록
SELECT M.MNAME, P.PNAME, R.RCONTENT, R.RDATE -- 회원이름, 상품명, 후기내용, 글등록시간
    FROM REVIEW R JOIN PRODUCT P ON R.PID = P.PID
                  JOIN MEMBER M ON R.MID = M.MID
    WHERE R.PID = '상품아이디'
    ORDER BY R.RNO DESC  -- 최근이 먼저
; 
-- 후기 목록 - 사진
SELECT RFILEPATH
    FROM REVIEW_IMAGE
    WHERE RNO = 후기번호
;
-- 후기 삭제
DELETE 
    FROM REVIEW
    WHERE RNO = 후기번호
;
-- 사진 더보기
SELECT RFILEPATH
    FROM REVIEW_IMAGE
    WHERE PID = '상품아이디'
;








