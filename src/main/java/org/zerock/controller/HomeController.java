package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;
import org.zerock.domain.LocalsubVo;
import org.zerock.service.LocalsubService;

import com.google.gson.Gson;

import lombok.Setter;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Setter(onMethod_ = @Autowired)
	private LocalsubService service;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		List<LocalsubVo> list = service.list();
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("list", list);
		return "main";
	}

	@RequestMapping("/login")
	public void from() {

	}

	@RequestMapping("/naverLogivn")
	public void fromNaver() {

	}

	@RequestMapping("/information/{name}")
	public String information(@PathVariable("name") String name, Model model) {
		model.addAttribute("vo", service.getTest(name));
		return "information";
	}

	@RequestMapping("/trip/{key}" )
	public String trip( @PathVariable("key")String key ,Model model ) {
		model.addAttribute("key",key.substring(0,2));
		return "trip";
	}

	@RequestMapping("/detail")
	public void detail() {

	}

	@RequestMapping("/detail1")
	public void detail1() {

	}

	@RequestMapping("/photo")
	public void photo() {

	}
	@RequestMapping("/photoAll")
	public void photoAll() {

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

	@RequestMapping("/test")
	public void from1() {

	}

	@RequestMapping("/test2")
	public void from2() {

	}
	
}
