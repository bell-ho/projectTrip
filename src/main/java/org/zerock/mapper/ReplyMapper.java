package org.zerock.mapper;

import org.zerock.domain.ReplyVo;

public interface ReplyMapper {
	public int insert(ReplyVo vo); //댓글 작성
	
	public ReplyVo read(int reply_no); // 댓글한개 가지고오기
	
	public int delete(int reply_no); //댓글 삭제
	
	public int update(ReplyVo vo); //댓글 수정
}
