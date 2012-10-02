package com.stream.facade;

import java.util.List;
import javax.ejb.Local;
import com.stream.model.Dog;

@Local
public interface DogFacade {
	
	abstract void save(Dog dog);
	abstract Dog update(Dog dog);
	abstract void delete(Dog dog);
	abstract Dog find(int entityID);
	abstract List<Dog> findAll();
	
}
