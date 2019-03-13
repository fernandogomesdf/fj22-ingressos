package br.com.caelum.ingresso.validation;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.gerenciador.GerenciadorDeSessao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessaoTest {
	
	@Test
	public void deveAdicionarSeListaDaSessaoEstiverVazia() {
		List<Sessao> sessoes = Collections.emptyList();
		GerenciadorDeSessao gerenciador = new GerenciadorDeSessao(sessoes);
		
		Filme filme = new Filme("Rogue One",Duration.ofMinutes(120),"SCI-FI", BigDecimal.ONE);
		LocalTime horario = LocalTime.parse("10:00:00");
		Sala sala = new Sala("");
		
		Sessao sessao = new Sessao(horario, sala, filme);
		boolean cabe = gerenciador.cabe(sessao);
		
		Assert.assertTrue(cabe);
	}

}
