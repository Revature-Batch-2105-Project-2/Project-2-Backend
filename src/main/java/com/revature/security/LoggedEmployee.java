package com.revature.security;

//import javax.servlet.http.HttpSessionBindingEvent;
//import javax.servlet.http.HttpSessionBindingListener;
//
//import org.springframework.stereotype.Component;
//
//import com.revature.beans.Employee;
//
//@Component
//public class LoggedEmployee implements HttpSessionBindingListener {
//	private String username;
//	private ActiveUserStore store;
//	
//	public LoggedEmployee() {}
//	
//	public LoggedEmployee(String username, ActiveUserStore store) {
//		this.username = username;
//		this.store = store;
//	}
//	
//	@Override
//	public void valueBound(HttpSessionBindingEvent event) {
//		Employee active = this.store.getActiveEmployee();
//		LoggedEmployee logged = (LoggedEmployee) event.getValue();
//		if (active == null || !active.getUsername().equals(logged.getUsername())) {
//			this.store.setActiveEmployee(active);
//		}
//	}
//	
//	@Override
//	public void valueUnbound(HttpSessionBindingEvent event) {
//		Employee active = this.store.getActiveEmployee();
//		LoggedEmployee logged = (LoggedEmployee) event.getValue();
//		if (active != null && active.getUsername().equals(logged.getUsername())) {
//			this.store.setActiveEmployee(null);
//		}
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public ActiveUserStore getStore() {
//		return store;
//	}
//
//	public void setStore(ActiveUserStore store) {
//		this.store = store;
//	}
//}
