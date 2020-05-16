package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
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
		vo.setBoard_no(56L);
		vo.setReply_content("집으로");
		log.info("vo : "+vo);
		mapper.insert(vo);
		
	}
	
//	@Test //특정 게시물 번호의 댓글 가지고오기
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVo> replies = mapper.getListWithPaging(cri, 1L);
		replies.forEach(reply->log.info(reply));
	}
	
//	@Test //댓글 삭제 테스트
	public void testDelete() {
		log.info("삭제"+mapper.delete(1));
	}
	
//	@Test //댓글 삭제 테스트
	public void testGet() {
		log.info("댓글 1개 가지고 오기"+mapper.get(1));
	}
	
//	@Test //댓글 수정 테스트
	public void testUpdate() {
		ReplyVo vo = new ReplyVo();
		vo.setReply_no(1);
		vo.setReply_content("수정");
		log.info("수정"+mapper.update(vo));
	}
}
