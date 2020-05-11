package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVo;
import org.zerock.domain.Criteria;
import org.zerock.domain.UploadFileVo;

public interface UploadFileService {
		
	public List<UploadFileVo> getTripList(Criteria cri);
	
	public int insert(UploadFileVo uploadVo);
	
	public List<UploadFileVo>getListWithPaging(Criteria cri);
	
	public int totalTrip(Criteria cri);
	
	public int totalAll(Criteria cri);
	
	public int deleteFileAll(long board_no);
	
	public List<UploadFileVo> get();
}
