package Zhava.parser;

import java.util.Iterator;
import java.util.List;

public class ASTNode extends ASTree{
	protected List<ASTree> children;
	public ASTNode(List<ASTree> list){
		children=list;
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
		return null;
	}

}
