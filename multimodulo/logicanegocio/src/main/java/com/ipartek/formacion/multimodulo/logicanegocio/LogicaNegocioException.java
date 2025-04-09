package com.ipartek.formacion.multimodulo.logicanegocio;

public class LogicaNegocioException extends RuntimeException {

	private static final long serialVersionUID = -7463109200298733893L;

	public LogicaNegocioException() {
		super();
	}

	public LogicaNegocioException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LogicaNegocioException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogicaNegocioException(String message) {
		super(message);
	}

	public LogicaNegocioException(Throwable cause) {
		super(cause);
	}

	
}
