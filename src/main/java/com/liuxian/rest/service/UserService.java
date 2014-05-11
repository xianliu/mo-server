package com.liuxian.rest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.jboss.security.auth.spi.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.liuxian.dao.UserDao;
import com.liuxian.model.User;
import com.liuxian.util.JsonP;

@Controller
public class UserService {
	@Autowired
	private JsonP jsonP;
	
	private User user;
	
	private static final String HASH_ALGO = "MD5";

	@Resource(name = "userDao")
	private UserDao userDao;

	@RequestMapping(value = "/api/login.json", method = RequestMethod.GET)
	public void login(
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam(required = false, value = "callback", defaultValue = "callback") String cb,
			HttpServletResponse response) {
		
		String hashedPassword = Util.createPasswordHash(HASH_ALGO,
				Util.BASE64_ENCODING, null, null, password);
		
		String accessToken = Util.createPasswordHash(HASH_ALGO,
				Util.BASE64_ENCODING, null, null, username + password);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		List<User> userList = userDao.findByHQL("where c.username=:username", map);
		
		if(checkPassword(userList, hashedPassword)) {
			jsonP.buildJsonp(accessToken, cb, response);
		} else {
			ErrorObject error = new ErrorObject();
			error.setCode(503);
			error.setMessage("login failure");
			jsonP.buildJsonp(error, cb, response);
		}
	}
	
	private boolean checkPassword(List<User> userList, String hashedPassword) {
		if (userList != null && userList.size() > 0) {
			user = userList.get(0);
			String realPassword = user.getPassword();
			if(hashedPassword.equals(realPassword)) {
				return true;
			}  
		}
		return false;
	}

}