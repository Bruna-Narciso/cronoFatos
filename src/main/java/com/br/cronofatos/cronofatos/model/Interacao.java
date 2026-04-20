package com.br.cronofatos.cronofatos.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name= "interacao")
public class Interacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String status_conhecimento;
	private boolean gostou;
	private boolean favorito;
	
	@Temporal(TemporalType.TIMESTAMP)    //(TemporalType.TIMESTAMP)
    private Date data_interacao;
	
	@OneToOne
	@JoinColumn(name = "curiosidade_id")
	private Curiosidade curiosidade;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@PrePersist
    public void prePersist() {
        this.data_interacao = new Date(); // Data salva automaticamente
    }
	
	
	 public Interacao() {} 
	    
	    public Interacao(String status_conhecimento, boolean gostou, boolean favorito) {
	        this.status_conhecimento = status_conhecimento;
	        this.gostou = gostou;
	        this.favorito = favorito;
	    }


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getStatus_conhecimento() {
			return status_conhecimento;
		}


		public void setStatus_conhecimento(String status_conhecimento) {
			this.status_conhecimento = status_conhecimento;
		}


		public boolean isGostou() {
			return gostou;
		}


		public void setGostou(boolean gostou) {
			this.gostou = gostou;
		}


		public boolean isFavorito() {
			return favorito;
		}


		public void setFavorito(boolean favorito) {
			this.favorito = favorito;
		}


		public Date getData_interacao() {
			return data_interacao;
		}


		public void setData_interacao(Date data_interacao) {
			this.data_interacao = data_interacao;
		}


		public Curiosidade getCuriosidade() {
			return curiosidade;
		}


		public void setCuriosidade(Curiosidade curiosidade) {
			this.curiosidade = curiosidade;
		}


		public Usuario getUsuario() {
			return usuario;
		}


		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
	    


	
	
	
}


