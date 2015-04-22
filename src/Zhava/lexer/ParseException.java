package Zhava.lexer;

import java.io.IOException;

public class ParseException extends Exception{
	public ParseException(IOException e){
		super(e);
	}
	public ParseException(String s){
		super(s);
	}

}
