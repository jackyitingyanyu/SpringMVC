package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.FileAppender;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;


@Controller
public class DemoController {
	
	@RequestMapping("upload")
	public String upload(MultipartFile file,String name,HttpSession session) throws IOException {
		System.out.println("name:"+name);
		//获取到文件名和输入流流流流
		String fileName = file.getOriginalFilename();
		String suffix=fileName.substring(fileName.lastIndexOf("."));
		if(suffix.equalsIgnoreCase(".png")) {
			//全局唯一不重值
		String uuid = UUID.randomUUID().toString();
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:/"+uuid+suffix));
		//转发到index.jsp
		session.setAttribute("name", name);
		return "index.jsp";
		}else {
			return "error.jsp";
		}	
	}
}
