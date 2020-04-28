package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVo {
	private int BOARD_NO;
	private int BOARD_KINDS;
	private String BOARD_TITLE;
	private Date BOARD_DATE;
	private Date BOARD_UPDATEDATA;
	private int BOARD_HIT;
	private String BOARD_CONTENT;
	private int MEM_NO;
}
