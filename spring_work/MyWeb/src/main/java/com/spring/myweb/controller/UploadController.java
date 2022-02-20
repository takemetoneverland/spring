package com.spring.myweb.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.myweb.command.MultiUploadVO;
import com.spring.myweb.command.UploadVO;

@Controller
@RequestMapping("/fileupload")
public class UploadController {

	@GetMapping("/upload")
	public void form() {}
	
	@PostMapping("/upload_ok")
	public String upload(@RequestParam("file") MultipartFile file) { //파라미터 이름과 변수명이 같아서 @RequestParam은 생략 가능함.
		
		
		try {
			String fileRealName = file.getOriginalFilename(); //파일명
			long size = file.getSize(); //파일 사이즈
			
			System.out.println("파일명: " + fileRealName);
			System.out.println("사이즈: " + size);
			
			//서버에서 저장할 파일 이름
			//파일리얼네임의 .부터 파일리얼네임의 끝까지 추출.
			String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
			String uploadFolder = "C:\\test\\upload";
			
			/*
			 파일 업로드 시 파일명이 동일한 파일이 이미 존재할 수도 있고,
			 사용자가 업로드하는 파일명이 영어 이외의 언어로 되어있을 수 있다.
			 타 언어를 지원하지 않는 환경에서는 정상 동작이 되지 않는다. (리눅스)
			 고유한 랜덤 문자를 통해 DB와 서버에 저장할 파일명을 새롭게 만들어 준다.
			 */
			UUID uuid = UUID.randomUUID();
			System.out.println(uuid.toString());
			String[] uuids = uuid.toString().split("-");
			String uniqueName = uuids[0];
			System.out.println("생성된 고유 문자열: " + uniqueName);
			System.out.println("확장자명: " + fileExtension);
			
			//java.io 패키지의 file임
			File saveFile = new File(uploadFolder + "\\" + fileRealName + uniqueName + fileExtension);
			
			//실제 파일 저장 메서드 (fileWriter 작업을 손쉽게 한방에 처리해 준다.)
			file.transferTo(saveFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "fileupload/upload_ok";
		
	}
	
	@PostMapping("/upload_ok2")
	public String upload2(MultipartHttpServletRequest files) {
		
		//서버에서 저장할 파일 경로
		String uploadFolder = "C:\\test\\upload";
		
		List<MultipartFile> list = files.getFiles("files");
		
		/*
		for(int i=0; i<list.size(); i++) {
			String fileRealName = list.get(i).getOriginalFilename();
			long size = list.get(i).getSize();
			
			System.out.println("파일명: " + fileRealName);
			System.out.println("사이즈: " + size);
			
			File saveFile = new File(uploadFolder + "\\" + fileRealName);
			try {
				list.get(i).transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		*/
		
		for(MultipartFile m : list) {
			String fileRealName = m.getOriginalFilename();
			long size = m.getSize();
			System.out.println("파일명: " + fileRealName);
			System.out.println("사이즈: " + size);
			
			File saveFile = new File(uploadFolder + "\\" + fileRealName);
			try {
				m.transferTo(saveFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return "fileupload/upload_ok";
	}
	
	@PostMapping("/upload_ok3")
	public String upload3(@RequestParam("file") List<MultipartFile> list) {
		
		String uploadFolder = "C:\\test\\upload";
		
		for(MultipartFile m : list) {
			String fileRealName = m.getOriginalFilename();
			long size = m.getSize();
			System.out.println("파일명: " + fileRealName);
			System.out.println("사이즈: " + size);
			
			File saveFile = new File(uploadFolder + "\\" + fileRealName);
			try {
				m.transferTo(saveFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "fileupload/upload_ok";
	}
	
	@PostMapping("/upload_ok4")
	public String upload4(MultiUploadVO vo) {
		
		System.out.println(vo);
		
		String uploadFolder = "C:\\test\\upload";
		List<UploadVO> list = vo.getList();
		
		try {
			for(UploadVO uvo : list) {
				String fileRealName = uvo.getFile().getOriginalFilename();
				long size = uvo.getFile().getSize();
				
				File saveFile = new File(uploadFolder + "\\");
				uvo.getFile().transferTo(saveFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "fileupload/upload_ok";
	}
}













