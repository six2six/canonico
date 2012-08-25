package br.com.six2six.canonico.documento;

import java.io.Serializable;

import br.com.six2six.canonico.localizacao.UF;

/**
 * Abstrai algum documento de identificação
 */
public interface Documento extends Serializable {

	String getValue();
	String getDisplayValue();
	boolean isValido();
	OrgaoEmissor getOrgaoEmissor();
	UF getUf();
}
