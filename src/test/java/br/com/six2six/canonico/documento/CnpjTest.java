package br.com.six2six.canonico.documento;

import junit.framework.Assert;

import org.junit.Test;

import br.com.six2six.canonico.documento.Cnpj;

public class CnpjTest {

	@Test
	public void cnpjValido() {
		Cnpj cnpj = new Cnpj("09786868000133");
		Assert.assertTrue("Cnpj inválido", cnpj.isValido());
		Assert.assertEquals("Formatação inválida", "09.786.868/0001-33", cnpj.getDisplayValue());
		Assert.assertEquals("Valor inválido", "09786868000133", cnpj.getValue());
	}
	
	@Test
	public void completarTamanhoCpfComZeros() {
		Cnpj cnpj = new Cnpj("9786868000133");
		Assert.assertTrue("Cnpj inválido", cnpj.isValido());
		Assert.assertEquals("Formatação inválida", "09.786.868/0001-33", cnpj.getDisplayValue());
		Assert.assertEquals("Valor inválido", "09786868000133", cnpj.getValue());
	}

	@Test
	public void removerCaracteresFormatacao() {
		Cnpj cnpj = new Cnpj("09.786.868/0001-33");
		Assert.assertTrue("Cnpj inválido", cnpj.isValido());
		Assert.assertEquals("Formatação inválida", "09.786.868/0001-33", cnpj.getDisplayValue());
		Assert.assertEquals("Valor inválido", "09786868000133", cnpj.getValue());
	}

	@Test(expected=DocumentoInvalido.class)
	public void cnpjInvalidoNaoLenienteDeveGerarErro() {
		new Cpf("09.786.868/0001-34");
	}

	@Test
	public void cpfInvalidoNaoLenienteNaoPodeSeDizerValido() {
		Cnpj cnpj = new Cnpj("09.786.868/0001-34", true);
		Assert.assertFalse("Cnpj inválido", cnpj.isValido());
		Assert.assertEquals("Formatação inválida", "09.786.868/0001-34", cnpj.getDisplayValue());
		Assert.assertEquals("Valor inválido", "09786868000134", cnpj.getValue());
	}
}
