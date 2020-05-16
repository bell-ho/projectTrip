package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVo;
import org.zerock.domain.ReplyVo;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;
import org.zerock.mapper.UploadFileMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replyMapper;
	@Setter(onMethod_ = @Autowired)
	private UploadFileMapper uploadMapper;

	@Override
	public void register(BoardVo board) {
		// TODO Auto-generated method stub
		log.info("등록..." + board);
		mapper.insertSelectkey(board);
	}

	// 자유
	@Override
	public BoardVo get(Long BOARD_NO) {
		// TODO Auto-generated method stub
		log.info("get....." + BOARD_NO);
		return mapper.read(BOARD_NO);
	}

	@Override
	public boolean modify(BoardVo board) {
		// TODO Auto-generated method stub
		log.info("modify...." + board);
		return mapper.update(board) == 1;
	}

	@Transactional
	@Override
	public boolean remove(Long board_no) {
		// TODO Auto-generated method stub
		log.info("remove...." + board_no);

		uploadMapper.deleteFileAll(board_no);
		replyMapper.deleteReplyAll(board_no);
		return mapper.delete(board_no) == 1;
	}

	@Override
	public List<BoardVo> getFreeList() {
		// TODO Auto-generated method stub
		log.info("getList.......");
		return mapper.getFreeList();
	}

	@Override
	public List<BoardVo> getTripList() {
		// TODO Auto-generated method stub
		log.info("getList.......");

		return mapper.getTripList();
	}

	@Override
	public List<BoardVo> getMyList(String mem_nickname) {
		// TODO Auto-generated method stub
		return mapper.getMyList(mem_nickname);
	}

}
