package ch20.ex20_11;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class CountWord {

	public static void count(Reader reader) throws IOException{
		Map<String, Integer> map = new HashMap<String, Integer>();
		StreamTokenizer st = new StreamTokenizer(reader);

		int count = 0;
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			System.out.println(st.sval);
			if(map.containsKey(st.sval)){
				count = map.get(st.sval);
			}else{
				count = 0;
			}
			count++;
			map.put(st.sval, count);
		}

		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, Integer> showEntry = (Entry<String, Integer>) it.next();
			System.out.println(showEntry.getKey() + ":"+showEntry.getValue());
		}

	}

	public static void main(String[] args) throws IOException {
		CountWord.count(new FileReader("JPL/ch20/ex20_10/test.txt"));
	}
}
