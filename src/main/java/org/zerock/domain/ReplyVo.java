package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVo {
	private int reply_no;
	private Long board_no;
	private String reply_content;
	private Date reply_date;
	private Date reply_updatedate;
	private String mem_id;
	private String mem_nickname;
	private String mem_img;
}
