package br.com.six2six.canonico.pagamento.cartao;

import java.io.Serializable;
import java.util.Date;
import static br.com.six2six.canonico.pagamento.cartao.Tipo.CREDITO;
import static br.com.six2six.canonico.pagamento.cartao.Tipo.DEBITO;

/**
 * Representa um cartão de débito ou crédito.
 */
public class Cartao implements Serializable {
	
	private static final long serialVersionUID = -5533779183747909276L;
	
	private Tipo tipo;
	private NumeroCartao numero;
	private String titular;
	private Bandeira bandeira;
	private Validade validade;
	private Long codigoSeguranca;
	
	
	public Tipo getTipo() {
		return tipo;
	}

	public NumeroCartao getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public Validade getValidade() {
		return validade;
	}

	public Long getCodigoSeguranca() {
		return codigoSeguranca;
	}


	public static class CartaoBuilder {
		
		private Cartao cartao;

		public CartaoBuilder(Bandeira bandeira, Tipo tipo) {
			this.cartao = new Cartao();
			cartao.tipo = tipo;
			cartao.bandeira = bandeira;
		}

		public CartaoBuilder para(String nome) {
			cartao.titular = nome;
			return this;
		}

		public CartaoBuilder comNumero(String numero) {
			cartao.numero = new NumeroCartao(numero);
			return this;
		}
		
		public CartaoBuilder comNumero(NumeroCartao numero) {
			cartao.numero = numero;
			return this;
		}
		
		public CartaoBuilder vencendoEm(String mesAno) {
			cartao.validade = Validade.from(mesAno);
			return this;
		}
		
		public CartaoBuilder vencendoEm(Long mes, Long ano) {
			cartao.validade = new Validade(mes, ano);
			return this;
		}
		
		public CartaoBuilder vencendoEm(Validade validade) {
			cartao.validade = validade;
			return this;
		}
		public CartaoBuilder vencendoEm(Date mesAno) {
			cartao.validade = Validade.from(mesAno);
			return this;
		}

		public CartaoBuilder codigoSeguranca(Long codigoSeguranca) {
			cartao.codigoSeguranca = codigoSeguranca;
			return this;
		}
		
		public Cartao build(){
			return this.cartao;
		}
		
		public Cartao build(boolean leniente) {
			return this.cartao;
		}
		
		public static CartaoBuilder novoCartaoCredito(Bandeira bandeira) {
			return new CartaoBuilder(bandeira, CREDITO);
		}
		
		public static CartaoBuilder novoCartaoDebito(Bandeira bandeira) {
			return new CartaoBuilder(bandeira, DEBITO);
		}		
				
	}
}
