package com.example.blogpessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogpessoal.model.Postagem;
import com.example.blogpessoal.repository.PostagemRepository;


@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
		@Autowired
		private PostagemRepository postagemRepository;
	
		@GetMapping
		public ResponseEntity <List<Postagem>> getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
		}
	
		@GetMapping("/{id}")
		public ResponseEntity <Postagem> getById(@PathVariable Long id){
		return postagemRepository.findById(id) // função lambida? -- perguntar
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
		
		// select * from tb_postagens where id = id
		}
		
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity <List<Postagem>> getByTitulo(@PathVariable String titulo){
			return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
			
			// select *from tb_postagens where titulo like %titulo%
		}
		
		@PostMapping
		public ResponseEntity <Postagem> postPostagem(@Valid @RequestBody Postagem postagem){
			return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
		}
		// JSON 
		@PutMapping
		public ResponseEntity <Postagem> putPostagem(@Valid @RequestBody Postagem postagem){
			return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
		}
		
		@DeleteMapping("/{id}")
		public void deletePostagem(@PathVariable Long id){
			
			postagemRepository.deleteById(id);
		}
}
