//package org.zerock.mapper;

//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.zerock.domain.BoardVo;

//import lombok.Setter;
//import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j
//public class BoardMapperTests {
//	@Setter(onMethod_ =@Autowired )
//	private BoardMapper mapper;
	
//	@Test
//	public void testGetListFree() {
//		mapper.getFreeList().forEach(board->log.info(board));
//	}
	
//	@Test
//	public void testGetListTrip() {
//		mapper.getTripList().forEach(board->log.info(board));
//	}
	
//	@Test
//	public void testInsert() {
//		BoardVo board = new BoardVo();
//		board.setBoard_kinds(1);
//		board.setBoard_title("테스트0428");
//		board.setBoard_hit(5);
//		board.setBoard_content("테스트내용");
//		board.setMem_no(1);
		
//		mapper.insert(board);
		
//		log.info(board);
//	}
	
//	@Test
//	public void testInsertSelectkey() {
		
//		BoardVo board = new BoardVo();
//		board.setBoard_kinds(1);
//		board.setBoard_title("테스트0428 selectkey");
//		board.setBoard_hit(5);
//		board.setBoard_content("테스트내용");
//		board.setMem_no(1);
		
//		mapper.insertSelectkey(board);
		
//		log.info(board);
//	}
	
//	@Test
//	public void testReadFree() {
		
//		BoardVo board = mapper.readFree(55L);
		
//		log.info(board);
//	}
//	@Test
//	public void testReadTrip() {
		
//		BoardVo board = mapper.readTrip(55L);
		
//		log.info(board);
//	}
	
//	@Test
//	public void testDelete() {
		
//		log.info("삭제 카운트"+mapper.delete(55L));
//	}
	
//	@Test
//	public void testUpdate() {
//		BoardVo board = new BoardVo();
		
//		board.setBoard_no(56L);
//		board.setBoard_kinds(2);
//		board.setBoard_title("d수정된 제목");
//		board.setBoard_content("수정된 애용");
		
//		int count = mapper.update(board);
//		log.info("수정 카운트"+count);
//	}
//}
