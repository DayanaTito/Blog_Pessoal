package com.example.blogpessoal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.blogpessoal.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// metodo que busca um usuario pelo seu usuario(email)

	public Optional<Usuario> findByUsuario(String usuario);

	// Método criado para a Sessão de testes
	public List<Usuario> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
