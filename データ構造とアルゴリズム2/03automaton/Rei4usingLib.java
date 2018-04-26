// Rei4の再実装。ライブラリが既にあるのでそれを使ったもの。

import java.util.*;
import java.util.regex.*;
import java.io.*;
class Rei4usingLib {
    public static void main(String arg[]) throws IOException {
	final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String buf;
	final Pattern p = Pattern.compile("[1-9][0-9]*"); //正規表現
	Matcher m;
	while((buf=br.readLine())!=null){
	    m= p.matcher(buf);
	    while(m.find()){
		System.out.println(m.group());
	    }	
	}
    }
}