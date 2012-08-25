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
		return this.value.endsWith(calcularDigitoVerificadores(this.value.substring(0, 12)));
	}
	
	private String calcularDigitoVerificadores(String parteCnpj) {
		String digitos = "";
		int[] multiplicadores = new int[] {6,5,4,3,2,9,8,7,6,5,4,3,2};
		if (permiteCalcularDigito(parteCnpj)) {
			int indexMultiplicador = parteCnpj.length() == 12 ? 1 : 0;
			int total = 0;
			for (int i=0; i < parteCnpj.length(); i++) {
				total += new Integer(String.valueOf(parteCnpj.charAt(i))) * multiplicadores[indexMultiplicador];
				indexMultiplicador++;
			}
			
			int digito = 11 - (total % 11);
			if (digito >= 10) {
				digito = 0;
			}
			digitos = digitos.concat(String.valueOf(digito));
			parteCnpj += digitos;
			digitos = digitos.concat(String.valueOf(calcularDigitoVerificadores(parteCnpj)));
		}
		return digitos;
	}
	
	private boolean permiteCalcularDigito(String parteCnpj) {
		return parteCnpj != null && parteCnpj.length() >= 12 && parteCnpj.length() < 14;
	}

}
