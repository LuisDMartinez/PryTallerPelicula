package com.martinez.ejercicio.models.services;

import java.util.List;


import com.martinez.ejercicio.models.entities.Pelicula;

public interface IPeliculaService {

	public void save(Pelicula a);
	public Pelicula findById(Integer id);
	public void delete(Integer id);
	public List<Pelicula> findAll();
}
