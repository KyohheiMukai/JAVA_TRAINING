package ch10.ex10_01;

public class SpecialString {

	public String changeString(String str){

		/**
		 * 対応するJava言語の表現って何か
		 * （質問票の納期後に発生、すみません）
		 * 空欄はコンパイルエラーになってしまう
		 */

		if(str.contains("\n")){
			str = str.replace("\n","");

		}else if(str.contains("\t")){
			str = str.replace("\t","\u0009");

		}else if(str.contains("\b")){
			str = str.replace("\b","\u0008");

		}else if(str.contains("\r")){
			str = str.replace("\r","");

		}else if(str.contains("\f")){
			str = str.replace("\f","\u000C");

		}else if(str.contains("\\")){
			str = str.replace("\\","");

		}else if(str.contains("\'")){
			str = str.replace("\'","\u0027");

		}else if(str.contains("\"")){
			str = str.replace("\"","");
		}


		return str;

	}

}
