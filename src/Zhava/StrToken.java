package Zhava;

public class StrToken extends Token {
	private String constString;
	protected StrToken(int lineNum,String str) {
		super(lineNum);
		constString=str;
	}
	@Override
	public boolean isString(){
		return true;
	}
	@Override
	public String getText(){
		return constString;
	}

}
