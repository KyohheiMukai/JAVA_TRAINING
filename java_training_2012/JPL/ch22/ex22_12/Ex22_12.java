package ch22.ex22_12;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Ex22_12 {

	public static Attributed readAttrs(Reader source) throws IOException{
		Scanner in = new Scanner(source);
		AttributedImpl attrs = new AttributedImpl();
		Attr attr = null;
		in.skip("#");
		in.skip("/");

		String str;
		while(in.hasNext()){
			str = in.next();
			if(str.equals("=")){
				if(attr == null){
					throw new IOException("misplaced");
				}else{
					attr.setValue(Double.parseDouble(str));
					attr = null;
				}
			}else{
				if(attr != null){
					attr.setValue(str);
					attr = null;
				}else{
					attr = new Attr(str);
					attrs.add(attr);
				}
			}
		}
		return attrs;
	}

	//TODO テストコード
	public static void main(String[] args) {

	}

}
