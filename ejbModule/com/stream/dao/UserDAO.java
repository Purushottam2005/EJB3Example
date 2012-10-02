package com.stream.dao;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import com.stream.model.User;

@Stateless
public class UserDAO extends GenericDAOImpl<User> {
	
	public UserDAO() {
		super(User.class);
	}

	public User findUserByEmail(String email) {
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);

		return super.findOneResult(User.FIND_BY_EMAIL, parameters);
	}
	
}
