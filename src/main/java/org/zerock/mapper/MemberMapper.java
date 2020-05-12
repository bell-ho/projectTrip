package org.zerock.mapper;

import org.zerock.domain.MemberVo;

public interface MemberMapper {
	public MemberVo read(String userid);
	
	public int insert(MemberVo vo);
}
