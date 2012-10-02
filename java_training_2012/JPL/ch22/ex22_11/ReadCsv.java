package ch22.ex22_11;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ReadCsv {

	public final static char QUOTE = '\'';
	public final static char DOUBLE_QUOTE = '"';
	public final static char n = 'n';

//	public static List<String[]> readCsvTable(Reader source, int num) throws IOException{
	public static void readCsvTable(Reader source, int num) throws IOException{
		if(num<0)
			throw new IllegalArgumentException("num is negative");

		StreamTokenizer tokenizer = new StreamTokenizer(source);

		List<String[]> vals = new ArrayList<String[]>();
		StringBuffer exp = new StringBuffer("^");
		for(int i=0;i<num;i++){
			exp.append("(.*)");
			if(i<num-1)
				exp.append(",");
		}
		Pattern pat = Pattern.compile(exp.toString(), Pattern.MULTILINE);

		int token = -1;
		boolean quoteFlag = false;
		while((token = tokenizer.nextToken()) != StreamTokenizer.TT_EOF){
			switch (token) {
			case StreamTokenizer.TT_WORD:
				if(tokenizer.sval.equals("\n"))
					System.out.println();
				else
					System.out.printf(tokenizer.sval);
				break;
			default:
				System.out.print((char)tokenizer.ttype);
			}

		}

	}

	//表示はできましたが、改行が分からず切れませんでした。。。
	public static void main(String[] args) throws FileNotFoundException,IOException {
		StringReader readable = new StringReader("aa,bb,cc,ddd\ne,f,g,h\ni,j,k,l\n");
//		StringReader readable5 = new StringReader("a,b,c,d,e\nf,g,h,i,j\nk,l,m,n,o\n ");

		List<String[]> list = null;
		readCsvTable(readable, 4);

//		for(int i=0; i<list.size(); i++){
//			for(int j=0; j<list.get(i).length; j++){
//				System.out.print(list.get(i)[j] + " ");
//			}
//			System.out.println();
//		}
	}
}
