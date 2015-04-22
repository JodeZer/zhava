package Zhava.parser;

import java.util.Iterator;

public abstract class ASTree implements Iterable<ASTree>{
	public abstract ASTree getchild(int index);
	public abstract int getCount();
	public abstract Iterator<ASTree> getIterator();
	public abstract String location();
	public Iterator<ASTree> iterator(){
		return getIterator();
	}

}
