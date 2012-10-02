package com.stream.dao;

import javax.ejb.Stateless;
import com.stream.model.Dog;

@Stateless
public class DogDAO extends GenericDAOImpl<Dog> {
	
	public DogDAO() {
		super(Dog.class);
	}
	
}
