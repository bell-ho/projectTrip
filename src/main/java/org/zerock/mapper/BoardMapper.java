package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVo;

public interface BoardMapper {
	@Select("select * from board where BOARD_NO >0")
	public List<BoardVo>getList();
}
