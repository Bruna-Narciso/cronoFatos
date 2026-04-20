package com.br.cronofatos.cronofatos.service;

public interface IConverteDados {
	
	<T> T obterDados(String json, Class <T> classe);
}
 