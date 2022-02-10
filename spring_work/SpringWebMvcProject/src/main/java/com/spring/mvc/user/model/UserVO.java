package com.spring.mvc.user.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 CREATE TABLE mvc_user (
    account VARCHAR2(50) PRIMARY KEY,
    password VARCHAR2(100) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    reg_date DATE DEFAULT sysdate
);

-- 자동 로그인 관련 컬럼 추가 DDL은 커밋 안해도 됨.(자동 커밋) DML은 커밋 필요함.
ALTER TABLE mvc_user
ADD session_id VARCHAR2(80)
DEFAULT 'none' NOT NULL;

ALTER TABLE mvc_user
ADD limit_time DATE;
 */

@Getter
@Setter
@ToString
public class UserVO {

	private String account;
	private String password;
	private String name;
	private Timestamp regDate;
	private String sessionId;
	private Timestamp limitTime;
	
	//자동 로그인 체크 여부
	private boolean autoLogin;
	
}
