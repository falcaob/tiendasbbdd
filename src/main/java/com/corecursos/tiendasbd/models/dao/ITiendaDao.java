package com.corecursos.tiendasbd.models.dao;

import java.util.List;

import com.corecursos.tiendasbd.model.entity.Tienda;

public interface ITiendaDao {
	
	List<Tienda> findAll();
	void save(Tienda cliente);
	Tienda findOne(Long id);
	Tienda save(Long id);
	void delete(Long id);


}
