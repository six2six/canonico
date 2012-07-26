package br.com.six2six.canonico.documento;

public class DocumentoInvalido extends RuntimeException {

	private static final long serialVersionUID = -5294622260251039276L;

	public DocumentoInvalido(String message, Throwable cause) {
		super(message, cause);
	}

	public DocumentoInvalido(String message) {
		super(message);
	}

}
