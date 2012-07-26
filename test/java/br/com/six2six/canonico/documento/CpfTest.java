package br.com.six2six.canonico.documento;

import junit.framework.Assert;

import org.junit.Test;

public class CpfTest {

	@Test
	public void cpfValido() {
		Cpf cpf = new Cpf("13911708300");
		Assert.assertTrue("Cpf inválido", cpf.isValido());
		Assert.assertEquals("Formatação inválida", "139.117.083-00", cpf.getDisplayValue());
		Assert.assertEquals("Valor inválido", "13911708300", cpf.getValue());
	}
	
	@Test
	public void completarTamanhoCpfComZeros() {
		Cpf cpf = new Cpf("6650167860");
		Assert.assertTrue("Cpf inválido", cpf.isValido());
		Assert.assertEquals("Formatação inválida", "066.501.678-60", cpf.getDisplayValue());
		Assert.assertEquals("Valor inválido", "06650167860", cpf.getValue());
	}
	
	@Test
	public void removerCaracteresFormatacao() {
		Cpf cpf = new Cpf("431.327.178-35");
		Assert.assertTrue("Cpf inválido", cpf.isValido());
		Assert.assertEquals("Formatação inválida", "431.327.178-35", cpf.getDisplayValue());
		Assert.assertEquals("Valor inválido", "43132717835", cpf.getValue());
	}
	
	@Test(expected=DocumentoInvalido.class)
	public void cpfInvalidoNaoLenienteDeveGerarErro() {
		new Cpf("13911708301");
	}
	
	@Test
	public void cpfInvalidoNaoLenienteNaoPodeSeDizerValido() {
		Cpf cpf = new Cpf("13911708301", true);
		Assert.assertFalse("Cpf inválido", cpf.isValido());
		Assert.assertEquals("Formatação inválida", "139.117.083-01", cpf.getDisplayValue());
		Assert.assertEquals("Valor inválido", "13911708301", cpf.getValue());
	}	
	
}
