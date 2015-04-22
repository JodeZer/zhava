package Zhava.UnitTest;

import java.io.IOException;
import java.io.Reader;

import Zhava.lexer.MyReader;

public class ReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fuck="l want to\nfuck you\nass";
		MyReader reader=new MyReader(fuck);
		try {
			String res=reader.readLine();
			while(res!=null)
			{
			System.out.println(res);
			res=reader.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
