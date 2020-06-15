package com.martinez.ejercicio.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.martinez.ejercicio.models.entities.Pelicula;

public interface IPelicula extends CrudRepository<Pelicula,Integer>{

}
