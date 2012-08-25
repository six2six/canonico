package br.com.six2six.canonico.pagamento.cartao;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class NumeroCartao implements Serializable {

	private static final long serialVersionUID = -5975469131035339940L;
	
	private String bloco1;
	private String bloco2;
	private String bloco3;
	private String bloco4;
	
	public NumeroCartao(String numero) {
		if (numero != null) {
			numero = numero.replaceAll("\\s+", "");
			numero = StringUtils.leftPad(numero, 16, "0");
			Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})");
			Matcher matcher = pattern.matcher(numero);
			if (matcher.matches()) {
				bloco1 = matcher.group(1);
				bloco2 = matcher.group(2);
				bloco3 = matcher.group(3);
				bloco4 = matcher.group(4);
			}
		}
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s", bloco1, bloco2, bloco3, bloco4);
	}
}
