package com.br.cronofatos.cronofatos.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nome;
	private String email;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Interacao> interacoes = new ArrayList<>();

	
	public Usuario(){
		
	}
	
	public Usuario( String nome, String email) {
		this.nome = nome;
		this.email = email;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Interacao> getInteracoes() {
		return interacoes;
	}


	public void setInteracoes(List<Interacao> interacoes) {
		this.interacoes = interacoes;
	}

	public void addInteracao(Interacao interacao) {
        interacoes.add(interacao);
        interacao.setUsuario(this);
    }


}