package Zhava;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CodeDialog{
	String text="";
	MyReader reader;
	protected void showDialog() throws ParseException{
		JTextArea area=new JTextArea(20,40);
		JScrollPane pane=new JScrollPane(area);
		int result=JOptionPane.showOptionDialog(null, pane, "input", JOptionPane.OK_CANCEL_OPTION, 
													JOptionPane.PLAIN_MESSAGE, null, null, null);
		if(result==JOptionPane.OK_OPTION)
		{
			text=area.getText();
			reader=new MyReader(text);
			Lexer l=new Lexer(reader);
			for(Token t;(t=l.read())!=Token.EOF; )
				System.out.println("=>"+t.getText());
			
		}
	}
	public MyReader getReader() {
		return reader;
	}

}
