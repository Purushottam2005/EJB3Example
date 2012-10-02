package com.stream.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.Query;

public interface GenericDAO<T> {
	
	void save(T t);
	void delete(T t);
	T update(T t);
	T find(int entityId);
	List<T> findAll();
	T findOneResult(String nameQuery, Map<String, Object> parameters);
	void populateQueryParameters(Query query, Map<String, Object> parameters);
	
}
