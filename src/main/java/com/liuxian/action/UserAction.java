package com.liuxian.action;

import java.io.IOException;
import java.io.Writer;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.security.auth.spi.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.liuxian.inject.service.UserServiceImpl;
import com.liuxian.model.User;
import com.opensymphony.xwork2.ActionContext;

@Controller("userAction")
public class UserAction {
	private static final String HASH_ALGO = "MD5";
	
	private String id;
	private String username;
	private String password;
	private String role;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private Gson gson;
	
	public String add() {
		String hashedPassword = Util.createPasswordHash(HASH_ALGO,
				Util.BASE64_ENCODING, null, null, password);
		User user = new User();
		user.setUsername(username);
		user.setPassword(hashedPassword);
		user.setRole(role);
		user.setCreate_time(new Date());
		userService.add(user);
		return list();
	}
	
	public String update() {
		String hashedPassword = Util.createPasswordHash(HASH_ALGO,
				Util.BASE64_ENCODING, null, null, password);
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setUsername(username);

		if (null != password && password.length() != 0) {
			user.setPassword(hashedPassword);
		}
		user.setRole(role);
		user.setCreate_time(new Date());
		userService.update(user);
		return list();
	}
	
	public String remove() {
		userService.remove(Integer.parseInt(id));
		return list();
	}
	
	public String list() {
		List<User> userList = userService.list();
		ActionContext.getContext().put("userList", userList);
		return "userList";
	}
	
	public void get() {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		User user = userService.get(Integer.parseInt(id));
		response.setContentType("application/json; charset=utf-8");
		Writer out;
		try {
			out = response.getWriter();
			out.write(gson.toJson(user));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
