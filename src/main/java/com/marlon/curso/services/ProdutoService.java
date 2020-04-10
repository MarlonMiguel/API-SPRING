package com.marlon.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marlon.curso.domain.Produto;
import com.marlon.curso.repositories.ProdutoRepository;
import com.marlon.curso.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;
	
	public Produto buscar(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException	 (
				"Objeto não encontrado! Id:"+id+", Tipo: "+Produto.class.getName()));
	}
}
