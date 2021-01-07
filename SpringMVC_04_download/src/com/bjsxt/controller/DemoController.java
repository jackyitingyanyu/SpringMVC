package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.FileAppender;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.Demo;
import com.bjsxt.pojo.People;
/**
 * 1.先设置该响应头中的"Content-Disposition"和"attchment;filename"属性
 * 2.获取response的输出流
 * 3.
 * @author jackyanyu
 *
 */
@Controller
public class DemoController {
	@RequestMapping("download")
	public void download(String fileName,HttpServletRequest req,HttpServletResponse res) throws IOException {
//		PrintWriter writer = res.getWriter();
//		res.setContentType(type);
		//设置响应流中文件进行下载
		res.setHeader("Content-Disposition", "attachment;filename"+fileName);
		//二进制流放入响应体中
		ServletOutputStream os = res.getOutputStream();
		
		//找文件目录必须从磁盘根目录开始找
		String path=req.getServletContext().getRealPath("files");
		System.out.println(path);
		File file = new File(path,fileName);
		//文件直接转成字节数组
		byte[] bytes = FileUtils.readFileToByteArray(file);
		os.write(bytes);
		os.flush();
		os.close();
	}
	
}
