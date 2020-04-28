package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVo;

public interface BoardMapper {
//	@Select("select * from board where BOARD_NO >0")
	public List<BoardVo>getList();	//게시글 목록
	
	public void insert(BoardVo board);	//게시글 등록
	
	public void insertSelectkey(BoardVo board); //게시글 등록
	
	public BoardVo read(Long board_no); //게시글 상세
	
	public int delete(Long board_no); //게시글 삭제
	
	public int update(BoardVo board); //게시글 수정
}
