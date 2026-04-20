package com.br.cronofatos.cronofatos.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosCuriosidade(@JsonAlias("number") Integer ano, @JsonAlias("text")  String texto) {

	public DadosCuriosidade(Curiosidade curiosidade) {
        this(curiosidade.getAno(), curiosidade.getTexto());
    }
    
    
    
}


