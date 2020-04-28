package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVo;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ =@Autowired )
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board->log.info(board));
	}
	
//	@Test
	public void testInsert() {
		BoardVo board = new BoardVo();
		board.setBOARD_KINDS(1);
		board.setBOARD_TITLE("테스트0428");
		board.setBOARD_HIT(5);
		board.setBOARD_CONTENT("테스트내용");
		board.setMEM_NO(1);
		
		mapper.insert(board);
		
		log.info(board);
	}
	
//	@Test
	public void testInsertSelectkey() {
		
		BoardVo board = new BoardVo();
		board.setBOARD_KINDS(1);
		board.setBOARD_TITLE("테스트0428 selectkey");
		board.setBOARD_HIT(5);
		board.setBOARD_CONTENT("테스트내용");
		board.setMEM_NO(1);
		
		mapper.insertSelectkey(board);
		
		log.info(board);
	}
	
//	@Test
	public void testRead() {
		
		BoardVo board = mapper.read(55L);
		
		log.info(board);
	}
	
//	@Test
	public void testDelete() {
		
		log.info("삭제 카운트"+mapper.delete(55L));
	}
	
//	@Test
	public void testUpdate() {
		BoardVo board = new BoardVo();
		
		board.setBOARD_NO(56L);
		board.setBOARD_KINDS(2);
		board.setBOARD_TITLE("d수정된 제목");
		board.setBOARD_CONTENT("수정된 애용");
		
		int count = mapper.update(board);
		log.info("수정 카운트"+count);
	}
}
