// EOF（End Of File）の扱いがめんどい
// コン基礎とは処理の順序が違う

import java.io.*;
class Parser {
    enum State {
	    STATE1, STATE2
    }
    private Reader reader;
    private int lastChar; //最後の文字列（EOF対策）
    private State s;
    // 数を順に得るメソッド
    public Parser(Reader r)throws IOException{
        reader = r;
        lastChar=reader.read();
        s=State.STATE1;
    }
    public String nextToken() throws IOException{
        final StringBuilder sb = new StringBuilder();
        while(true){
                switch(s){
                case STATE1:
                if(lastChar==-1){ //EOFのとき終了
                    return null;
                }
                if((lastChar>='1')&&(lastChar<='9')){
                    sb.append((char)lastChar);
                    s=State.STATE2; 
                    break;
                }
                s=State.STATE1;
                break;
                case STATE2:
                if((lastChar>='0')&&(lastChar<='9')){
                    sb.append((char)lastChar);
                    s=State.STATE2; 
                    break;
                }
                s=State.STATE1;
                return sb.toString();
            }
            lastChar = reader.read();
        }
    }
}
class Rei4 {
    public static void main(String[] arg)throws IOException{
        final Reader r = new InputStreamReader(System.in);
        final Parser p = new Parser(r);
        String str;
        while((str=p.nextToken())!=null){
            System.out.println(str);
        }
    }
}

