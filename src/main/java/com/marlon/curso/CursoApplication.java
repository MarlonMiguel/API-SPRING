package com.marlon.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marlon.curso.domain.Categoria;
import com.marlon.curso.domain.Cidade;
import com.marlon.curso.domain.Estado;
import com.marlon.curso.domain.Produto;
import com.marlon.curso.repositories.CategoriaRepository;
import com.marlon.curso.repositories.CidadeRepository;
import com.marlon.curso.repositories.EstadoRepository;
import com.marlon.curso.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository repo;
	@Autowired
	private ProdutoRepository repo1;
	@Autowired
	private CidadeRepository repo2;
	@Autowired
	private EstadoRepository repo3;

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria("Informatica");
		Categoria cat2 = new Categoria("Depósito");
		
		Produto pro1 = new Produto(null, "Computador", 2000.00);
		Produto pro2 = new Produto(null, "Impressora", 300.00);
		Produto pro3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(pro1,pro2,pro3));
		cat2.getProdutos().addAll(Arrays.asList(pro2));
		
		pro1.getCategorias().addAll(Arrays.asList(cat1));
		pro2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		pro3.getCategorias().addAll(Arrays.asList(cat1));
		
		repo.saveAll(Arrays.asList(cat1, cat2));
		repo1.saveAll(Arrays.asList(pro1, pro2, pro3));
		
		Estado est1 = new Estado(null, "Minas Gerais", "MG");
		Estado est2 = new Estado(null, "São Paulo", "SP");
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		repo3.saveAll(Arrays.asList(est1,est2));
		repo2.saveAll(Arrays.asList(c1,c2,c3));
	}

}
