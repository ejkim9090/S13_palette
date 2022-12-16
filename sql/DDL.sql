DROP TABLE "PRODUCT_WISH";
DROP TABLE "REVIEW_LIKE";
DROP TABLE "REVIEW_IMAGE";
DROP TABLE "REVIEW";
DROP TABLE "MEMBER";
DROP TABLE "PRODUCT";
DROP TABLE "CATEGORY";

CREATE TABLE "MEMBER" (
	"MID"	VARCHAR2(50)		NOT NULL,
	"MPW"	VARCHAR2(50)		NOT NULL,
	"MNAME"	VARCHAR2(100)		NOT NULL,
	"MEMAIL"	VARCHAR2(100)		NOT NULL,
	"MADDR1"	VARCHAR2(100)		NOT NULL,
	"MADDR2"	VARCHAR2(300)		NOT NULL,
	"MGENDER"	NUMBER(1)		NULL,
	"MBYEAR"	NUMBER(4)		NULL,
	"MBMONTH"	NUMBER(2)		NULL,
	"MBDATE"	NUMBER(2)		NULL,
	"MCONSENT"	NUMBER(1)		NOT NULL,
	"MENTRANCE"	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP   NOT NULL
);
ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"MID"
);
COMMENT ON COLUMN "MEMBER"."MID" IS '6~16자, 영문 혹은 영문과 숫자';
COMMENT ON COLUMN "MEMBER"."MPW" IS '6~16자, 영문/숫자/특수문자 중 2개 이상';
COMMENT ON COLUMN "MEMBER"."MGENDER" IS '남:0, 여:1';
COMMENT ON COLUMN "MEMBER"."MCONSENT" IS 'x:0, 1:1, 2:2, 1+2:3,  3:4, 1+3:5, 2+3:6, 1+2+3:7';
COMMENT ON COLUMN "MEMBER"."MENTRANCE" IS 'SYSDATE';

CREATE TABLE "CATEGORY" (
	"CID"	NUMBER(2)		NOT NULL,
	"CNAME"	VARCHAR2(100)		NOT NULL,
	"CDEPTH"	NUMBER(1)		NOT NULL,
	"CPID"	NUMBER(2)		NULL
);
ALTER TABLE "CATEGORY" ADD CONSTRAINT "PK_CATEGORY" PRIMARY KEY (
	"CID"
);
COMMENT ON COLUMN "CATEGORY"."CID" IS '10,11,12,...68';
COMMENT ON COLUMN "CATEGORY"."CDEPTH" IS '부모:0, 자식:1';
COMMENT ON COLUMN "CATEGORY"."CPID" IS '10,20,...,60';

CREATE TABLE "PRODUCT" (
	"PID"	VARCHAR2(100)		NOT NULL,
	"CID"	NUMBER(2)		NOT NULL,
	"PNAME"	VARCHAR2(500)		NOT NULL,
	"PIMG1"	VARCHAR2(500)		NOT NULL,
	"PIMG2"	VARCHAR2(500)		NOT NULL,
	"PPRICE"	NUMBER		NOT NULL,
	"PBENEFIT"	VARCHAR2(200)		NULL,
	"PDELIVERY"	VARCHAR2(200)		NULL,
    "PDETAIL"	CLOB		NULL
);
ALTER TABLE "PRODUCT" ADD CONSTRAINT "PK_PRODUCT" PRIMARY KEY (
	"PID"
);

CREATE TABLE "REVIEW" (
	"RNO"	NUMBER		NOT NULL,
	"PID"	VARCHAR2(100)		NOT NULL,
	"MID"	VARCHAR2(50)		NOT NULL,
	"RCONTENT"	VARCHAR2(2000CHAR)		NOT NULL,
	"RDATE"	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP	NULL
);
ALTER TABLE "REVIEW" ADD CONSTRAINT "PK_REVIEW" PRIMARY KEY (
	"RNO"
);
COMMENT ON COLUMN "REVIEW"."MID" IS '6~16자, 영문 혹은 영문과 숫자';

CREATE TABLE "REVIEW_IMAGE" (
	"RFILEPATH"	VARCHAR2(500)		NOT NULL,
	"RNO"	NUMBER		NOT NULL
);
ALTER TABLE "REVIEW_IMAGE" ADD CONSTRAINT "PK_REVIEW_IMAGE" PRIMARY KEY (
	"RFILEPATH"
);
COMMENT ON COLUMN "REVIEW_IMAGE"."RFILEPATH" IS '/resources/review/123/a.jpg';

CREATE TABLE "PRODUCT_WISH" (
	"MID"	VARCHAR2(50)		NOT NULL,
	"PID"	VARCHAR2(100)		NOT NULL
);
ALTER TABLE "PRODUCT_WISH" ADD CONSTRAINT "PK_PRODUCT_WISH" PRIMARY KEY (
	"MID",
	"PID"
);
COMMENT ON COLUMN "PRODUCT_WISH"."MID" IS '6~16자, 영문 혹은 영문과 숫자';

CREATE TABLE "REVIEW_LIKE" (
	"RNO"	NUMBER		NOT NULL,
	"MID"	VARCHAR2(50)		NOT NULL
);
ALTER TABLE "REVIEW_LIKE" ADD CONSTRAINT "PK_REVIEW_LIKE" PRIMARY KEY (
	"RNO",
	"MID"
);
COMMENT ON COLUMN "REVIEW_LIKE"."MID" IS '좋아요 한 회원';



-- 외래키 설정
ALTER TABLE "REVIEW" ADD CONSTRAINT "FK_PRODUCT_TO_REVIEW_1" FOREIGN KEY (
	"PID"
)
REFERENCES "PRODUCT" (
	"PID"
);

ALTER TABLE "REVIEW" ADD CONSTRAINT "FK_MEMBER_TO_REVIEW_1" FOREIGN KEY (
	"MID"
)
REFERENCES "MEMBER" (
	"MID"
);

ALTER TABLE "PRODUCT" ADD CONSTRAINT "FK_CATEGORY_TO_PRODUCT_1" FOREIGN KEY (
	"CID"
)
REFERENCES "CATEGORY" (
	"CID"
);

ALTER TABLE "REVIEW_IMAGE" ADD CONSTRAINT "FK_REVIEW_TO_REVIEW_IMAGE_1" FOREIGN KEY (
	"RNO"
)
REFERENCES "REVIEW" (
	"RNO"
);

ALTER TABLE "PRODUCT_WISH" ADD CONSTRAINT "FK_MEMBER_TO_PRODUCT_WISH_1" FOREIGN KEY (
	"MID"
)
REFERENCES "MEMBER" (
	"MID"
);

ALTER TABLE "PRODUCT_WISH" ADD CONSTRAINT "FK_PRODUCT_TO_PRODUCT_WISH_1" FOREIGN KEY (
	"PID"
)
REFERENCES "PRODUCT" (
	"PID"
);

ALTER TABLE "REVIEW_LIKE" ADD CONSTRAINT "FK_REVIEW_TO_REVIEW_LIKE_1" FOREIGN KEY (
	"RNO"
)
REFERENCES "REVIEW" (
	"RNO"
);

ALTER TABLE "REVIEW_LIKE" ADD CONSTRAINT "FK_MEMBER_TO_REVIEW_LIKE_1" FOREIGN KEY (
	"MID"
)
REFERENCES "MEMBER" (
	"MID"
);



