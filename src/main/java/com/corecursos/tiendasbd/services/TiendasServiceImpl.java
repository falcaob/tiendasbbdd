package com.corecursos.tiendasbd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.corecursos.tiendasbd.model.entity.Tienda;
import com.corecursos.tiendasbd.models.dao.ITiendaDao;

@Service
public class TiendasServiceImpl implements ITiendasService{
	
	@Autowired
	ITiendaDao tiendaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tienda> findAll() {
		return tiendaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Tienda tienda) {
		tiendaDao.save(tienda);
	}

	@Override
	@Transactional(readOnly = true)
	public Tienda findOne(Long id) {
		return tiendaDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		tiendaDao.delete(id);
	}

	@Override
	@Transactional
	public Tienda save(Long id) {
		return tiendaDao.findOne(id);
	}

}
