// エラー: final変数sbに値を代入することはできません
//                     sb = new StringBuilder();
//                     ^
import java.io.*;
enum State {
  STATE1, STATE2
}
class Rei3 {
    public static void main(String[] arg)throws IOException{
	final Reader r = new InputStreamReader(System.in);
	int c;
	State s=State.STATE1;
	final StringBuilder sb=null;
	while((c=r.read())!=-1){
	    switch(s){
            case STATE1:
                if((c>='1')&&(c<='9')){
                    sb = new StringBuilder();
                    sb.append((char)c);
                    s=State.STATE2; 
                }else{
                    s=State.STATE1;
                }
                break;
            case STATE2:
                if((c>='0')&&(c<='9')){
                    sb.append((char)c);
                    s=State.STATE2; 
                }else{
                    System.out.println(sb.toString());
                    s=State.STATE1;
                }
                break;
	    }
	}
	if(s==State.STATE2){
	    System.out.println(sb.toString());
	}
	
    }
}