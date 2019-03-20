package br.com.caelum.ingresso.negocio;

import java.math.BigDecimal;

public interface Desconto {
	BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal);
	String getDescricao();
}
