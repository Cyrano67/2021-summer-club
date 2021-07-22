package com.cestc.vspace.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cestc.vspace.pojo.Result;
import com.cestc.vspace.pojo.UserList;
import com.cestc.vspace.service.UserlistService;

@RestController
@RequestMapping()
public class LoginController {
	
	@Reference
	private UserlistService userlistService;

	@ResponseBody
	@RequestMapping(value = "login/login.do", method = RequestMethod.POST)
	public Result login(@RequestBody UserList user,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("---------------收到登陆请求--------------------------------");
		System.out.println("post phone num:");
		System.out.println(user.getPhone());
		System.out.println("post pwd:");
		System.out.println(user.getPassword());
		UserList userExist = userlistService.Login(user.getPhone(), user.getPassword());		
		
		Result result = new Result();
		if(userExist!=null) {
			System.out.println("---------------登陆成功--------------------------------");
			// 自动登录
			String phone = userExist.getPhone();
			String password = userExist.getPassword();
			String uname = userExist.getUname();
			Integer uid = userExist.getUid();
			
			// 将手机号与密码存储到cookie中.
			Cookie cookie = new Cookie("autologin",uid.toString());
			cookie.setMaxAge(7 * 24 * 60 * 60);
			cookie.setPath("/");
			response.addCookie(cookie);
			
			request.getSession().setAttribute("autologin","true");
			request.getSession().setAttribute("phone",phone);
			request.getSession().setAttribute("uname",uname);
			request.getSession().setAttribute("uid",uid);
			// 登录成功后，将用户存储到session中.
//			request.getSession().invalidate();
//			HttpSession
//			//将UID返回到前端
//			request.getSession().setAttribute("uid", uid);
//			response.sendRedirect(request.getContextPath() + "/index");
//			Session.
			System.out.println("login user:");
			System.out.println(uname.intern());
			result.setResultTag(true);
			result.setMsg(uname);
			result.setalterMsg(uid.toString());
		}else {
			System.out.println("---------------用户名或密码错误--------------------------------");
//			request.setAttribute("login_msg", "用户名或密码错误");
//			request.getRequestDispatcher("/login").forward(request,
//					response);
			result.setResultTag(false);
		}		
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "login/signin.do", method = RequestMethod.POST)
	public Result signin(@RequestBody UserList user,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("---------------收到注册请求--------------------------------");
		System.out.println("post phone num:");
		System.out.println(user.getPhone());
		System.out.println("post pwd:");
		System.out.println(user.getPassword());
		boolean userExist = userlistService.register(user);		
		
		Result result = new Result();
		if(userExist!=false) {
			System.out.println("---------------注册成功--------------------------------");
			UserList userlg = userlistService.Login(user.getPhone(), user.getPassword());
			// 自动登录
			String phone = userlg.getPhone();
			String password = userlg.getPassword();
			String uname = userlg.getUname();
			Integer uid = userlg.getUid();
			
			// 将手机号与密码存储到cookie中.
			Cookie cookie = new Cookie("autologin",uid.toString());
			cookie.setMaxAge(7 * 24 * 60 * 60);
			cookie.setPath("/");
			response.addCookie(cookie);
			
			request.getSession().setAttribute("autologin","true");
			request.getSession().setAttribute("phone",phone);
			request.getSession().setAttribute("uname",uname);
			request.getSession().setAttribute("uid",uid);
			// 登录成功后，将用户存储到session中.
			System.out.println("login regist user:");
			System.out.println(uname.intern());
			result.setResultTag(true);
			result.setMsg(uname);
			result.setalterMsg(uid.toString());
		}else {
			System.out.println("---------------用户名或密码错误--------------------------------");
//			request.setAttribute("login_msg", "用户名或密码错误");
//			request.getRequestDispatcher("/login").forward(request,
//					response);
			result.setResultTag(false);
		}		
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "login/autologin.do", method = RequestMethod.POST)
	public Result autologin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("---------------收到自动登陆请求--------------------------------");	
		
		String loginstatus = (String) request.getSession().getAttribute("autologin");
		
		Result result = new Result();
		if(loginstatus=="true") {
			System.out.println("---------------登陆成功--------------------------------");
			// 自动登录
			String phone = (String) request.getSession().getAttribute("phone");
			String password = (String) request.getSession().getAttribute("password");
			String uname = (String) request.getSession().getAttribute("uname");
			Integer uid = (Integer) request.getSession().getAttribute("uid");
			
			// 将手机号与密码存储到cookie中.
			Cookie cookie = new Cookie("autologin",uid.toString());
			cookie.setMaxAge(7 * 24 * 60 * 60);
			cookie.setPath("/");
			response.addCookie(cookie);
			
			// 登录成功后，将用户存储到session中.
//			request.getSession().invalidate();
//			HttpSession
//			//将UID返回到前端
//			request.getSession().setAttribute("uid", uid);
//			response.sendRedirect(request.getContextPath() + "/index");
//			Session.
			System.out.println("auto login user:");
			System.out.println(uname.intern());
			result.setResultTag(true);
			result.setMsg(uname);
			result.setalterMsg(uid.toString());
		}else {
			System.out.println("---------------没有session--------------------------------");
//			request.setAttribute("login_msg", "用户名或密码错误");
//			request.getRequestDispatcher("/login").forward(request,
//					response);
			result.setResultTag(false);
		}		
		
		return result;
	}
	
}
