package org.zerock.mapper;

import org.zerock.domain.MemberVo;

public interface MemberMapper {
	public MemberVo read(String mem_id);
	
	public int insert(MemberVo vo);
}
