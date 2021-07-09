package com.revature.security;

//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//@Component("authSuccessHandler")
//public class UserAuthSuccessHandler implements AuthenticationSuccessHandler {
//	private ActiveUserStore store;
//	
//	@Autowired
//	public UserAuthSuccessHandler(ActiveUserStore store) {
//		this.store = store;
//	}
//	
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//		System.out.println("onAuthSuccess!!!");
//		HttpSession session = request.getSession();
//		
//		if (session != null) {
//			LoggedEmployee logged = new LoggedEmployee(authentication.getName(), this.store);
//			session.setAttribute("logged_in", logged);
//		}
//	}
//}
