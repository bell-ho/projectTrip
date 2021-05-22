package org.zerock.service;

import org.zerock.domain.BoardVo;

import java.util.List;

public interface BoardService {

    void register(BoardVo board);

    BoardVo get(Long board_no);

    boolean modify(BoardVo board);

    boolean remove(Long board_no);

    List<BoardVo> getFreeList();

    List<BoardVo> getTripList();

    List<BoardVo> getMyList(String mem_nickname);

    int deleteMember(String mem_id);

    int updateBoardhit(Long board_no);
}
