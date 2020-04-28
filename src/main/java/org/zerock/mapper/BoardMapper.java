package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVo;

public interface BoardMapper {
//	@Select("select * from board where BOARD_NO >0")
	public List<BoardVo>getList();
	
	public void insert(BoardVo board);
	
	public void insertSelectkey(BoardVo board);
	
	public BoardVo read(Long BOARD_NO);
	
	public int delete(Long BOARD_NO);
	
	public int update(BoardVo board);
}
