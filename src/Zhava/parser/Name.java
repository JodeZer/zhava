package Zhava.parser;

import Zhava.lexer.Token;

public class Name extends ASTLeaf{

	public Name(Token t) {
		super(t);
		// TODO Auto-generated constructor stub
	}
	public String getVal(){
		return super.token.getText();
	}

}
