package ch22.ex22_08;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ReadCsv {

	public static List<String[]> readCsvTable(Readable source, int num) throws IOException{

		if(num<0)
			throw new IllegalArgumentException("num is negative");

		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		StringBuffer exp = new StringBuffer("^");
		for(int i=0;i<num;i++){
			exp.append("(.*)");
			if(i<num-1)
				exp.append(",");
		}
		Pattern pat = Pattern.compile(exp.toString(), Pattern.MULTILINE);

		boolean hasLine = true;
		while(in.hasNextLine()){
			if(!hasLine)
				throw new IOException("input format error");
			String line = in.findInLine(pat);
			if(line != null){
				String[] cells = new String[num];
				MatchResult match = in.match();
				for(int i=0; i<num; i++){
					cells[i] = match.group(i+1);
					if(cells[i].indexOf(",") != -1)
						throw new IOException("comma is not permitted.");
				}
				vals.add(cells);
				in.nextLine();
			}else{
				hasLine = false;
				in.nextLine();
			}
		}

		IOException ex = in.ioException();
		if(ex!= null)
			throw ex;

		return vals;
	}

	public static void main(String[] args) throws FileNotFoundException,IOException {
		StringReader readable = new StringReader("a,b,c,d\ne,f,g,h\ni,j,k,l\n");
//		StringReader readable5 = new StringReader("a,b,c,d,e\nf,g,h,i,j\nk,l,m,n,o\n ");

		List<String[]> list = null;
		list = readCsvTable(readable, 4);

		for(int i=0; i<list.size(); i++){
			for(int j=0; j<list.get(i).length; j++){
				System.out.print(list.get(i)[j] + " ");
			}
			System.out.println();
		}
	}
}
