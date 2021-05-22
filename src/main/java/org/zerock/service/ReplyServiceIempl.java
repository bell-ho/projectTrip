package org.zerock.service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.ReplyVo;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import java.util.List;

@Service
@Log4j
public class ReplyServiceIempl implements ReplyService {

    @Setter(onMethod_ = @Autowired)
    private ReplyMapper mapper;

    @Setter(onMethod_ = @Autowired)
    private BoardMapper boardMapper;

    @Transactional
    @Override
    public int insert(ReplyVo vo) {
        // TODO Auto-generated method stub
        log.info("Reply Insert" + vo);

        boardMapper.updateReplyCnt(vo.getBoard_no(), 1);
        return mapper.insert(vo);
    }

    @Override
    public ReplyVo get(int reply_no) {
        // TODO Auto-generated method stub
        log.info("Reply Get");
        return mapper.get(reply_no);
    }

    @Transactional
    @Override
    public int delete(int reply_no) {
        // TODO Auto-generated method stub
        log.info("Reply Delete" + reply_no);

        ReplyVo vo = mapper.get(reply_no);

        boardMapper.updateReplyCnt(vo.getBoard_no(), -1);
        return mapper.delete(reply_no);
    }

    @Override
    public int update(ReplyVo vo) {
        // TODO Auto-generated method stub
        log.info("Reply Update");
        return mapper.update(vo);
    }

    @Override
    public List<ReplyVo> getList(Long board_no) {
        // TODO Auto-generated method stub
        log.info("Reply getList");
        return mapper.getList(board_no);
    }

    @Override
    public int deleteReplyAll(Long board_no) {
        // TODO Auto-generated method stub
        return mapper.deleteReplyAll(board_no);
    }

    @Override
    public int deleteMember(String mem_id) {
        // TODO Auto-generated method stub
        return mapper.deleteMember(mem_id);
    }

}
