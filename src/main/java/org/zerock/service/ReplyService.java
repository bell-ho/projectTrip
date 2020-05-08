package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVo;

public interface ReplyService {
	
	public int insert(ReplyVo vo); //댓글 작성
	
	public ReplyVo get(int reply_no); //댓글 1개 가지고오기
	
	public int delete(int reply_no); //댓글 삭제
	
	public int update(ReplyVo vo); // 댓글 수정
	
	public List<ReplyVo> getListWithPaging(Criteria cri , Long board_no); //게시글의 댓글 가지고 오기
	
	public int deleteReplyAll(Long board_no);
}
