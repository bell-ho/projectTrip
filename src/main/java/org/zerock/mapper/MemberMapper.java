package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.MemberVo;

public interface MemberMapper {
	public MemberVo get(String mem_id);
	
	public int insert(MemberVo vo);
	
	public List<MemberVo> getAll();
	
	public int delete(MemberVo vo);
	
	public int update(MemberVo vo);
	
	public int memupdate(MemberVo vo);
	
	public int memimgupdate(MemberVo vo);
}
