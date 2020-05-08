package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.UploadFileService;

import lombok.Setter;

@Controller
public class UploadFileController {
	@Setter(onMethod_ = @Autowired)
	private UploadFileService uploadFileService;
	
	@RequestMapping("/photo/{key}")
	public String photo(@PathVariable("key")String key , Criteria cri, Model model) {
		int total = uploadFileService.totalTrip(cri);
		System.out.println(total);
		model.addAttribute("key",key);
		model.addAttribute("list",uploadFileService.getTripList(cri));
		model.addAttribute("pageMaker",new PageDTO(cri, total));
		return "photo";
	}

	@RequestMapping("/photoAll")
	public void photoAll(Model model ,Criteria cri) {
		int total = uploadFileService.totalAll(cri);
		model.addAttribute("list", uploadFileService.getListWithPaging(cri));
		model.addAttribute("pageMaker",new PageDTO(cri, total));
	}
}
