package com.stream.facade;

import javax.ejb.Local;
import com.stream.model.User;

@Local
public interface UserFacade {
	
	User findUserByEmail(String email);
	
}
