package com.corecursos.tiendasbd.services;

import java.util.List;

import com.corecursos.tiendasbd.model.entity.Tienda;


public interface ITiendasService {
	
	List<Tienda> findAll();
	void save(Tienda tienda);
	Tienda findOne(Long id);
	Tienda save(Long id);
	void delete(Long id);

}
