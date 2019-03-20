package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

public class Ingresso {
	
	private Sessao sessao;
	
	private BigDecimal preco;
	
	private Lugar lugar;
	
	public Ingresso(Sessao sessao, TipoDeIngresso tipoIngresso, Lugar lugar) {
		this.sessao = sessao;
		this.preco = tipoIngresso.aplicaDesconto(sessao.getPreco());
		this.lugar = lugar;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}
}
