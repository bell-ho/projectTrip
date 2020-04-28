package org.zerock.domain;

import lombok.Data;

@Data
public class UploadFileVo {
	private int file_no;
	private Long board_no;
	private String file_name;
}
