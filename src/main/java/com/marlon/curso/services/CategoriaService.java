package com.marlon.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marlon.curso.domain.Categoria;
import com.marlon.curso.repositories.CategoriaRepository;
import com.marlon.curso.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id){
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException	 (
				"Objeto não encontrado! Id:"+id+", Tipo: "+Categoria.class.getName()));
	}
}
