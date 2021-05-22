package org.zerock.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVo;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;
import org.zerock.mapper.UploadFileMapper;

import java.util.List;

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
        log.info("µî·Ï..." + board);
        mapper.insertSelectkey(board);
    }

    @Transactional
    @Override
    public BoardVo get(Long BOARD_NO) {
        log.info("get....." + BOARD_NO);
        return mapper.read(BOARD_NO);
    }

    @Override
    public boolean modify(BoardVo board) {
        log.info("modify...." + board);
        return mapper.update(board) == 1;
    }

    @Transactional
    @Override
    public boolean remove(Long board_no) {
        log.info("remove...." + board_no);

        uploadMapper.deleteFileAll(board_no);
        replyMapper.deleteReplyAll(board_no);
        return mapper.delete(board_no) == 1;
    }

    @Override
    public List<BoardVo> getFreeList() {
        log.info("getList.......");
        return mapper.getFreeList();
    }

    @Override
    public List<BoardVo> getTripList() {
        log.info("getList.......");

        return mapper.getTripList();
    }

    @Override
    public List<BoardVo> getMyList(String mem_nickname) {
        return mapper.getMyList(mem_nickname);
    }

    @Override
    public int deleteMember(String mem_id) {
        return mapper.deleteMember(mem_id);
    }

    @Override
    public int updateBoardhit(Long board_no) {
        return mapper.updateBoardhit(board_no);
    }

}
