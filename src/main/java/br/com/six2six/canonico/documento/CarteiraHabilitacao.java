package br.com.six2six.canonico.documento;

import br.com.six2six.canonico.localizacao.UF;

public class CarteiraHabilitacao implements Documento {
	
	private static final long serialVersionUID = -2180310783249577853L;
	
	private String value;
	private UF uf;
	
	public CarteiraHabilitacao (String numero, UF uf) {
		this(numero, uf, false);
	}
	
	public CarteiraHabilitacao (String numero, UF uf, boolean leniente) {
		if (numero != null) {
			this.value = numero.replaceAll("\\D", "");
		}
		
		this.uf = uf;
		
		if (!dadosValidos() && !leniente) {
			throw new DocumentoInvalido("CNH inválida: " + this.value);
		}
	}	

	private boolean dadosValidos() {
		return this.value != null && !this.value.isEmpty() && this.uf != null;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public String getDisplayValue() {
		return this.getValue() + " - " + this.getOrgaoEmissor().getSigla() + "/" + this.getUf();
	}

	@Override
	public boolean isValido() {
		return this.dadosValidos();
	}

	@Override
	public OrgaoEmissor getOrgaoEmissor() {
		return OrgaoEmissor.DEPARTAMENTO_ESTADUAL_TRANSITO;
	}

	@Override
	public UF getUf() {
		return this.uf;
	}

}
