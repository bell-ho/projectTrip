package org.zerock.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVo;
import org.zerock.domain.UploadFileVo;
import org.zerock.service.BoardService;
import org.zerock.service.ReplyService;
import org.zerock.service.UploadFileService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@Log4j
@RequestMapping("/board/*")

public class BoardController {
    @Setter(onMethod_ = @Autowired)
    private BoardService boardService;

    @Setter(onMethod_ = @Autowired)
    private ReplyService replyService;

    @Setter(onMethod_ = @Autowired)
    private UploadFileService uploadFileService;

    @GetMapping("/listFreeBoard") // 자유게시판
    public void Freelist(Model model) {
        log.info("list");
        model.addAttribute("list", boardService.getFreeList());
    }

    @GetMapping("/listTripBoard") // 여행후기게시판
    public void Triplist(Model model, String title) {
        log.info("list");
        model.addAttribute("list", boardService.getTripList());
//        model.addAttribute("title", title.split(" ")[0]);
    }

    @GetMapping("/listMyBoard") // 내가 쓴 글 게시판
    public void Mylist(Model model, String mem_nickname) {
        log.info("list");
        model.addAttribute("list", boardService.getMyList(mem_nickname));
    }

    @GetMapping("/registerBoard")
    public void register() {
    }

    @PostMapping("/registerBoard") // 게시판 등록
    public String registerFree(BoardVo board, RedirectAttributes rttr, Principal principal) {
        // System.out.println("로그인정보를 가지고온다"+principal.getName());

        board.setMem_id(principal.getName());
        log.info("register: " + board);
        boardService.register(board);

        rttr.addFlashAttribute("result", board.getBoard_no());

        // 파일 처리
        List<String> fname = new ArrayList<String>();
        Pattern nonValidPattern = Pattern.compile("<img[^>] *src=[\"']?([^>\"']+)[\"']?[^>]*>");
        Matcher matcher = nonValidPattern.matcher(board.getBoard_content());

        while (matcher.find()) {
            fname.add(matcher.group(1));
        }

        for (String fileName : fname) {
            UploadFileVo uploadVo = new UploadFileVo();
            uploadVo.setMem_id(principal.getName());
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
    public ModelAndView get(@RequestParam("board_no") Long board_no, Model model, HttpServletRequest request, HttpServletResponse response) {
        log.info("/get : " + board_no);

        BoardVo board = boardService.get(board_no);
        ModelAndView mav = new ModelAndView();

        Cookie[] cookies = request.getCookies();

        // 비교하기 위해 새로운 쿠키
        Cookie viewCookie = null;

        // 쿠키가 있을 경우
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                // Cookie의 name이 cookie + board_no 일치하는 쿠키를 viewCookie에 넣어줌
                if (cookies[i].getName().equals("cookie" + board_no)) {
                    System.out.println("처음 쿠키가 생성한 뒤 들어옴.");
                    viewCookie = cookies[i];
                }
            }
        }

        if (board != null) {
            System.out.println("System - 해당 상세 리뷰페이지로 넘어감");

            mav.addObject("board", board);

            // 만일 viewCookie가 null일 경우 쿠키를 생성해서 조회수 증가 로직을 처리함.
            if (viewCookie == null) {
                System.out.println("cookie 없음");

                // 쿠키 생성(이름, 값)
                Cookie newCookie = new Cookie("cookie" + board_no, "|" + board_no + "|");

                // 쿠키 추가
                response.addCookie(newCookie);

                // 쿠키를 추가 시키고 조회수 증가시킴
                int result = boardService.updateBoardhit(board_no);

               /* if (result > 0) {
                    System.out.println("조회수 증가");
                } else {
                    System.out.println("조회수 증가 에러");
                }*/
            } else {
                // viewCookie가 null이 아닐경우 쿠키가 있으므로 조회수 증가 로직을 처리하지 않음.
                System.out.println("cookie 있음");

                // 쿠키 값 받아옴.
                String value = viewCookie.getValue();

                System.out.println("cookie 값 : " + value);

            }

            mav.setViewName("/board/get");
            return mav;
        } else {
            // 에러 페이지 설정
//            mav.setViewName("error/reviewError");
            return mav;
        }
    }

    @GetMapping("/modifyBoard")
    public void modifyForm(Model model, @RequestParam("board_kinds") int board_kinds,
                           @RequestParam("board_no") Long board_no) {
        model.addAttribute("board", boardService.get(board_no));
    }

    @PostMapping("/modifyBoard")
    public String modify(BoardVo board, RedirectAttributes rttr, Principal principal) {
        board.setMem_id(principal.getName());
        log.info("modify:" + board);

        if (boardService.modify(board)) {
            rttr.addFlashAttribute("result", "succeess");

            if (uploadFileService.deleteFileAll(board.getBoard_no()) >= 1) {
                List<String> fname = new ArrayList<String>();
                Pattern nonValidPattern = Pattern.compile("<img[^>] *src=[\"']?([^>\"']+)[\"']?[^>]*>");// 설정
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
            }
        }
        if (board.getBoard_kinds() == 1) { // 1이 자유
            return "redirect:/board/listFreeBoard";
        } else {
            return "redirect:/board/listTripBoard";
        }
    }

    @RequestMapping("/removeBoard")
    public String remove(@RequestParam("board_kinds") int board_kinds, @RequestParam("board_no") Long board_no,
                         RedirectAttributes rttr) {
        log.info("remove...." + board_no);

        if (boardService.remove(board_no) && board_kinds == 1) {
            rttr.addFlashAttribute("result", "success");
            return "redirect:/board/listFreeBoard";
        } else {
            return "redirect:/board/listTripBoard";
        }

    }

}
