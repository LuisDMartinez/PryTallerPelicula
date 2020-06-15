package com.martinez.ejercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.martinez.ejercicio.models.entities.Pelicula;
import com.martinez.ejercicio.models.services.IPeliculaService;


@Controller
@RequestMapping(value="/pelicula") 
public class PeliculaController {

	@Autowired
	private IPeliculaService srvPelicula;
	
	@GetMapping(value="/create")//https://localhost:8080/alumno/create
	public String create(Model model) {
		Pelicula pelicula = new Pelicula();

		model.addAttribute("title","Registro de nueva Película");
		model.addAttribute("pelicula", pelicula);
		return "pelicula/form";
	}
	
	@GetMapping(value="/retrieve/{id}")//https://localhost:8080/alumno/retrieve
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Pelicula pelicula = srvPelicula.findById(id);//consulta
		model.addAttribute("pelicula", pelicula);
		return "pelicula/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Pelicula pelicula = srvPelicula.findById(id);
		model.addAttribute("pelicula", pelicula);
		//el metodo toString se ejecuta por default
		model.addAttribute("title","Actualizando el registro de: "+ pelicula.toString());
		return "pelicula/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model) {
		this.srvPelicula.delete(id);
		//despues de borrar se hace un redirect a una accion por invocar
		return "redirect:/pelicula/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Pelicula> peliculas = this.srvPelicula.findAll();
		
		model.addAttribute("peliculas", peliculas);
		
		model.addAttribute("title","Listado de películas");
		return "pelicula/list";
	}
	
	@PostMapping(value="/save")//https://localhost:8080/alumno/create
	public String save(Pelicula pelicula, Model model) {
		this.srvPelicula.save(pelicula);
		return "redirect:/pelicula/list";
	}
}
