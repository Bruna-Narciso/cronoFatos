package com.br.cronofatos.cronofatos.model;

import com.br.cronofatos.cronofatos.service.traducao.ConsultaMyMemory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "curiosidades")

public class Curiosidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	
	private Integer ano;
	private String texto;
	
	@OneToOne(mappedBy = "curiosidade")
    private Interacao interacao;

	public Curiosidade() {}
	
	public Curiosidade(DadosCuriosidade dados) {
		this.ano = dados.ano();
		this.texto = ConsultaMyMemory.obterTraducao(dados.texto().trim());
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Interacao getInteracao() {
		return interacao;
	}

	public void setInteracao(Interacao interacao) {
		this.interacao = interacao;
	}

	@Override
	public String toString() {
		return "Curiosidade [ano=" + ano + ", texto=" + texto + "]";
	}


	
}
