package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVo;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml ")
@Log4j
public class ReplyMapperTest {
	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
//	@Test //Mapper 연결 테스트 
	public void testMapper() {
		log.info(mapper);
	}
	
//	@Test //댓글등록 테스트 
	public void testInsert() {
		ReplyVo vo = new ReplyVo();
		vo.setBOARD_NO(56L);
		vo.setMEM_NO(1);
		vo.setREPLY_CONTENT("집으로");
		log.info("vo : "+vo);
		mapper.insert(vo);
		
	}
	
//	@Test //댓글 한개 가지고오기 테스트
	public void testGet() {
		log.info("결과 "+mapper.read(1));
		
	}
	
//	@Test //댓글 삭제 테스트
	public void testDelete() {
		log.info("삭제"+mapper.delete(1));
	}
	
//	@Test //댓글 수정 테스트
	public void testUpdate() {
		ReplyVo vo = new ReplyVo();
		vo.setREPLY_NO(1);
		vo.setMEM_NO(1);
		vo.setREPLY_CONTENT("수정");
		log.info("수정"+mapper.update(vo));
	}
}
