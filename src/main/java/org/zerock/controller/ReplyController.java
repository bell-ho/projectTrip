package org.zerock.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.ReplyVo;
import org.zerock.service.ReplyService;

import java.security.Principal;
import java.util.List;

@RequestMapping("/reply/*")
@Log4j
@Controller
public class ReplyController {
    @Setter(onMethod_ = @Autowired)
    private ReplyService service;

    //	/reply/insert를post방식으로 요청
    @PostMapping(value = "/insert")
    public String insert(ReplyVo vo, Principal principal) {

        vo.setMem_id(principal.getName());
        log.info("insert Vo = " + vo);
        int result = service.insert(vo);
        log.info("결과  = " + result);

        return "redirect:/board/get?board_no=" + vo.getBoard_no();
    }

    //	/reply/page/board_no/page 를요청하면 json 타입으로 응답 매개변수는 @pathVariable로 받아온다
    @GetMapping(value = "/{board_no}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public List<ReplyVo> getList(@PathVariable("board_no") Long board_no) {
        log.info("getList");
        List<ReplyVo> list = service.getList(board_no);
        log.info(list);
        return list;
    }

    @GetMapping(value = "/{board_no}/{reply_no}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public ReplyVo get(@PathVariable("reply_no") int reply_no) {
        log.info("get" + reply_no);
        ReplyVo vo = service.get(reply_no);
        return vo;
    }

    @PostMapping(value = "/{board_no}/{reply_no}")
    public String delete(@PathVariable("board_no") Long board_no, @PathVariable("reply_no") int reply_no) {
        log.info("delete" + reply_no);

        int result = service.delete(reply_no);

        return "redirect:/board/get?board_no=" + board_no;
    }

    @PostMapping(value = "/{board_no}/update")
    public String update(@PathVariable("board_no") Long board_no, ReplyVo vo) {
        log.info("update" + vo);

        int result = service.update(vo);

        return "redirect:/board/get?board_no=" + board_no;
    }
}
