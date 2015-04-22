package Zhava.lexer;

import java.io.IOException;
import java.io.Reader;


public class MyReader extends Reader {
	int LineNum=0;
	//String text="";
	char[]buffer;
	int length;
	int pos=0;
    public MyReader(String text){
    	this.buffer=text.toCharArray();
    	length = buffer.length;
    }
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return len;
		// TODO Auto-generated method stub
		/*if(buffer==null)
			return 0;
		int size=0;
		int length=buffer.length;
		while(pos<length&&size<len)
			cbuf[off+size++]=buffer[pos++];
		if(pos==length)
			buffer=null;
		return size;*/
	}

	public String readLine() throws IOException {
		if (buffer == null || pos == length)
			return null;
		int start = pos;
		while (pos < length) {
			if (buffer[pos++] == '\n'){
				++LineNum;
				return new String(buffer, start, pos - start);
			}
		}
		++LineNum;
		return new String(buffer, start, pos - start);
	}

	public int getLineNumber() {
		return LineNum;
	}

}
