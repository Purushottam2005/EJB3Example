package com.stream.facade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.stream.dao.UserDAO;
import com.stream.model.User;

@Stateless
public class UserFacadeImpl implements UserFacade {
	
	 @EJB
	 private UserDAO userDAO;

	 public User findUserByEmail(String email) {
	  return userDAO.findUserByEmail(email);
	 }
	 
}
