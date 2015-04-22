package Zhava.lexer;

import Zhava.lexer.Token;

public class NumToken extends Token {
	private int value;
	protected NumToken(int lineNum,int value) {
		super(lineNum);
		this.value=value;
	}
	@Override
	public boolean isNumber(){
		return true;
	}
	@Override
	public String getText(){
		return Integer.toString(value);
	}
	@Override
	public int getNumber(){
		return value;
	}

}
