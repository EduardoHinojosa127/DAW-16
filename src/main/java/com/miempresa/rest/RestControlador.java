package com.miempresa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miempresa.interfaceServicio.IEmpleadoServicio;
import com.miempresa.modelo.Empleado;

@RestController
@RequestMapping("/api/empleados")
public class RestControlador {
	@Autowired
	private IEmpleadoServicio repo;
	
	@GetMapping("/listar")
	public List<Empleado> listar(){
		return repo.listar();
	}
	
	@PostMapping("/insertar")
	public void insertar(@RequestBody Empleado p) {
		repo.guardar(p);
	}
	@PutMapping("/editar")
	public void editar(@RequestBody Empleado p) {
		repo.guardar(p);
	}
	@DeleteMapping(value = "/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		repo.borrar(id);
	}
}
