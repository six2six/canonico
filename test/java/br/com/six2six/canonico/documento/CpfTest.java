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
	
}
