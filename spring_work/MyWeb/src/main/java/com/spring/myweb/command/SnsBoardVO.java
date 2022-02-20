package com.spring.myweb.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 -- SNS 게시판
CREATE TABLE snsboard(
    bno NUMBER(10,0) PRIMARY KEY,
    writer VARCHAR2(50) NOT NULL,
    uploadpath VARCHAR2(100) NOT NULL,
    fileloca VARCHAR2(100) NOT NULL,
    filename VARCHAR2(50) NOT NULL,
    filerealname VARCHAR2(50) NOT NULL,
    content VARCHAR2(2000),
    regdate DATE DEFAULT sysdate
);

CREATE SEQUENCE snsboard_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 1000
    NOCYCLE
    NOCACHE;
 */

@Getter
@Setter
@NoArgsConstructor //기본 생성자(매개값을 하나도 받지 않음)
@AllArgsConstructor //모든 값을 매개값으로 받는 생성자
@ToString
public class SnsBoardVO {

	private int bno;
	private String writer;
	private String uploadpath;
	private String fileloca;
	private String filename;
	private String filerealname;
	private String content;
	private Timestamp regdate;
	
}













