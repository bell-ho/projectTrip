package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data 
public class BoardVo {
	private Long board_no;
	private int board_kinds;
	private String board_title;
	private Date board_regdate;
	private Date board_updatedate; //오타수정 db에서도 수정
	private int board_hit;
	private String board_content;
	private String mem_id;
	private String mem_nickname;
	private int board_replycnt;
}
