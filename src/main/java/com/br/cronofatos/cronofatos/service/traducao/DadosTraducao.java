package com.br.cronofatos.cronofatos.service.traducao;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DadosTraducao(@JsonAlias (value = "responseData") DadosResposta dadosResposta) {
	
	public DadosResposta dadosResposta() {
		
		return dadosResposta;
	}
	

}
