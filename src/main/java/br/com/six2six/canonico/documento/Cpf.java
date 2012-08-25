package br.com.six2six.canonico.documento;

import org.apache.commons.lang.StringUtils;

import br.com.six2six.canonico.localizacao.UF;


public class Cpf implements Documento {
	
	private static final long serialVersionUID = -8151244453304665431L;
	
	private String value;
	
	public Cpf(String cpf, boolean leniente) {
		if (cpf != null) {
			cpf = cpf.replaceAll("(-|\\.|/)", "");
			this.value = StringUtils.leftPad(cpf, 11, "0");
		}		
		if (!isValido() && !leniente) {
			throw new DocumentoInvalido("Cpf inválido: " + this.value);
		}
	}
	
	public Cpf(String cpf) {
		this(cpf, false);
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public String getDisplayValue() {
		return this.value != null ? value.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4") : null;
	}

	@Override
	public boolean isValido() {
		if (this.value == null) {
			return false;
		}
		String cpfCalculado = calcularDigitoVerificador(this.value.substring(0, 9));
		return this.value.equals(cpfCalculado);
	}
	
	@Override
	public OrgaoEmissor getOrgaoEmissor() {
		return OrgaoEmissor.RECEITA_FEDERAL_BRASIL;
	}
	
	private String calcularDigitoVerificador(String parteCpf) {
		int multiplicador = parteCpf.length() + 1;
		int acumulador = 0;
		char[] digitos = parteCpf.toCharArray();
		for (int i = 0; i < digitos.length; i++) {
			acumulador += new Integer(String.valueOf(digitos[i])) * multiplicador;
			multiplicador--;
		}
		int digito = 11 - (acumulador % 11);
		if (digito >= 10) {
			digito = 0;
		}
		parteCpf += digito;
		return parteCpf.length() < 11 ? calcularDigitoVerificador(parteCpf) : parteCpf;
	}

	@Override
	public UF getUf() {
		return null;
	}

}
