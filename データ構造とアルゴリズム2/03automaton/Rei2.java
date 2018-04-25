import java.io.*;

// 列挙型の要素にメソッドを書ける。Java特有の機能。public必須
enum State {
    STATE1 { 
		public State nextState(int c) throws IllegalStateException {
			if(c=='A'){  return STATE2; }
			if(c=='C'){  return STATE3; }
			throw new IllegalStateException(); 
		}
    },
    STATE2 {
		public State nextState(int c) throws IllegalStateException {
			if(c=='A'){  return STATE2; }
			if(c=='B'){  return STATE3; }
			throw new IllegalStateException(); 
		}
    },
    STATE3 {
		public State nextState(int c) throws IllegalStateException {
			if(c=='B'){ return STATE1; }
			throw new IllegalStateException();
		}
    };
    abstract public State nextState(int c) throws IllegalStateException;
}
class Rei2 {
    private static int get(Reader r) throws IOException {
		int c;
			do{
				c=r.read();
		}while(c=='\n' || c=='\r');
		return c;
    }
    public static void main(String[] arg)throws IOException{
	final Reader r = new InputStreamReader(System.in);
	int c;
	State s=State.STATE1;
	try{
	    while((c=get(r))!=-1){
		    s = s.nextState(c); //処理が簡単になった
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
