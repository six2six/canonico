package br.com.six2six.canonico.documento;

import junit.framework.Assert;

import org.junit.Test;

import br.com.six2six.canonico.localizacao.UF;

public class CarteiraHabilitacaoTest {
	
	@Test
	public void cnhValida() {
		Documento cnh = new CarteiraHabilitacao("0345786291772", UF.SP);
		Assert.assertTrue("CNH inválida", cnh.isValido());
		Assert.assertEquals("Formatação inválida", "0345786291772 - DETRAN/SP", cnh.getDisplayValue());
		Assert.assertEquals("Valor inválido", "0345786291772", cnh.getValue());
	}
	
	@Test
	public void deveRemoverCaracteresNaoNumericos() {
		Documento cnh = new CarteiraHabilitacao("A0345786291772/-U", UF.SP);
		Assert.assertTrue("CNH inválida", cnh.isValido());
		Assert.assertEquals("Formatação inválida", "0345786291772 - DETRAN/SP", cnh.getDisplayValue());
		Assert.assertEquals("Valor inválido", "0345786291772", cnh.getValue());
	}
	
	@Test(expected=DocumentoInvalido.class)
	public void deveGerarErroSeUFInvalida() {
		new CarteiraHabilitacao("A0345786291772/-U", null);
	}
	
	@Test(expected=DocumentoInvalido.class)
	public void deveGerarErroSeNumeroInvalido() {
		new CarteiraHabilitacao("", UF.SP);
	}
	
	@Test
	public void naoDeveGerarErroComDadosInvalidosSeLeniente() {
		Documento cnh = new CarteiraHabilitacao("", UF.SP, true);
		Assert.assertFalse("CNH inválida", cnh.isValido());
		Assert.assertEquals("Formatação inválida", " - DETRAN/SP", cnh.getDisplayValue());
		Assert.assertEquals("Valor inválido", "", cnh.getValue());
	}
	

}
