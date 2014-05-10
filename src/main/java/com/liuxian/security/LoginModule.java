package com.liuxian.security;

import java.security.acl.Group;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.Util;

import org.jboss.security.auth.spi.UsernamePasswordLoginModule;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liuxian.dao.UserDao;
import com.liuxian.model.User;

public class LoginModule extends UsernamePasswordLoginModule {
	private UserDao userDao;

	private static final String HASH_ALGO = "MD5";

	private String username;
	private char[] credential;
	private String password;
	private ClassPathXmlApplicationContext context;
	private User user;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	protected String getUsersPassword() throws LoginException {
		username = super.getUsername();
		credential = (char[]) super.getCredentials();
		password = new String(credential);

		BeanFactory factory = getBeanFacroty();
		userDao = (UserDao) factory.getBean("userDao");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		List<User> userList = userDao.findByHQL("where c.username=:username",
				map);
		context.close();
		if (userList != null && userList.size() > 0) {
			user = userList.get(0);
			return user.getPassword();
		}

		return null;
	}

	@Override
	protected Group[] getRoleSets() throws LoginException {
		Group roles = new SimpleGroup("Roles");
		roles.addMember(new SimplePrincipal(user.getRole()));
		return new Group[] { roles };
	}

	private BeanFactory getBeanFacroty() {
		context = new ClassPathXmlApplicationContext(new String[] {
				"spring.xml", "spring-hibernate.xml" });
		BeanFactory factory = context.getBeanFactory();
		return factory;
	}

}
