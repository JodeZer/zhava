package Zhava.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Zhava.lexer.Token;

public class ASTLeaf extends ASTree{
	public static List<ASTree> empty=new ArrayList<ASTree>();
	protected Token token;
	public ASTLeaf(Token t){
		token =t;
	}
	public String toString(){
		return token.getText();
	}
	@Override
	public ASTree getchild(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<ASTree> getIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String location() {
		// TODO Auto-generated method stub
		return "at line:"+token.getLineNum();
	}

}
