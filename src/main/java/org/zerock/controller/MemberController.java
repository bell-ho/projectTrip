package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.zerock.domain.MemberVo;
import org.zerock.service.MemberService;
import lombok.Setter;

@Controller
public class MemberController {
	
	@Setter(onMethod_=@Autowired)
	private MemberService service;
	
	@PostMapping("/insertMember")
	public String insertMember(MemberVo vo , MultipartHttpServletRequest mut , HttpServletRequest request) throws IOException {
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
        service.insert(vo);
        return "main";
	}
	
	@GetMapping("/insertMember")
	public void insertMemberform(Model model) {
		model.addAttribute("member", service.getAll());
	}
	
	@PostMapping("/mypage")
	public void mypage(Principal principal , Model model) {
		model.addAttribute("member",service.get(principal.getName()));
	}
	@GetMapping("/member/delete")
	public void deletefrom(Principal principal , Model model) {
		model.addAttribute("member",service.get(principal.getName()));
	}
	
}
