package com.br.cronofatos.cronofatos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.cronofatos.cronofatos.controller.Principal;
import com.br.cronofatos.cronofatos.repository.CuriosidadeRepository;
import com.br.cronofatos.cronofatos.repository.InteracaoRepository;
import com.br.cronofatos.cronofatos.repository.UsuarioRepository;

@SpringBootApplication
public class CronofatosApplication implements CommandLineRunner {
	
	@Autowired
	private InteracaoRepository repositorio;
	@Autowired
	private UsuarioRepository usuarioRepositorio;
	@Autowired
	private CuriosidadeRepository curiosidadeRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(CronofatosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio, usuarioRepositorio, curiosidadeRepositorio);
		principal.ExibirMenu();
		
	}

}
