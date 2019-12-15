package com.wxl.cms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/file/")
@Controller
public class  FileController{

	@RequestMapping("/up")
	public String upload(){
		System.out.println("-------------------------------------");
		return "/forward/user_add";
	}
	@ResponseBody
	@RequestMapping("/upload")
	public Object upload(@RequestParam("file")MultipartFile file) throws IOException{
		
		String path ="D:\\pic\\";
		String url = path+file.getOriginalFilename();
		File f = new File(url);
		InputStream is = file.getInputStream();
		byte[] b = new byte[is.available()];
		int len = is.read(b);
		OutputStream os = new FileOutputStream(url);
		f.createNewFile();
		os.write(b);
		is.close();
		os.close();
		return url;
	}
}
