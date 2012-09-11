package ch10.ex10_02;

public class SpecialString {

	public char changeString(char ch){

		/**
		 * 置き換える文字列が分からなかったため、
		 * 暫定的に違う文字に置き換えています
		 */
		switch(ch){
		case '\n':
			ch = 'n';
			break;
		case '\t':
			ch = 't';
			break;
		case '\b':
			ch = 'b';
			break;
		case '\r':
			ch = 'r';
			break;
		case '\f':
			ch = 'f';
			break;
		case '\\':
			ch = 'd';
			break;
		case '\'':
			ch = 's';
			break;
		case '\"':
			ch = 'd';
			break;

		}
		return ch;


	}

	public static void main(String[] args) {
		SpecialString ss = new SpecialString();
		char c = ss.changeString('\n');
		System.out.println(c);
	}

}
