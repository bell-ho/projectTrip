package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVo;

public interface ReplyMapper {
	public int insert(ReplyVo vo); //댓글 작성
	
	public List<ReplyVo> getListWithPaging(@Param("cri") Criteria  cri,		// 댓글 리스트
										@Param("board_no") Long board_no); 
	
	public int delete(int reply_no); //댓글 삭제
	
	public int update(ReplyVo vo); //댓글 수정 
	
	public ReplyVo get(int reply_no); //댓글 한개가지고 오기
	
	public int deleteReplyAll(Long board_no); //게시물에 있는 댓글 다지우기
	
	public int deleteMember(String mem_id);
}
