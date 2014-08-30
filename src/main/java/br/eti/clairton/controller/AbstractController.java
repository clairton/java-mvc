package br.eti.clairton.controller;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.eti.clairton.model.AbstractModel;

public abstract class AbstractController<T extends AbstractModel> implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	protected EntityManager em;

	protected T model;

	public T salvar(T model) {
		em.persist(model);
		return model;
	}

	public T alterar(T model) {
		return em.merge(model);
	}

	public void remover(T model) {
		em.remove(em.find(model.getClass(), model.getId()));
	}

	public List<T> listar() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		@SuppressWarnings("unchecked")
		Class<T> klazz = (Class<T>) novo().getClass();
		CriteriaQuery<T> cq = cb.createQuery(klazz);
		Root<T> rootEntry = cq.from(klazz);
		CriteriaQuery<T> all = cq.select(rootEntry);
		TypedQuery<T> allQuery = em.createQuery(all);
		return allQuery.getResultList();
	}

	public abstract T novo();
}
