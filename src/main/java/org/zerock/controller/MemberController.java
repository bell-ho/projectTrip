package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.zerock.domain.MemberVo;
import org.zerock.service.MemberService;

import com.google.gson.Gson;

import lombok.Setter;
import oracle.jdbc.proxy.annotation.Post;
import oracle.net.aso.g;

@Controller
public class MemberController {
	
	@Setter(onMethod_=@Autowired)
	private MemberService service;
	
	@PostMapping("/insertMember")
	public String insertMember(MemberVo vo , MultipartHttpServletRequest mut , HttpServletRequest request) throws IOException {
		MultipartFile uplod = mut.getFile("file");
		System.out.println("기본이미지 테스트");
		if(uplod.getSize()<=0) {
			vo.setMem_img("https://as2.ftcdn.net/jpg/02/34/61/79/500_F_234617921_p1AGQkGyEl8CSzwuUI74ljn6IZXqMUf2.jpg");
			service.insert(vo);
			return "redirect:main";
		}else {
			String path = request.getSession().getServletContext().getRealPath("/")+"resources\\img\\";
			System.out.println(path);
			File file = new File(path);
	        //디렉토리 존재하지 않을경우 디렉토리 생성
	        if(!file.exists()) {
	            file.mkdirs();
	        }
	        String ext = uplod.getOriginalFilename().substring(uplod.getOriginalFilename().lastIndexOf("."));
	        String realname = UUID.randomUUID().toString()+ext;
	        System.out.println(realname);
	        ///////////////// 서버에 파일쓰기 /////////////////
	        InputStream is = uplod.getInputStream();
	        OutputStream os=new FileOutputStream(path + realname);
	        int numRead;
	        byte b[] = new byte[(int)uplod.getSize()];
	        while((numRead = is.read(b,0,b.length)) != -1){
	            os.write(b,0,numRead);
	        }
	        if(is != null)  is.close();
	        os.flush();
	        os.close();
	        vo.setMem_img("http://localhost:8080/resources/img/"+realname);
	        service.insert(vo);
	        return "redirect:main";
		}
	}
	
	@GetMapping("/insertMember")
	public void insertMemberform(Model model) {
		model.addAttribute("member", service.getAll());
	}
	
	@PostMapping("/mypage")
	public void mypage(Principal principal , Model model) {
		model.addAttribute("member",service.get(principal.getName()));
	}
	
	
	@GetMapping("/memberDelete")
	public void deletefrom(Principal principal , Model model) {
		model.addAttribute("member",service.get(principal.getName()));
	}
	
	@PostMapping("/memberDelete")
	public String deleteMember(Principal principal , MemberVo vo , Model model , HttpServletRequest request) {
		vo.setMem_id(principal.getName());
		if(service.delete(vo)==1) {
			Cookie[] cookies = request.getCookies();
			if(cookies != null){ // 쿠키가 한개라도 있으면 실행
				for(int i=0; i< cookies.length; i++){ 
					cookies[i].setMaxAge(0);
				}
			}
		}
		return"redirect:/";
	}
	@GetMapping("/memberUpdatePassword")
	public void UpdatePasswordForm(Principal principal , Model model) {
		model.addAttribute("member",service.get(principal.getName()));
	}
	@PostMapping("/memberUpdatePassword")
	public String UpdatePassword(MemberVo vo ,Principal principal , Model model , HttpServletRequest request) {
		vo.setMem_id(principal.getName());
		if(service.update(vo)==1) {
			Cookie[] cookies = request.getCookies();
			if(cookies != null){ // 쿠키가 한개라도 있으면 실행
				for(int i=0; i< cookies.length; i++){ 
					cookies[i].setMaxAge(0);
				}
			}
		}
		return"redirect:/";
	}
	
	@PostMapping(value = "/ajax/getnickname" , produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getnickname() {
		Gson g = new Gson();
		return g.toJson(service.getAll());
	}
	
	@PostMapping("/memupdate")
	public String memnickupdate(MemberVo vo , Model model) {
		System.out.println(vo);
		if(service.memupdate(vo)>=1) {
			model.addAttribute("result","seccess");
		}else {
			model.addAttribute("result","error");
		}
		return "redirect:main";
	}
	@PostMapping("/mem_imgupdate")
	public String mem_imgupdate(Model model , MemberVo vo , MultipartHttpServletRequest mut , HttpServletRequest request) throws IOException {
		MultipartFile uplod = mut.getFile("file");
		String path = request.getSession().getServletContext().getRealPath("/")+"resources\\img\\";
		System.out.println(path);
		File file = new File(path);
        //디렉토리 존재하지 않을경우 디렉토리 생성
        if(!file.exists()) {
            file.mkdirs();
        }
        String ext = uplod.getOriginalFilename().substring(uplod.getOriginalFilename().lastIndexOf("."));
        String realname = UUID.randomUUID().toString()+ext;
        System.out.println(realname);
        ///////////////// 서버에 파일쓰기 /////////////////
        InputStream is = uplod.getInputStream();
        OutputStream os=new FileOutputStream(path + realname);
        int numRead;
        byte b[] = new byte[(int)uplod.getSize()];
        while((numRead = is.read(b,0,b.length)) != -1){
            os.write(b,0,numRead);
        }
        if(is != null)  is.close();
        os.flush();
        os.close();
        vo.setMem_img("http://localhost:8080/resources/img/"+realname);
        System.out.println(vo);
        if(service.memimgupdate(vo) < 1) {
        	model.addAttribute("result","error");
        }
        model.addAttribute("result","seccess");
		return "redirect:main";
	}
	
}
