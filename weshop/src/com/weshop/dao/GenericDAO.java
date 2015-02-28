package com.weshop.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public class GenericDAO<T> {

	private Class<T> entity;
	
	private static final String UNIT_NAME ="Weshop";
	
	@PersistenceContext(unitName = UNIT_NAME)
	private EntityManager em;
	
	public GenericDAO(Class<T> entity){
		this.entity = entity;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getResultList(String classe){
		String sql = "select c FROM "+classe+ " c";
		Query q = em.createQuery(sql);
		return q.getResultList();
	}
	
	public void save(T t){
		em.persist(t);
	}
	
	public void delete(Object id, Class<T> classe){
		T t = em.getReference(classe, id);
		em.remove(t);
	}
	
	public T updade(T t){
		return em.merge(t);
	}
	
	public T find(Long id){
		return em.find(entity, id);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findAll(){
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entity));
		return em.createQuery(cq).getResultList();
	}
	
	@SuppressWarnings("unchecked")
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
        T result = null;
 
        try {
            Query query = em.createNamedQuery(namedQuery);
 
            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }
 
            result = (T) query.getSingleResult();
 
        } catch (Exception e) {
            System.out.println("Erro enquanto executando query: " + e.getMessage());
            e.printStackTrace();
        }
 
        return result;
    }
 
    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
 
        for (Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
}
