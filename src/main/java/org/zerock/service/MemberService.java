package org.zerock.service;

import org.zerock.domain.MemberVo;

public interface MemberService {
	
	public int insert(MemberVo vo);
	
	public MemberVo get(String mem_id);
}
