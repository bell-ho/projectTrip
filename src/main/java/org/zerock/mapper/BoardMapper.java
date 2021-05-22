package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVo;

import java.util.List;

public interface BoardMapper {

    List<BoardVo> getFreeList();    // 자유게시글 목록

    List<BoardVo> getTripList();    // 후기게시글 목록

    List<BoardVo> getMyList(String mem_nickname); // 자기가 쓴글 게시판

    void insert(BoardVo board);    //게시글 등록

    void insertSelectkey(BoardVo board); //게시글 등록

    BoardVo read(Long board_no); //자유게시글 상세

    int delete(Long board_no); //게시글 삭제

    int update(BoardVo board); //게시글 수정

    void updateReplyCnt(@Param("board_no") Long board_no, @Param("amount") int amount);

    int deleteMember(String mem_id);

    int updateBoardhit(Long board_no);
}
