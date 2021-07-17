package com.cestc.vspace.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cestc.vspace.pojo.UserList;



@Controller
@RequestMapping("*")
public class GuideController {
	
//	@Reference
//	private userlistService userlistService;
	
	@RequestMapping("/index")
	public String toindex(HttpServletRequest request, HttpServletResponse response){
//		UserList user = userlistService.findById(1);
//		System.out.println(user);
		String autologin = (String)request.getSession().getAttribute("autologin");
		if(autologin != null)
			System.out.println("session validated: "+autologin);
		
		return "index.html";
	}
	
	@RequestMapping("/login")
	public String tologin(HttpServletRequest request, HttpServletResponse response){
//		UserList user = userlistService.findById(1);
//		System.out.println(user);
		String autologin = (String)request.getSession().getAttribute("autologin");
		if(autologin != null)
			System.out.println("session validated: "+autologin);
		return "login.html";
	}

	@RequestMapping("/detail")
	public String todetail(){
		return "product-details.html";
	}
	
	public GuideController() {
		// TODO Auto-generated constructor stub
	}

}
