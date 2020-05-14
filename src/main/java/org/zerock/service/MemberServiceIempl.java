package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVo;
import org.zerock.mapper.MemberMapper;

import lombok.Setter;
@Service
public class MemberServiceIempl implements MemberService{
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private BCryptPasswordEncoder encoder;
	
	@Override
	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub
		vo.setMem_password(encoder.encode(vo.getMem_password()));
		vo.setRole("ROLE_MEMBER");
		return mapper.insert(vo);
	}

	@Override
	public MemberVo get(String mem_id) {
		// TODO Auto-generated method stub
		return mapper.get(mem_id);
	}

}
