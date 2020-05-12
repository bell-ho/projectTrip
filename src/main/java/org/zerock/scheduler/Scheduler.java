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
	
	@Scheduled(cron = "0 0/1 * * * * ")
	public void checkFiles() throws Exception {
		//System.out.println("씨큐리티아아아아아아아아아아ㅏ아ㅑㅓㅐㅑㄴ워후누아ㅓ;ㅜㅎ;ㅁㄱㄴ;");
		int cnt = 0; // 시작시 카운트는 0 
		String path = this.getClass().getResource("").getPath(); //현제 클래스의 물리경로 즉 서버의 경로를 알아온다
		int idx = path.indexOf("WEB-INF"); //현제 경로에서 WEB-INF의 인댁스의 값을 구해온다 
		String realPath = path.substring(1,idx)+"resources\\upload"; // 인댁스가 1부터 WEB-INF의 인댁스까지 문자열을 자른후 upload경로를 설정한다
		File file = new File(realPath); //서버의 경로를 파일로 지정한다 
		//System.out.println("씨발........");
		for (File info :FileUtils.listFiles(new File(realPath), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) {
			//반복문을이용해 서버경로의 모든 파일을 구해와 하나씩 info에 담아준다
				String filepath = info.getPath();//담긴파일의 경로를 알아온다
				String file_name = info.getName().toString();//담긴파일의 이름을 구해온다 
				List<UploadFileVo> list =servce.get(); // 서비스를 이용해 uploadfile DB에있는 값을 가지고 온다
				//System.out.println("파일이름가지고옴"+file_name);
				for(int i= 0 ; i<= list.size()-1 ; i++){ // upload 파일을 반복문으로 돌린다 
					//System.out.println("비교중");
					int vo_index = list.get(i).getFile_name().lastIndexOf("/")+1;
					//DB에서 가지온 값은 http://localhost:8080/resources/upload/2020\05\11/28019ece-463b-4acc-b579-3f5b2de7b69d.png
					//이런식이라 이름으로 잘라줘야한다 자르기위해 문자열의 뒤에서부터 /까지의 인댁스를구한다 
					String DBFileName= list.get(i).getFile_name().substring(vo_index);
					// 뒤에서부터 가지고온 vo_index를 이용해 문자열을 잘라준다 
					//System.out.println(DBFileName); //비교할 DB에있는 파일 이름 -> 실시간 파일
					//System.out.println(file_name); // 비교할 서버에있는 파일이름 -> old 파일
					if(DBFileName.equals(file_name)) {//파일을 돌리면서 파일 이름과 info와 비교한다						
						cnt++;//같은 이름이 있을경우 카운트를 1로 만든다 
					}
				}//반복문 종료
				if(cnt != 1) {// cnt가 1이 아니라면 그 파일은 삭제된 파일이거나 잘못된 파일이다
					System.out.println("삭제");
					info.delete(); // 파일을 삭제한다 
				}
        }//다시 info를 하나 만들어서 꺼내온다 
	}
}
