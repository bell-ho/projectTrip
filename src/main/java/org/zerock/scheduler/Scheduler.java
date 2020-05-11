package org.zerock.scheduler;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.zerock.domain.UploadFileVo;
import org.zerock.service.UploadFileService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class Scheduler {
	@Setter(onMethod_=@Autowired)
	private UploadFileService servce;
	
	@Scheduled(cron = "0 * * * * *")
	public void checkFiles() throws Exception {
		String path = this.getClass().getResource("").getPath();
		int idx = path.indexOf("WEB-INF");
		String realPath = path.substring(1,idx)+"resources\\upload";
		File file = new File(realPath);
		System.out.println("시작");
		for (File info :FileUtils.listFiles(new File(realPath), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) {
				String filepath = info.getPath();
				String file_name = info.getName().toString();
				List<UploadFileVo> list =servce.get();
				System.out.println("파일이름가지고옴"+file_name);
				for(UploadFileVo vo : list){
					System.out.println("비교중");
					if(!vo.getFile_name().equals(file_name)) {
						System.out.println("삭제");
						File deleteFile = new File(filepath);
						deleteFile.delete();
					}
				}
        }
	}
}
