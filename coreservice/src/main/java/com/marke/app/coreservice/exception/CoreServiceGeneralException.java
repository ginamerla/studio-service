package com.marke.app.coreservice.exception;

/**
 * Excepcion personalizada.
 * @author visilva
 *
 */
public class CoreServiceGeneralException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CoreServiceGeneralException(String message){
		super(message);
	}

	public CoreServiceGeneralException(Throwable e) {
		super(e);
	}
	
	public CoreServiceGeneralException(String message, Throwable e) {
		super(message, e);
	}
}
