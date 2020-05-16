package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.MemberVo;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.MemberMapper;
import org.zerock.mapper.ReplyMapper;
import org.zerock.mapper.UploadFileMapper;

import lombok.Setter;
@Service
public class MemberServiceIempl implements MemberService{
	
	@Setter(onMethod_=@Autowired)
	private MemberMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private BCryptPasswordEncoder encoder;
	
	@Setter(onMethod_=@Autowired)
	private ReplyService replyService;
	
	@Setter(onMethod_=@Autowired)
	private UploadFileService uploadService;
	
	@Setter(onMethod_=@Autowired)
	private BoardService boardService;
	
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

	@Override
	public List<MemberVo> getAll() {
		// TODO Auto-generated method stub
		return mapper.getAll();
	}
	
	@Transactional
	@Override
	public int delete(MemberVo vo) {
		// TODO Auto-generated method stub
		if(encoder.matches(vo.getMem_password(), mapper.get(vo.getMem_id()).getMem_password())) {
			replyService.deleteMember(vo.getMem_id());
			uploadService.deleteMember(vo.getMem_id());
			boardService.deleteMember(vo.getMem_id());
			return mapper.delete(vo);
		}else {
			return 0;
		}
		
	}
	@Override
	public int update(MemberVo vo) {
		if(encoder.matches(vo.getMem_password(), mapper.get(vo.getMem_id()).getMem_password())) {
			vo.setNew_mem_password(encoder.encode(vo.getNew_mem_password()));
			return mapper.update(vo);
		}
		return 0;
		
	}

}
