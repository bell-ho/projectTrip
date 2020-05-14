package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.zerock.domain.MemberVo;

import lombok.Setter;

@Controller
public class MemberController {
	@Setter(onMethod_=@Autowired)
	private BCryptPasswordEncoder encoder;
	
	@PostMapping("/insertMember")
	public void insertMember(MemberVo vo) {
		System.out.println(vo);
		String a = encoder.encode(vo.getMem_password());
		System.out.println(a);
	}
	@GetMapping("/insertMember")
	public void insertMemberform() {
		System.out.println("회원가입 폼으로 이동함");
	}
	
}
