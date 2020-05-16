package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVo;
import org.zerock.domain.UploadFileVo;
import org.zerock.mapper.ReplyMapper;
import org.zerock.mapper.UploadFileMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import oracle.net.aso.c;
@Service
@Log4j
public class UploadFileServiceImpl implements UploadFileService {
	@Setter(onMethod_=@Autowired)
	private UploadFileMapper mapper;
	
	@Override
	public List<UploadFileVo> getTripList(Criteria cri) {
		// TODO Auto-generated method stub
	log.info("GetUploadFile ");
		return mapper.getTripList(cri);
	}

	@Override
	public int insert(UploadFileVo uploadVo) {
		// TODO Auto-generated method stub
		log.info("UploadFile ");
		return mapper.insert(uploadVo);
	}

	@Override
	public List<UploadFileVo> getListWithPaging(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("uploadFileList ");
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int totalAll(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.totalAll(cri);
	}

	@Override
	public int totalTrip(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.totalTrip(cri);
	}
	
	@Override
	public int deleteFileAll(long board_no) {
		// TODO Auto-generated method stub
		return mapper.deleteFileAll(board_no);
	}

	@Override
	public List<UploadFileVo> get() {
		// TODO Auto-generated method stub
		return mapper.get();
	}

	@Override
	public int deleteMember(String mem_id) {
		// TODO Auto-generated method stub
		return mapper.deleteMember(mem_id);
	}

	

}
