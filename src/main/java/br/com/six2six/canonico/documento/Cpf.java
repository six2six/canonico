package br.com.six2six.canonico.documento;

import org.apache.commons.lang.StringUtils;


public class Cpf implements Documento {
	
	private static final long serialVersionUID = -8151244453304665431L;
	
	private String value;
	
	public Cpf(String cpf, boolean leniente) {
		if (cpf != null) {
			cpf = cpf.replaceAll("(-|\\.)", "");
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
		return true;
	}

}
