package com.example.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blogpessoal.model.Postagem;

@Repository // tipo reposito 
public interface PostagemRepository extends JpaRepository <Postagem, Long> {

}
