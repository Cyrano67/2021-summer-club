package com.cestc.vspace.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;

import com.cestc.vspace.pojo.UserList;
import com.cestc.vspace.service.UserlistService;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/*"})
public class LoginFilter implements Filter {
	
	@Reference
	private UserlistService userlistService;
	
	public void init(FilterConfig filterConfig) throws ServletException {}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 1.强转
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		// 2.操作
		if (("/cart.html".equalsIgnoreCase(path)
				|| "/checkout.html".equalsIgnoreCase(path) || "/regist".equalsIgnoreCase(path))) 
		{
			// 2.1判断当前用户是否登录
			Integer uid = (Integer) req.getSession().getAttribute("uid");
			if (uid == null) { // user为null说明用户没有登录，可以进行自动登录操作
				// 2.2 得到访问的资源路径
					// 符合条件的是可以进行自动登录操作的.
	 
					// 2.3 得到cookie，从cookie中获取username,password
					Cookie[] cookies = req.getCookies();
					Cookie cookie = null;
					if (cookies != null ) {
						for (Cookie c : cookies) {
							if (c.getName().equals("autologin")) {
								cookie = c;
							}
						}
					}
					if (cookie != null) {
//						String password = cookie.getValue().split("%springboot%")[1];
						// 2.4调用UserService方法进行登录操作.
						int auid = Integer.parseInt(cookie.getValue());
						UserList userExist = userlistService.AutoLogin(auid);
						String phone = userExist.getPhone();
						String password = userExist.getPassword();
						String uname = userExist.getUname();
						req.getSession().setAttribute("autologin","true");
						req.getSession().setAttribute("phone",phone);
						req.getSession().setAttribute("uname",uname);
						req.getSession().setAttribute("uid",uid);
					}
					else {
						request.getRequestDispatcher("login").forward(request, response);
					}
	 
				}
 
		}
		// 3.放行
		chain.doFilter(req, resp);
	}
	public void destroy() {
	}
}
