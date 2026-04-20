package com.br.cronofatos.cronofatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cronofatos.cronofatos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//List<Usuario> findByEmail(String email);
	List<Usuario> findByEmail(String email);
	void save(List<Usuario> usuarios);
	boolean existsByEmail(String email);

}
