package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVo;

public interface BoardService {

	public void register(BoardVo board);

	public BoardVo get(Long board_no);

	public boolean modify(BoardVo board);

	public boolean remove(Long board_no);

	public List<BoardVo> getFreeList();

	public List<BoardVo> getTripList();

	public List<BoardVo> getMyList(String mem_nickname);
	
	public int deleteMember(String mem_id);
	
}
