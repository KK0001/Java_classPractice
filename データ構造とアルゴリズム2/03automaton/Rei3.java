
// アルゴリズムは、次の文字が来たときパターンのどこと照合するかを覚えておくというものです。
// そのため、整数で表した位置を無制限で保存できる LinkedList を使用します。
// 一文字読む毎に、その LinkedList に保存されている位置を順に取り出します(*1)。
// そして、その位置のパターンの文字と得られた文字を比較し、異なっていたらその保存していた位置を破棄します(*2)。 
// 同一だった場合、最後まで読めていたら「マッチした」と言うことにします(*3)。 
// まだパターンが残っている場合は位置を一つ進めて保存します(*4)。
// その他、読み込んだ文字がパターンの0番目の文字に一致したら1番目という位置を新たに LinkedList に加えます(*5)。 
// なお、パターンが 1 文字だった場合は「マッチした」ことにします(*6)。 


import java.io.*;
import java.util.*;
class Matcher {
    final private String pattern;
    final private LinkedList<Integer> pointer;
    public Matcher(String pattern){
        this.pattern = pattern;
        pointer = new LinkedList<Integer>(); //線形リスト
    }
    public boolean match(int c){
        boolean result = false;
        final ListIterator<Integer> i = pointer.listIterator(); //Iterator:順番にリストを見ていく
        while(i.hasNext()){    //*1
            int j = i.next();
            if(c==pattern.codePointAt(j)){
                j++;
                if(j==pattern.length()){
                    result=true;   //*3
                    i.remove();
                }else{
                    i.set(j);  //*4
                }
            }else{
                i.remove();  //*2
            }
        }
        if(c==pattern.codePointAt(0)){
            if(pattern.length()==1){
                result=true;    //*6
            }else{
                pointer.add(1); //*5
            }
        }
        return result;
    }
}
class Rei3 {
    public static void main(String[] arg) throws IOException {
	final Matcher m = new Matcher(arg[0]);
	final Reader r = new StringReader(arg[1]); // 入力
	int count=0;
    int c;
    // 入力を一つずつ調べ、マッチしたらカウント
	while((c=r.read())!=-1){
	    if(m.match(c)){
               count++;
            }
	}
	System.out.println(count);
    }
}
