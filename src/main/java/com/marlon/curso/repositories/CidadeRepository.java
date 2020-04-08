package com.marlon.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marlon.curso.domain.Cidade;
import com.marlon.curso.domain.Produto;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
