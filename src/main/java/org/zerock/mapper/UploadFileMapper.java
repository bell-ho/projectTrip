package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.UploadFileVo;

public interface UploadFileMapper {
	
	public List<UploadFileVo>getTripList(Criteria cri);	// 후기게시글 목록
	
	public int insert(UploadFileVo uploadVo);	//게시글 등록
	
	public List<UploadFileVo>getListWithPaging(Criteria cri);
	
	public int totalAll(Criteria cri);
	
	public int totalTrip(Criteria cri);
	
	public int deleteFileAll(Long board_no);
	
	public List<UploadFileVo> get();
}
