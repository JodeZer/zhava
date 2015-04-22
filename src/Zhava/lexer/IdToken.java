package Zhava.lexer;

public class IdToken extends Token {
	private String id;
	protected IdToken(int lineNum,String id) {
		super(lineNum);
		this.id=id;
	}
	@Override
	public boolean isIdentifier(){
		return true;
	}
	@Override
	public String getText(){
		return id;
	}

}
