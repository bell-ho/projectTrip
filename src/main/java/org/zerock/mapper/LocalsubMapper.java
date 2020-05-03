package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVo;
import org.zerock.domain.LocalsubVo;

public interface LocalsubMapper {
//	@Select("select * from board where BOARD_NO >0")
	public List<LocalsubVo> list();
	
	public LocalsubVo getTest(String name);
}
