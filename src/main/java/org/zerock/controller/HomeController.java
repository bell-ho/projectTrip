package org.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	@RequestMapping("/login")
	public void from() {
		
	}
	@RequestMapping("/naverLogin")
	public void fromNaver() {
		
	}
	@RequestMapping("/information")
	public void information() {
		
	}
	@RequestMapping("/trip")
	public void gallery() {
		
	}
	@RequestMapping("/detail")
	public void detail() {
		
	}
	@RequestMapping("/detail1")
	public void detail1() {
		
	}
	@RequestMapping("/photo")
	public void phto() {
		
	}
	@RequestMapping("/board")
	public void board() {
		
	}
	@RequestMapping("/insertMember")
	public void insertMember() {
		
	}
	@RequestMapping("/photo1")
	public void phto1() {
		
	}
	@RequestMapping("/mypage")
	public void mypage() {
		
	}
	
}
