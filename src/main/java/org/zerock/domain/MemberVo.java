package org.zerock.domain;

import java.util.Date;
import lombok.Data;

@Data
public class MemberVo   {
	private int mem_no;
	private String mem_id;
	private String mem_password;
	private String mem_email;
	private String mem_receive_email;
	private String mem_nickname;
	private String mem_img;
	private Date mem_register_date;
	private String role;

}
