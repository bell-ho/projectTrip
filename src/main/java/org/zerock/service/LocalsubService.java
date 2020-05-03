package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVo;
import org.zerock.domain.LocalsubVo;

public interface LocalsubService {
	
	public List<LocalsubVo> list();
	
	public LocalsubVo getTest(String name);
}
