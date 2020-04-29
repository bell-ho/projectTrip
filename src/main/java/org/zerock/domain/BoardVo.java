package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVo {
	private Long board_no;
	private int board_kinds;
	private String board_title;
	private Date board_regdate;
	private Date board_updatedata;
	private int board_hit;
	private String board_content;
	private int mem_no;
	private String mem_id;
}
