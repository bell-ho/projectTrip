package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVo;
import org.zerock.domain.UploadFileVo;
import org.zerock.service.BoardService;
import org.zerock.service.ReplyService;
import org.zerock.service.UploadFileService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")

public class BoardController {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Setter(onMethod_ =@Autowired )
	private ReplyService reservice;

	@Setter(onMethod_ = @Autowired)
	private UploadFileService uploadFileService;
	
	
	@GetMapping("/listFreeBoard") // 자유게시판
	public void Freelist(Model model) {
		log.info("list");
		model.addAttribute("list", service.getFreeList());
	}

	@GetMapping("/listTripBoard") // 여행후기게시판
	public void Triplist(Model model , String title) {
		log.info("list");
		model.addAttribute("list", service.getTripList());
		model.addAttribute("title", title.split(" ")[0]);
	}

	@GetMapping("/registerBoard")
	public void register() {
	}

	@PostMapping("/registerBoard") // 게시판 등록
	public String registerFree(BoardVo board, RedirectAttributes rttr) {
		log.info("register: " + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBoard_no());
		//파일 처리
		List<String> fname = new ArrayList<String>();
		Pattern nonValidPattern = Pattern.compile("<img[^>] *src=[\"']?([^>\"']+)[\"']?[^>]*>");
		Matcher matcher = nonValidPattern.matcher(board.getBoard_content());
		while (matcher.find()) {
  			fname.add(matcher.group(1));
  		}
		for (String fileName : fname) {
			UploadFileVo uploadVo = new UploadFileVo();
			uploadVo.setBoard_no(board.getBoard_no());
			uploadVo.setFile_name(fileName);
			uploadFileService.insert(uploadVo);
		}
		if (board.getBoard_kinds() == 1) { // 1이 자유
			return "redirect:/board/listFreeBoard";
		} else {
			return "redirect:/board/listTripBoard?title=";
		}
	}

	@GetMapping("/get")
	public void get(@RequestParam("board_no") Long board_no, Model model) {

		log.info("/get");
		log.info("/get : " + board_no);
		model.addAttribute("board", service.get(board_no));
		
		
//		if (board.getBoard_kinds() == 1) { // 1이 자유
//			model.addAttribute("board", service.getFree(board_no));
//		} else {
//			model.addAttribute("board", service.getTrip(board_no));
//		}
	}

	@PostMapping("/modifyBoard")
	public String modify(BoardVo board, RedirectAttributes rttr) {
		log.info("modify:" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "succeess");
		}

		if (board.getBoard_kinds() == 1) { // 1이 자유
			return "redirect:/board/listFreeBoard";
		} else {
			return "redirect:/board/listTripBoard";
		}
	}

	@RequestMapping("/removeBoard")
	public String remove(@RequestParam("board_kinds")  int board_kinds, @RequestParam("board_no") Long board_no, RedirectAttributes rttr) {
		log.info("remove...." + board_no);
		if (service.remove(board_no) && board_kinds == 1) {
			rttr.addFlashAttribute("result", "success");
			return "redirect:/board/listFreeBoard";
		}else {
			return "redirect:/board/listTripBoard";
		}
		
//		if (bb == 1) { // 1이 자유
//			return "redirect:/board/listFreeBoard";
//		} else {
//			return "redirect:/board/listTripBoard";
//		}
	}

}
