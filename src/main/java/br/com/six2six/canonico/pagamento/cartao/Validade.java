package br.com.six2six.canonico.pagamento.cartao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class Validade implements Serializable {
	
	private static final long serialVersionUID = -1407332047047914672L;
	
	private Long mes;
	private Long ano;
	
	public Validade(Long mes, Long ano) {
		this.mes = mes;
		this.ano = ano;
	}
	
	@Override
	public String toString() {
		return StringUtils.leftPad(""+this.mes, 2, "0") + "/" + this.ano;
	}

	public static Validade from(Date mesAno) {
		return from(new SimpleDateFormat("MM/yyyy").format(mesAno));
	}
	
	public static Validade from(String mesAno) {
		Validade validade = null;
		if (mesAno != null) {
			String[] dadosValidade = mesAno.split("/");
			if (dadosValidade.length == 2) {
				validade = new Validade(new Long(dadosValidade[0]), new Long(dadosValidade[1]));
			}
		}
		return validade;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equals = false;
		if (obj != null) {
			if (Validade.class.equals(obj.getClass())) {
				Validade outra = (Validade) obj;
				equals = this.ano.equals(outra.ano) && this.mes.equals(outra.mes);
			}
		}
		return equals;
	}
}
