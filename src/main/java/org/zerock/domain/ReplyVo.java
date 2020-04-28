package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVo {
	private int REPLY_NO;
	private int BOARD_NO;
	private int MEM_NO;
	private String REPLY_CONTENT;
	private Date REPLY_DATE;
	private Date REPLY_UPDATEDATE;
}
