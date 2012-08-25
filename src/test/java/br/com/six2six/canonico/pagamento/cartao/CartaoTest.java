package br.com.six2six.canonico.pagamento.cartao;

import static br.com.six2six.canonico.pagamento.cartao.Bandeira.MASTERCARD;
import static br.com.six2six.canonico.pagamento.cartao.Cartao.CartaoBuilder.novoCartaoCredito;
import static br.com.six2six.canonico.pagamento.cartao.Cartao.CartaoBuilder.novoCartaoDebito;
import static br.com.six2six.canonico.pagamento.cartao.Tipo.CREDITO;
import static br.com.six2six.canonico.pagamento.cartao.Tipo.DEBITO;
import junit.framework.Assert;

import org.junit.Test;

public class CartaoTest {

	@Test
	public void criarCartaoCredito() {
		Cartao cartao = novoCartaoCredito(MASTERCARD)
			.para("JOHN F. DOE")
			.comNumero("173 5828 1523 9055")
			.vencendoEm("06/2014")
			.codigoSeguranca(123L)
			.build();
		
		Assert.assertEquals("Bandeira incorreta", MASTERCARD, cartao.getBandeira());
		Assert.assertEquals("Tipo incorreto", CREDITO, cartao.getTipo());
		Assert.assertEquals("Titular incorreto", "JOHN F. DOE", cartao.getTitular());
		Assert.assertEquals("Validade incorreta", Validade.from("06/2014"), cartao.getValidade());
		Assert.assertEquals("Codigo segurança incorreto", new Long(123), cartao.getCodigoSeguranca());
	}
	
	@Test
	public void criarCartaoDebito() {
		Cartao cartao = novoCartaoDebito(MASTERCARD)
			.para("JOHN F. DOE")
			.comNumero("173 5828 1523 9055")
			.vencendoEm("06/2014")
			.codigoSeguranca(123L)
			.build();
		
		Assert.assertEquals("Bandeira incorreta", MASTERCARD, cartao.getBandeira());
		Assert.assertEquals("Tipo incorreto", DEBITO, cartao.getTipo());
		Assert.assertEquals("Titular incorreto", "JOHN F. DOE", cartao.getTitular());
		Assert.assertEquals("Validade incorreta", Validade.from("06/2014"), cartao.getValidade());
		Assert.assertEquals("Codigo segurança incorreto", new Long(123), cartao.getCodigoSeguranca());
	}	
}
