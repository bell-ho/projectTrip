package org.zerock.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class EmailController {
	@Setter(onMethod_=@Autowired)
	private MailSender MailSender;
	
	public void setJavaMailSender(MailSender javaMailSender) {
		this.MailSender = javaMailSender;
	}
	
	@PostMapping(value = "/ajax/email" , produces ="text/plain;charset=UTF-8")
	@ResponseBody
	public String email(String mem_email , Model model ) {
		int num = (int) Math.ceil((Math.random() * 10000));
			model.addAttribute("result", num);
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setSubject("회원가입을 환영합니다");
			mailMessage.setFrom("seodonguk1128@gmail.com");
			mailMessage.setText("인증번호는"+num);
			mailMessage.setTo(mem_email);
			try {
				MailSender.send(mailMessage);
			}catch (Exception e) {
				// TODO: handle exception'
				log.info(e.getMessage());
			}
			System.out.println(num);
		return num+"";
	}
}
