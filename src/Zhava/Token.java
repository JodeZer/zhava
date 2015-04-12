package Zhava;
public abstract class Token {
	public static final Token EOF=new Token(-1){};
	public static final String EOL="\\n";
	private int lineNum;
	
    protected Token(int lineNum)
    {
    	this.lineNum=lineNum;
    }
	public int getLineNum() {
		return lineNum;
	}
	public boolean isIdentifier(){
		return false;
	}
	public boolean isString(){
		return false;
	}
	public boolean isNumber(){
		return false;
	}
	public String getText(){
		return "";
	}
	public int getNumber(){
		throw new StoneException("not number token");
	}
	
}
