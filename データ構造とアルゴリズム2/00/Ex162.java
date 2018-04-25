import java.util.Date;
import java.util.ArrayList;
interface Hand {
    int wins(Hand h);
    int getType();
}
class Hand1 implements Hand {
    Hand1(int hand){
	this.hand=hand;
    }
    private int hand;
    @Override public String toString(){
	String result;
	switch(hand){
	case 0:
	    result="Gu";
	    break;
	case 1:
	    result="Choki";
	    break;
	case 2:
	    result="Pa";
	    break;
	default:
	    result="";
	}
	return result;
    }
    public int getType(){
	return hand;
    }
    public int wins(Hand h){
	int result;
	if(hand==h.getType()){
	    return 0;
	}
	if((hand+1==h.getType())|| ((hand==2) && (h.getType()==0))){
	    return 1;
	}
	return -1;
    }
}
interface HandBuilder {
    Hand getInstance(int hand);
}
class HandBuilder1 implements HandBuilder {
    public Hand getInstance(int hand){
	if(hand <0 || hand>2 ){
	    return null;
	}
	return new Hand1(hand);
    }
}
class HandBuilder2 implements HandBuilder {
    private Hand[] hands;
    public Hand getInstance(int hand){
	if(hand <0 || hand>2 ){
	    return null;
	}
	if(hands==null){
	    hands = new Hand[3];
	    for(int i=0; i<3; i++){
		hands[i] = new Hand1(i);
	    }
	}
	return hands[hand];
    }
}
interface Tactics {
    void setHandBuilder(HandBuilder hb);
    Hand getHand();
}
class Tactics1 implements Tactics {
    public Tactics1(HandBuilder hb){
	this.hb = hb;
    }
    private HandBuilder hb;
    public void setHandBuilder(HandBuilder hb){
	this.hb = hb;
    }
    public Hand getHand(){
	return hb.getInstance((int)(Math.random()*3));
    }
}
class Tactics2 implements Tactics {
    private int counter;
    public Tactics2(HandBuilder hb){
	this.hb = hb;
	counter=0;
    }
    private HandBuilder hb;
    public void setHandBuilder(HandBuilder hb){
	this.hb = hb;
    }
    public Hand getHand(){
	Hand hand = hb.getInstance(counter);
	counter = (counter+1)%3;
	return hand;
    }
}
class Player {
    private String name;
    public Player(String name){
	this.name = name;
	win=0;
	loose=0;
	draw=0;
    }
    private Tactics tactics;
    public void setTactics(Tactics t){
	tactics = t;
    }
    public Hand getHand(){
	return tactics.getHand();
    }
    public String result(){
	return name+": "+ win +" win(s), "+loose+" loose(s), "+draw+" draw(s)";
    }
    private int win,loose,draw;
    public void win(){
	win++;
    }
    public void loose(){
	loose++;
    }
    public void draw(){
	draw++;
    }
}
class Box {
    private Player player1, player2;
    public Box(){}
    public void setPlayer1(Player p){
	player1 = p;
    }
    public void setPlayer2(Player p){
	player2 = p;
    }
    public Hand[] examine(){
	Hand[] result = new Hand[2];
	result[0]=player1.getHand();
	result[1]=player2.getHand();
	switch(result[0].wins(result[1])){
	case -1:
	    player1.loose();
	    player2.win();
	    break;
	case 0:
	    player1.draw();
	    player2.draw();
	    break;
	case 1:
	    player1.win();
	    player2.loose();
	    break;
	}
	return result;
    }
}
class StopWatch {
    private Date now;
    public StopWatch(){
	now = new Date();
    }
    @Override public String toString(){
	final Date next = new Date();
	double result = (double)( next.getTime()-now.getTime())/1000;
	now = next;
	return String.valueOf(result);
    }
}
class Ex162 {
    public static void main(String[] arg){
	final HandBuilder hb = arg[0].equals("1") 
	    ? new HandBuilder1()
	    : new HandBuilder2();
	final StopWatch sw = new StopWatch();
	test(hb);
	System.out.println(sw);
    }
    private static void test(HandBuilder hb){
	final Player player1 = new Player("Kaiji");
	player1.setTactics(new Tactics1(hb));
	final Player player2 = new Player("Funai");
	player2.setTactics(new Tactics2(hb));
	final Box box = new Box();
	box.setPlayer1(player1);
	box.setPlayer2(player2);
	final ArrayList<Hand[]> list = new ArrayList<Hand[]>();
	for(int i=1; i<=1000000; i++){
	    final Hand[] result = box.examine();
	    list.add(result);
	}
	System.out.println(player1.result());
	System.out.println(player2.result());
    }
}
