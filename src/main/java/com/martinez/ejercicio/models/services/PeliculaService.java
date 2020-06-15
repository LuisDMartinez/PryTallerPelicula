package com.martinez.ejercicio.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martinez.ejercicio.models.dao.IPelicula;
import com.martinez.ejercicio.models.entities.Pelicula;

@Service
public class PeliculaService implements IPeliculaService {

	@Autowired
	private IPelicula dao;
	@Override
	@Transactional
	public void save(Pelicula a) {
		// TODO Auto-generated method stub
		dao.save(a);
	}

	@Override
	@Transactional
	public Pelicula findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Pelicula> findAll() {
		// TODO Auto-generated method stub
		return (List<Pelicula>) dao.findAll();
	}

}
