package com.example.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.blogpessoal.model.Postagem;

@Repository // tipo reposito 
public interface PostagemRepository extends JpaRepository <Postagem, Long> {
	
	public List <Postagem> findAllByTituloContainingIgnoreCase (@Param("titulo")String titulo);
	
	//@Param - está dizendo que o titulo passa a ser um parametro de consulta
}	
