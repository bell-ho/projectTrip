package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVo;

public interface BoardService {
	
	public void register(BoardVo board);
	
	public BoardVo get(Long BOARD_NO);
	
	public boolean modify(BoardVo board);
	
	public boolean remove(Long BOARD_NO);
	
	public List<BoardVo> getList();
}
