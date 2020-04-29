package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVo;
import org.zerock.service.ReplyService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RequestMapping("/reply/")
@Log4j
@RestController
public class ReplyController {
	@Setter(onMethod_ = @Autowired)
	private ReplyService service;

//	/reply/insert를post방식으로 요청   요청할떄 받는 타입을 json 으로 제한	
	@PostMapping(value = "/insert", consumes = "application/json")
	public String insert(@RequestBody ReplyVo vo) {
		
		log.info("insert Vo = " + vo);
		int result = service.insert(vo);
		log.info("결과  = " + result);
		return result == 1 ? "success" : "error";
	}

//	/reply/page/board_no/page 를요청하면 json 타입으로 응답 매개변수는 @pathVariable로 받아온다 
	@GetMapping(value = "/page/{board_no}/{page}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public List<ReplyVo> getListWithPaging(@PathVariable("page") int page, @PathVariable("board_no") Long board_no) {
		log.info("getListWithPaging");
		Criteria cri = new Criteria(page, 10);
		List<ReplyVo> list = service.getListWithPaging(cri, board_no);
		log.info(list);
		return list;
	}

	@GetMapping(value = "/{reply_no}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ReplyVo get(@PathVariable("reply_no") int reply_no) {
		log.info("get" + reply_no);
		ReplyVo vo = service.get(reply_no);
		return vo;
	}

	@DeleteMapping(value = "/{reply_no}")
	public String delete(@PathVariable("reply_no") int reply_no) {
		log.info("delete" + reply_no);
		int result = service.delete(reply_no);
		return result == 1 ? "success" : "error";
	}
}
