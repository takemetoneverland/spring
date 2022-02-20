package com.spring.myweb.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.myweb.command.SnsBoardVO;
import com.spring.myweb.command.UserVO;
import com.spring.myweb.snsboard.service.ISnsBoardService;

@Controller
@RequestMapping("/snsBoard")
public class SnsBoardController {

	@Autowired
	private ISnsBoardService service;

	@GetMapping("/snsList")
	public void snsList() {}
	
	@PostMapping("/upload")
	@ResponseBody //비동기방식
	public String upload(MultipartFile file, String content, //HttpSession 객체는 id 받아오려고.
						 HttpSession session) { //@RequestParam 안썼으니까 변수 이름 같아야 함
		
		try {
			
			String writer = ((UserVO)session.getAttribute("login")).getUserId();
			
			//날짜별로 폴더를 생성해서 파일을 관리
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			String fileLoca = sdf.format(date); //폴더이름
			
			//저장할 폴더 경로
			String uploadPath = "C:\\Users\\D\\Desktop\\upload" + fileLoca; //완성된 절대경로
			
			File folder = new File(uploadPath);
			if(!folder.exists()) { //exists() 존재하니?
				folder.mkdir(); //폴더가 존재하지 않는다면 생성해라.
			}
			
			String fileRealName = file.getOriginalFilename();
			
			//파일명을 고유한 랜덤 문자로 생성.
			UUID uuid = UUID.randomUUID();
			String uuids = uuid.toString().replaceAll("-", "");
			
			//확장자를 추출한다.
			String fileExtension = fileRealName.substring(fileRealName.indexOf("."), fileRealName.length());
			
			System.out.println("저장할 폴더 경로: " + uploadPath);
			System.out.println("실제 파일명: " + fileRealName);
			System.out.println("폴더명: " + fileLoca);
			System.out.println("확장자: " + fileExtension);
			System.out.println("고유랜덤문자: " + uuids);

			String fileName = uuids + fileExtension;
			System.out.println("변경해서 저장할 파일명: " + fileName);
			
			//업로드한 파일을 서버 컴퓨터의 저장한 경로 내에 실제로 저장.
			File saveFile = new File(uploadPath + "\\" + fileName);
			file.transferTo(saveFile);
			
			//DB에 insert 작업을 진행.
			SnsBoardVO snsVO = new SnsBoardVO(0, writer, uploadPath, fileLoca, fileName, fileRealName, content, null); 
			//0은 DB에 들어가지 않음. 시퀀스로 글번호 받으니까. null은 regdate임.
			service.insert(snsVO);
			
			return "success";
		} catch (Exception e) {
			System.out.println("업로드 중 에러 발생: " + e.getMessage());
			return "fail"; //에러가 났을 시에는 실패 키워드를 반환.
		}
		
	}
	
}















