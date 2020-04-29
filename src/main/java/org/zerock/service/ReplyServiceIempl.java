package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVo;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Service
@Log4j
public class ReplyServiceIempl implements ReplyService {
	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
	
	@Override
	public int insert(ReplyVo vo) {
		// TODO Auto-generated method stub
		log.info("Reply Insert");
		return mapper.insert(vo);
	}

	@Override
	public ReplyVo get(int reply_no) {
		// TODO Auto-generated method stub
		log.info("Reply Get");
		return mapper.get(reply_no);
	}

	@Override
	public int delete(int reply_no) {
		// TODO Auto-generated method stub
		log.info("Reply Delete");
		return mapper.delete(reply_no);
	}

	@Override
	public int update(ReplyVo vo) {
		// TODO Auto-generated method stub
		log.info("Reply Update");
		return mapper.update(vo);
	}

	@Override
	public List<ReplyVo> getListWithPaging(Criteria cri, Long board_no) {
		// TODO Auto-generated method stub
		log.info("Reply getListWithPaging");
		return mapper.getListWithPaging(cri, board_no);
	}

}
