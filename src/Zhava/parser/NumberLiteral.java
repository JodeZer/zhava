package Zhava.parser;

import Zhava.lexer.Token;

public class NumberLiteral extends ASTLeaf{
	public NumberLiteral(Token t){
		super(t);
	}
	public int getVal(){
		return token.getNumber();
	}
}
