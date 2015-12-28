package com.ez.aop.exception.advice;


/**
 * 
 * @author nagendra.yadav
 *
 */
public class EZLoanException extends RuntimeException {
	
    public EZLoanException() {
    	super();
    }

    public EZLoanException(String message) {
    	super(message);
    }

    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * <code>cause</code> is <i>not</i> automatically incorporated in
     * this runtime exception's detail message.
     */
    public EZLoanException(String message, Throwable cause) {
        super(message, cause);
    }

}
