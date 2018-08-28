package com.thd.tool.exception;

public class MyException extends RuntimeException {
	public MyException(){};
	public MyException(String message) {
        super(message);
    }
}
