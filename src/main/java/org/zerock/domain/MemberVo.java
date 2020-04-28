package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVo {
	private int MEM_NO;
	private String MEM_ID;
	private String MEM_PASSWORD;
	private String MEM_EMAIL;
	private String MEM_RECEIVE_EMAIL;
	private String MEM_NICKNAME;
	private String MEM_IMG;
	private Date MEM_REGISTER_DATE;
}
