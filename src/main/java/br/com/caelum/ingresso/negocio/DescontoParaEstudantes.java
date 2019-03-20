package br.com.caelum.ingresso.negocio;

import java.math.BigDecimal;

public class DescontoParaEstudantes implements Desconto {

	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		// TODO Auto-generated method stub
		return precoOriginal;
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return "DescontoEstudantes";
	}

}
