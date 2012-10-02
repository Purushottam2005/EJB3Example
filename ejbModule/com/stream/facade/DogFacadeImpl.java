package com.stream.facade;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.stream.model.Dog;
import com.stream.dao.DogDAO;

@Stateless
public class DogFacadeImpl implements DogFacade {

	@EJB
	private DogDAO dogDAO;

	@Override
	public void save(Dog dog) {
		isDogWithAllData(dog);
		dogDAO.save(dog);
	}

	@Override
	public Dog update(Dog dog) {
		isDogWithAllData(dog);
		return dogDAO.update(dog);
	}

	@Override
	public void delete(Dog dog) {
		dogDAO.delete(dog);
	}

	@Override
	public Dog find(int entityID) {
		return dogDAO.find(entityID);
	}

	@Override
	public List<Dog> findAll() {
		return dogDAO.findAll();
	}

	private void isDogWithAllData(Dog dog) {
		
	  boolean hasError = false;

	  if(dog == null){
	   hasError = true;
	  }

	  if (dog.getName() == null || "".equals(dog.getName().trim())){
	   hasError = true;
	  }

	  if(dog.getWeight() <= 0){
	   hasError = true;
	  }

	  if (hasError){
	   throw new IllegalArgumentException("The dog is missing data. Check the name and weight, they should have value.");
	  }
	  
	 }
	
}
