package org.zerock.service;

import java.util.List;

import org.zerock.domain.MemberVo;

public interface MemberService {
	
	public int insert(MemberVo vo);
	
	public MemberVo get(String mem_id);
	
	public List<MemberVo> getAll();
	
	public int delete(MemberVo vo);
	
	public int update(MemberVo vo);
	
	public int memupdate(MemberVo vo);
	
	public int memimgupdate(MemberVo vo);
}
