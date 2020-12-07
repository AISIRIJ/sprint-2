package com.cg.medicine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author aisiri
 * This class handles user defined exception by extending runtime exception
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MedicineIdException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	public MedicineIdException() {
		super();
	}
	public MedicineIdException(String errMsg) {
		super(errMsg);
	}
}

