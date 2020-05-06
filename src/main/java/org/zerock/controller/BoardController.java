package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVo;
import org.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;

	@GetMapping("/listFreeBoard") // 자유게시판
	public void Freelist(Model model) {
		log.info("list");
		model.addAttribute("list", service.getFreeList());
	}

	@GetMapping("/listTripBoard") // 여행후기게시판
	public void Triplist(Model model) {
		log.info("list");
		model.addAttribute("list", service.getTripList());
	}

	@GetMapping("/registerBoard")
	public void register() {
	}

	@PostMapping("/registerBoard") // 게시판 등록
	public String registerFree(BoardVo board, RedirectAttributes rttr) {
		log.info("register: " + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBoard_no());

		if (board.getBoard_kinds() == 1) { // 1이 자유
			return "redirect:/board/listFreeBoard";
		} else {
			return "redirect:/board/listTripBoard";
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
