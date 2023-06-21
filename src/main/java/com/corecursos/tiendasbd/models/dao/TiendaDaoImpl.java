package com.corecursos.tiendasbd.models.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.corecursos.tiendasbd.model.entity.Tienda;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TiendaDaoImpl implements ITiendaDao{
	
		@PersistenceContext
		private EntityManager em;

		//@Transactional(readOnly = true)
		@Override
		public List<Tienda> findAll() {

			return em.createQuery("from Tienda", Tienda.class).getResultList();
		}

		//@Transactional
		public void save(Tienda tienda) {
			if (tienda.getId() != null && tienda.getId() > 0)
				// Actualiza
				em.merge(tienda);
			else
				// Inserta
				em.persist(tienda);
		}

		@Override
		//@Transactional(readOnly = true)
		public Tienda findOne(Long id) {
			return em.find(Tienda.class, id);
		}
		
		
		@Override
		//@Transactional
		public void delete(Long id) {
			em.remove(findOne(id));
		}

		@Override
		public Tienda save(Long id) {
			return em.find(Tienda.class, id);
		}
	
}
