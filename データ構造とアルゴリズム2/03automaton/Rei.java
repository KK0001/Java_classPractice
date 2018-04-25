import java.io.*;
enum State {
  STATE1, STATE2, STATE3
} 
// 列挙型


class Rei {

	// 入力処理
	private static int get(Reader r) throws IOException {
	int c;
    do{
    	c=r.read();
	}while(c=='\n' || c=='\r');
		return c;
	}
	
	// main
    public static void main(String[] arg)throws IOException{
	final Reader r = new InputStreamReader(System.in);
	int c;
	State s=State.STATE1;
	try{
	    while((c=get(r))!=-1){
		switch(s){
		case STATE1:
		    if(c=='A'){ s=State.STATE2; }
		    else if(c=='C'){ s=State.STATE3; }
		    else{ throw new IllegalStateException(); }
		    break;
		case STATE2:
		    if(c=='A'){ s=State.STATE2; }
		    else if(c=='B'){ s=State.STATE3; }
		    else{ throw new IllegalStateException(); }
		    break;
		case STATE3:
		    if(c=='B'){ s=State.STATE1; }
		    else{ throw new IllegalStateException(); }
		    break;
		}
	    }
	    if(s!=State.STATE3){
			throw new IllegalStateException();
	    }
	    System.out.println("Accept");
	}catch(IllegalStateException e){
	    System.out.println("Reject");
	}
    }
}