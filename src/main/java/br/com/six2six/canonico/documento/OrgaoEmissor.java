package br.com.six2six.canonico.documento;

public enum OrgaoEmissor {
	
	RECEITA_FEDERAL_BRASIL("RFB"),
	SECRETARIA_SEGURANCA_PUBLICA("SSP"),
	DEPARTAMENTO_ESTADUAL_TRANSITO("DETRAN");
	
	private String sigla;

	private OrgaoEmissor(String sigla) {
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return sigla;
	}
	
}
