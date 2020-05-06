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
public class BoardController02 {
	@Setter(onMethod_ = @Autowired)
	private BoardService service;

	@GetMapping("/listBoard")
	public void list0(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}

	@GetMapping("/registerBoard")
	public void register() {
	}

	@PostMapping("/registerBoard")
	public String register(BoardVo board, RedirectAttributes rttr) {
		log.info("register: " + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBoard_no());

		return "redirect:/board/listBoard";
	}

	@GetMapping("/get")
	public void get(@RequestParam("board_no") Long board_no, Model model) {
		log.info("/get");
		model.addAttribute("board", service.get(board_no));
	}

	@PostMapping("/modify")
	public String modify(BoardVo board, RedirectAttributes rttr) {
		log.info("modify:" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "succeess");
		}
		return "redirect:/board/listBoard";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("board_no") Long board_no, RedirectAttributes rttr) {
		log.info("remove...." + board_no);
		if (service.remove(board_no)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/listBoard";
	}

}