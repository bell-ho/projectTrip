package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVo;

public interface BoardMapper {
//	@Select("select * from board where BOARD_NO >0")
	public List<BoardVo>getFreeList();	// 자유게시글 목록
	
	public List<BoardVo>getTripList();	// 후기게시글 목록
	
	public void insert(BoardVo board);	//게시글 등록
	
	public void insertSelectkey(BoardVo board); //게시글 등록
	
	public BoardVo read(Long board_no); //자유게시글 상세
	
	public int delete(Long board_no); //게시글 삭제
	
	public int update(BoardVo board); //게시글 수정
	
	public void updateReplyCnt(@Param("board_no")Long board_no , @Param("amount") int amount);
	
	public int deleteMember(String mem_id);
}
