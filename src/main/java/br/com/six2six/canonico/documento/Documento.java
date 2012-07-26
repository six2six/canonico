package br.com.six2six.canonico.documento;

import java.io.Serializable;

/**
 * Abstrai algum documento de identificação
 */
public interface Documento extends Serializable {

	String getValue();
	String getDisplayValue();
	boolean isValido();
}
