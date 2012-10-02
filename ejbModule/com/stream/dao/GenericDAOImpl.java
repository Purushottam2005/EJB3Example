package com.stream.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	private final static String UNIT_NAME = "CrudPU";

	@PersistenceContext(unitName = UNIT_NAME)
	private EntityManager em;
	private Class<T> entityClass;

	public GenericDAOImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void save(T entity) {
		em.persist(entity);
	}

	@Override
	public void delete(T entity) {
		T entityToBeRemoved = em.merge(entity);
	}

	@Override
	public T update(T entity) {
		return em.merge(entity);
	}

	@Override
	public T find(int entityId) {
		return em.find(entityClass, entityId);
	}
	
	// Using the unchecked because JPA does not have a
	// em.getCriteriaBuilder().createQuery()<T> method
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List findAll() {
		  CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		  cq.select(cq.from(entityClass));
		  return em.createQuery(cq).getResultList();
	}

	// Using the unchecked because JPA does not have a
	// ery.getSingleResult()<T> method
	@SuppressWarnings("unchecked")
	@Override
	public T findOneResult(String namedQuery, Map<String, Object> parameters) {
		
		  T result = null;

		  try {
			  
		   Query query = em.createNamedQuery(namedQuery);

		   // Method that will populate parameters if they are passed not null and empty
		   if (parameters != null && !parameters.isEmpty()) {
		    populateQueryParameters(query, parameters);
		   }

		   result = (T) query.getSingleResult();

		  } catch (Exception e) {
		   System.out.println("Error while running query: " + e.getMessage());
		   e.printStackTrace();
		  }

		  return result;
	}

	@Override
	public void populateQueryParameters(Query query, Map<String, Object> parameters) {
		
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

	}

}
