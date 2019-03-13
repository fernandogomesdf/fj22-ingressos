package br.com.caelum.ingresso.validation;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import br.com.caelum.ingresso.gerenciador.GerenciadorDeSessao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessaoTest {
	
	@Test
	public void deveAdicionarSeListaDaSessaoEstiverVazia() {
		List<Sessao> sessoes = Collections.emptyList();
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		
		Filme filme = new Filme("Rogue One",Duration.ofMinutes(120),"SCI-FI", BigDecimal.ONE);
	}

}
