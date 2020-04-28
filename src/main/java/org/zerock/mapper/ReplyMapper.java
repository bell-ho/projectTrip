package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVo;

public interface ReplyMapper {
	public int insert(ReplyVo vo); //´ñ±Û ÀÛ¼º
	
	public List<ReplyVo> getListWithPaging(@Param("cri") Criteria  cri,		// ´ñ±Û ¸®½ºÆ®
										@Param("board_no") Long board_no); 
	
	public int delete(int reply_no); //´ñ±Û »èÁ¦
	
	public int update(ReplyVo vo); //´ñ±Û ¼öÁ¤ 
	
	public ReplyVo get(int reply_no); //´ñ±Û ÇÑ°³°¡Áö°í ¿À±â
}
