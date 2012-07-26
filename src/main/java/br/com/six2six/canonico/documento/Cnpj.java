package br.com.six2six.canonico.documento;

import org.apache.commons.lang.StringUtils;


public class Cnpj implements Documento {
	
	private static final long serialVersionUID = -8812948908323180994L;
	
	private String value;
	
	public Cnpj(String cnpj, boolean leniente) {
		if (cnpj != null) {
			cnpj = cnpj.replaceAll("(-|\\.|/)", "");
			this.value = StringUtils.leftPad(cnpj, 14, "0");
		}		
		if (!isValido() && !leniente) {
			throw new DocumentoInvalido("Cnpj inválido: " + this.value);
		}
	}
	
	public Cnpj(String cnpj) {
		this(cnpj, false);
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public String getDisplayValue() {
		return this.value != null ? value.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5") : null;
	}

	@Override
	public boolean isValido() {
		return true;
	}
	
	private String calcularDigitoVerificador(String parteCnpj) {
		return null;
	}

}
