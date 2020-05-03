package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.LocalsubVo;
import org.zerock.mapper.LocalsubMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Service
@Log4j
public class LocalsubServiceImpl implements LocalsubService {
	@Setter(onMethod_=@Autowired)
	private LocalsubMapper mapper;
	
	@Override
	public List<LocalsubVo> list() {
		// TODO Auto-generated method stub
		log.info("Test");
		return mapper.list();
	}

	@Override
	public LocalsubVo getTest(String name) {
		log.info("get");
		return mapper.getTest(name);
	}

}
