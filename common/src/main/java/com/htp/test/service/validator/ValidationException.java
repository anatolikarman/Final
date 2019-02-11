package com.htp.test.service.validator;

import com.htp.test.exceptions.ServiceException;

public class ValidationException extends ServiceException {

    private static final long serialVersionUID = 1L;

    public ValidationException(String message){
        super(message);
    }

    public ValidationException(String message, Exception ex){
        super(message, ex);
    }
}
