package com.br.cronofatos.cronofatos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.br.cronofatos.cronofatos.model.Curiosidade;
import com.br.cronofatos.cronofatos.model.DadosCuriosidade;
import com.br.cronofatos.cronofatos.model.Usuario;
import com.br.cronofatos.cronofatos.repository.CuriosidadeRepository;
import com.br.cronofatos.cronofatos.repository.InteracaoRepository;
import com.br.cronofatos.cronofatos.repository.UsuarioRepository;
import com.br.cronofatos.cronofatos.service.ConsumoApi;
import com.br.cronofatos.cronofatos.service.ConverteDados;


public class Principal {
	
	Scanner leitura = new Scanner(System.in);

	ConsumoApi consumo = new ConsumoApi();
	ConverteDados converte = new ConverteDados();
	private final String ENDERECO = "http://numbersapi.com/random/year?json";
	private InteracaoRepository repositorio;
	private UsuarioRepository usuarioRepositorio;
	private CuriosidadeRepository curiosidadeRepositorio;

	private List<Curiosidade> curiosidade = new ArrayList<>();

	private List<Usuario> usuario = new ArrayList<>();
	
	
	public Principal(InteracaoRepository repositorio, UsuarioRepository usuarioRepositorio, CuriosidadeRepository curiosidadeRepositorio) {
		this.repositorio =  repositorio;
		this.usuarioRepositorio = usuarioRepositorio;
		this.curiosidadeRepositorio = curiosidadeRepositorio;
	}
	

	public void ExibirMenu() {
		var opcao = -1;
		
		
		while(opcao!= 0) {
			System.out.println("Seja bem-vindo aos fatos históricos. Digite: ");
			
		    String menu = """
		    		1- Fazer Registro
		    		2- Fazer Login
		    		0- Sair
		    		
		    		
		    		""";
		    
		    System.out.println(menu);
		    opcao = leitura.nextInt();
		    leitura.nextLine();
			
			
		   switch(opcao) {
		   case 1:
			   fazerRegistro();
			break;
		   
		   case 2:
			   fazerLogin();
			  break;
			 
		   case 0:
			   System.out.println("**Saindo**");
			 break;
		   
			 default:
				 System.out.println("Opção inválida!");
		   
		   }
			
			
		}
	}

	
	
	private void fazerRegistro() {
		System.out.println("Informe seu nome: ");
		String nome = leitura.nextLine().trim();
		
		System.out.println("Informe seu email");
		String email = leitura.nextLine().trim();
		
		if(email.isEmpty()) {
			System.out.println("Email não pode estar vazio");
			return;
		}
		
		
		if(usuarioRepositorio.existsByEmail(email)) {
			System.out.println("Email já existe, por favor faça login ou use outro email");
		}else {
			
			Usuario usuario = new Usuario(nome, email);
			usuarioRepositorio.save(usuario);
			
			System.out.println("Usuário salvo!! Por favor faça login.");
			
			
		}
		
		
	}
	
	private void fazerLogin() {
		System.out.println("Digite o seu email");
		var email = leitura.nextLine().trim();
		List<Usuario> usuarioProcura = usuarioRepositorio.findByEmail(email);

		if (usuarioRepositorio.findByEmail(email).isEmpty()) {
			System.out.println("Lista vazia");
		} else {
			usuarioProcura.forEach(u -> System.out.println("Nome: " + u.getNome()));

			//System.out.println("Aperte 1 para gerar uma curiosidade e aperte 2 para sair");

			int opcao2;
			do {
				
				System.out.println("1- Gerar curiosidade   2- Pesquisar curiosidade passada 3- Sair");
				opcao2 = leitura.nextInt();
				leitura.nextLine();

				switch (opcao2) {

				case 1:
					gerarCuriosidade();
					break;

				case 2:
					pesquisarCuriosidadePassada();
					break;
					
				case 3:
					System.out.println("***Saindo*** ");
					break;

				default:
					System.out.println("opção inválida");

				}

			} while (opcao2 != 3);

		}
	}
	
	private void pesquisarCuriosidadePassada() {
		
		
		curiosidade = curiosidadeRepositorio.findAll();
		
		if(!curiosidade.isEmpty()) {
			Curiosidade aleatoria = curiosidade.get(new Random().nextInt(curiosidade.size()));
			System.out.println("Curiosidade Aleatória: " + aleatoria);
		}else {
			System.out.println("Banco de dados vazio");
		}
	
		
		
	}


	private DadosCuriosidade getDadosCuriosidade() {
		var json = consumo.obterDados(ENDERECO);
		DadosCuriosidade dados = converte.obterDados(json, DadosCuriosidade.class);	
	
		return dados;
	
	}
	
	
	  private void gerarCuriosidade() {
		  
		  DadosCuriosidade dados = getDadosCuriosidade();
		  Curiosidade curiosidade = new Curiosidade(dados);
		  //System.out.println(dados);
		  
		  System.out.println("Curiosidade[ano=" + curiosidade.getAno() + ", texto=" + curiosidade.getTexto() + "]");
		  curiosidadeRepositorio.save(curiosidade);
		  System.out.println("Curiosidade  salva com sucesso");
		
	}
}
