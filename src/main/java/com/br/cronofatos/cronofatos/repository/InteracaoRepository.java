package com.br.cronofatos.cronofatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cronofatos.cronofatos.model.Curiosidade;
import com.br.cronofatos.cronofatos.model.DadosCuriosidade;
import com.br.cronofatos.cronofatos.model.Interacao;
import com.br.cronofatos.cronofatos.model.Usuario;

public interface InteracaoRepository extends JpaRepository<Interacao, Long>{


	void save(DadosCuriosidade dados);

	

}
