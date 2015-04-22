package Zhava.lexer;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
	final boolean DEBUG=false;
	public static String regexPat="\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")"
			   +"|[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";
	private Pattern pattern=Pattern.compile(regexPat);
	private List<Token> queue=new ArrayList<Token>();
	private boolean hasMore;
	private Reader reader;
	
	public Lexer(Reader reader){
		hasMore=true;
		this.reader=reader;
	}
	public Token read() throws ParseException{
		if(fillQueue(0))
			return queue.remove(0);
		else
			return Token.EOF;
	}
	public Token peek(int i) throws ParseException{
		if(fillQueue(i))
			return queue.get(i);
		else
			return Token.EOF;
	}
	private boolean fillQueue(int i) throws ParseException{
		while(i>=queue.size()){
			if(hasMore)
				readLine();
			else
				return false;
		}
		return true;	
	}
	private void readLine() throws ParseException{
		String line;
		try {
			line=((MyReader)reader).readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ParseException(e);
		}
		if(line==null){
			hasMore=false;
			return;
		}
		int lineNO=((MyReader)reader).getLineNumber();
		Matcher matcher=pattern.matcher(line);
		matcher.useTransparentBounds(true).useAnchoringBounds(false);
		int pos=0,endPos=line.length();
		while(pos<endPos){
			matcher.region(pos,endPos);
			if(matcher.lookingAt()){
				addToken(lineNO,matcher);
				pos=matcher.end();
			}else{
				throw new ParseException("BAD AT"+lineNO);
			}
		}
		queue.add(new IdToken(lineNO,Token.EOL));
	}
	protected void addToken(int lineNO,Matcher matcher){//²»Àí½â
		if(DEBUG)
		for(int i=0;i<matcher.groupCount();i++)
			System.out.println(matcher.group(i));
		String m=matcher.group(1);
		if(m!=null)
			if(matcher.group(2)==null){
				Token t;
				if(matcher.group(3)!=null)
					t=new NumToken(lineNO,Integer.parseInt(m));
				else if(matcher.group(4)!=null)
					t=new StrToken(lineNO,toStringLiteral(m));
				else
					t=new IdToken(lineNO,m);
				queue.add(t);
			}
				
	}
	protected String toStringLiteral(String str){
		StringBuilder sb=new StringBuilder();
		int len=str.length()-1;
		for(int i=1;i<len;i++){
			char c=str.charAt(i);
			if(c=='\\'&&i+1<len){
				int c2=str.charAt(i+1);
				if(c2=='"'||c2=='\\')
					c=str.charAt(++i);
				else if(c=='n'){
					++i;
					c='\n';
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}
	

}
