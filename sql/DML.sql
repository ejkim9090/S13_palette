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
select * from product where cid='35';
select * from product where cid='11' order by pname asc;
delete from product where pprice=0;
delete from product;
SELECT * FROM MEMBER;
SELECT * FROM CATEGORY order by cid asc;
DELETE from CATEGORY where cid='35';
update product
    set pimg1 = substr(pimg1, 2), pimg2 = substr(pimg2, 2);
select * from member;
delete from member where mid='user2';


INSERT INTO MEMBER VALUES ('cksun', 'cksun', '최경선', 'b@b.com', '서울시', '아파트', '여', 1997, 03, 28, 7, SYSDATE);
INSERT INTO MEMBER VALUES ('user1', 'user1', '유저1', 'a@a.com', '서울시', '아파트', 'F', 1997, 03, 28, 7, SYSDATE);

INSERT INTO PRODUCT VALUES ('A12345678901', 11, '&', '&', '&', 1000, '하나(외환)카드 결제 시 최대 8개월 무이자', '2,500원 (30,000원 이상 무료배송)', '&');

INSERT INTO REVIEW VALUES ((SELECT NVL(MAX(RNO),0)+1 FROM REVIEW), 'A12345678901', 'CKSUN', 'CONTENT', SYSDATE);

desc review;
select * from review;
select * from review where pid='G22070456541';
select * from REVIEW_IMAGE;
delete from review;
delete from review_image where rno=4;
insert into review (rno, pid, mid, rcontent) 
    values ((SELECT NVL(MAX(RNO),0)+1 FROM REVIEW), 'G22100512870', 'user1', 'ㅁㄴ아ㅣ롬ㄴㅇ;ㅣㅏ런얾니아ㅗㄻ;니아ㅗㄹ
    ㅁㄴ아ㅓ로미나ㅓㅇ롬니ㅏㅇ러ㅗㅁㄴ
    ㅁㄴ;ㅏ어롬ㄴ애ㅣㅏ럼닝');
insert into REVIEW_IMAGE values (14, '/images/s5.png');
insert into REVIEW_IMAGE values (3, '/images/s12.png');


select * from PRODUCT_WISH;
--------------------------------------------------------------------------------

-- <마이페이지>

-- 찜한 상품 목록
SELECT P.PID, P.PIMG1, P.PNAME, TO_CHAR(P.PPRICE, '999,999,999') PPRICE  -- 상품아이디, 상품이미지, 상품명, 상품가격
    FROM PRODUCT_WISH W JOIN PRODUCT P ON W.PID = P.PID
    WHERE W.MID = '회원아이디'
;
-- 찜한 상품 삭제
DELETE 
    FROM PRODUCT_WISH
    WHERE MID = '회원아이디' AND PID = '상품아이디'
;

-- 후기 목록
SELECT R.RNO, P.PID, P.PIMG1, P.PNAME, R.RCONTENT, I.RFILEPATH, TO_CHAR(R.RDATE, 'YYYY.MM.DD') RDATE -- 후기번호, 상품아이디, 상품이미지, 상품명, 후기내용, 후기사진, 글등록시간
    FROM REVIEW R JOIN PRODUCT P ON R.PID = P.PID
                  JOIN REVIEW_IMAGE I ON R.RNO = I.RNO
    WHERE R.MID = '회원아이디'
    ORDER BY R.RNO DESC  -- 최근이 먼저
;

-- 후기 삭제
DELETE 
    FROM REVIEW
    WHERE RNO = 후기번호
;    

-- <카테고리페이지>

-- 대분류 불러오기
select * from category where cid = (select cpid from category where cid = ?)
;
-- 소분류 리스트
select cid, cname -- 카테고리아이디, 카테고리이름
    from category 
    where cpid=부모카테고리아이디
;

-- 기본
SELECT C.CNAME, P.PIMG1, P.PNAME, TO_CHAR(P.PPRICE, '999,999,999') PPRICE -- 카테고리이름, 상품이미지, 상품명, 가격
    FROM PRODUCT P JOIN CATEGORY C ON P.CID = C.CID
    WHERE P.CID = 카테고리아이디
    ORDER BY P.PNAME ASC
; 

-- 필터 (배송)
SELECT C.CNAME, P.PIMG1, P.PNAME, TO_CHAR(P.PPRICE, '999,999,999') PPRICE
    FROM PRODUCT P JOIN CATEGORY C ON P.CID = C.CID
    WHERE P.CID = 카테고리아이디 AND P.PDELIVERY = '무료배송'
    ORDER BY P.PNAME ASC
; 

-- 필터 (가격)
SELECT C.CNAME, P.PIMG1, P.PNAME, TO_CHAR(P.PPRICE, '999,999,999') PPRICE
    FROM PRODUCT P JOIN CATEGORY C ON P.CID = C.CID
    WHERE P.CID = 카테고리아이디 AND P.PPRICE BETWEEN ? AND ? 
    ORDER BY P.PNAME ASC
; 

-- 필터 (배송 + 가격)
SELECT C.CNAME, P.PIMG1, P.PNAME, TO_CHAR(P.PPRICE, '999,999,999') PPRICE
    FROM PRODUCT P JOIN CATEGORY C ON P.CID = C.CID
    WHERE P.CID = 카테고리아이디 AND P.PDELIVERY = '무료배송' AND P.PPRICE BETWEEN ? AND ? 
    ORDER BY P.PNAME ASC
; 


-- 낮은가격순 / 높은가격순 정렬
SELECT PIMG1, PNAME, PPRICE
    FROM PRODUCT
    ORDER BY PPRICE ASC 
;
SELECT PIMG1, PNAME, PPRICE
    FROM PRODUCT
    ORDER BY PPRICE DESC
;

-- <상품상세페이지>

-- 상품 상세
SELECT PID, CID, PNAME, PIMG1, PIMG2, TO_CHAR(PPRICE, '999,999,999') PPRICE, PBENEFIT, PDELIVERY, PDETAIL
    FROM PRODUCT
    WHERE PID = '상품아이디'
;

-- 후기 작성


-- 후기 목록
SELECT R.RNO, M.MNAME, P.PNAME, R.RCONTENT, TO_CHAR(R.RDATE, 'YYYY.MM.DD') RDATE -- 후기번호, 회원이름, 상품명, 후기내용, 글등록시간
    FROM REVIEW R JOIN PRODUCT P ON R.PID = P.PID
                  JOIN MEMBER M ON R.MID = M.MID
    WHERE R.PID = '상품아이디'
    ORDER BY R.RNO DESC  -- 최근이 먼저
; 
-- 후기 사진 더보기
SELECT * 
    FROM REVIEW_IMAGE I JOIN REVIEW R ON I.RNO = R.RNO
    WHERE R.PID = '상품아이디'
    ORDER BY R.RDATE DESC
;
-- 후기 삭제
DELETE 
    FROM REVIEW
    WHERE RNO = 후기번호
;

-- 후기 + 사진 insert
INSERT ALL 
    INTO REVIEW (RNO, PID, MID, RCONTENT) VALUES (MAXRNO,'G22070456541','user1','aaaa') 
    INTO REVIEW_IMAGE VALUES (MAXRNO, '/resources/review/d0f23447-5267-4133-b1df-f4c94dfb4d27.png') 
    INTO REVIEW_IMAGE VALUES (MAXRNO, '/resources/review/98bd010b-e131-44a3-9016-976d69ff3f90.png') 
SELECT NVL(MAX(RNO), 0)+1 AS MAXRNO FROM REVIEW
;

