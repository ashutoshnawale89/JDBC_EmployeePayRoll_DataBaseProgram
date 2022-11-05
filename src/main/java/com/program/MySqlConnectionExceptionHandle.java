package com.program;

public class MySqlConnectionExceptionHandle extends Exception {
	enum ExceptionType{
		ENTERED_DATA_NOT_CONNECTED_WRONG_INPUTS
	}
	ExceptionType type;
	public MySqlConnectionExceptionHandle(ExceptionType type,String msg) {
		super(msg);
		this.type=type;
	}

}
