DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS ( 
	userId          varchar(12)		NOT NULL, 
	password		varchar(12)		NOT NULL,
	name			varchar(20)		NOT NULL,
	email			varchar(50),
  	
	PRIMARY KEY               (userId)
);

INSERT INTO USERS VALUES('admin', 'password', '자바지기', 'admin@slipp.net');

DROP TABLE IF EXISTS QUESTIONS;

CREATE TABLE QUESTIONS(
	questionId		bigint			auto_increment,
	writer			varchar(30)		NOT NULL,
	title			varchar(50)		NOT NULL,
	contents		varchar(5000)	NOT NULL,
	createdDate		timestamp		NOT NULL,
	countOfAnswer	int,
	PRIMARY KEY		(questionId)
);

INSERT INTO QUESTIONS VALUES(1, '임풀', '코딩이 가득한 코딩노트', 'sql과 jstl을 이용해 게시글을 등록해보자', systimestamp, 1);

DROP TABLE IF EXISTS ANSWERS;

CREATE TABLE ANSWERS (
	answerId		bigint			auto_increment,
	writer			varchar(30)		NOT NULL,
	contents		varchar(5000)	NOT NULL,
	createdDate		timestamp		NOT NULL,
	questionId		bigint			NOT NULL,
	PRIMARY KEY		(answerId)
);

INSERT INTO ANSWERS VALUES(1, '임가득', '정말 유용한 정보로군요!', systimestamp, 1);