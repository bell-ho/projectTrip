package org.zerock.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVo;
import org.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ =@Autowired )
	private BoardService service;
	
//	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
//	@Test
	public void testRegister() {
		
		BoardVo board = new BoardVo();
		
		board.setBoard_kinds(1);
		board.setBoard_title("테스트0428");
		board.setBoard_hit(5);
		board.setBoard_content("테스트내용");
		board.setMem_no(1);
		
		service.register(board);
		
		log.info("생성된 게시물 번호"+board.getBoard_no());
	}
	
//	@Test
	public void testGetListFree() {
		service.getFreeList().forEach(board->log.info(board));
	}
	
//	@Test
	public void testGetListTrip() {
		service.getTripList().forEach(board->log.info(board));
	}
	
//	@Test
	public void testGetFree() {
		log.info(service.getFree(61L));
	}
	
//	@Test
	public void testGetTrip() {
		log.info(service.getTrip(61L));
	}
	
//	@Test
	public void testDelete() {
		log.info("삭제 결과: "+service.remove(61L));
	}
	
//	@Test
//	public void testUpdate() {
//		BoardVo board = service.get(56L);
		
//		if(board == null) {
//			return;
//		}
//		board.setBoard_title("제목수정");
//		log.info("modify 결과:"+service.modify(board));
//	}
}
