package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urlData")
public class UrlRequestData {
	
	/**
	 * 地址栏获取参数 MONTH = GET
	 * http://localhost:9394/springbootDemo/urlData/urlGetData?name=Han&age=30
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping("/urlGetData")
	public String urlGetData(String name ,String age){
		return name + age;
	}
	/**
	 * http://localhost:9394/springbootDemo/urlData/urlPostData?name=Han&age=30
	 * @param request
	 * @return
	 */
	@RequestMapping("/urlPostData")
	public String urlPostData(HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		return name + age;
	}
}
