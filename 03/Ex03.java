// 読み込んだ三つの整数値の中央値を表示せよ。
// 例えば、三つの整数値が 10,20,11 ならば、11 を表示する。 // 参考 教科書List 3-12
import java.util.Scanner;
class Ex03 {
  public static void main(String[] args) {
    String gakuban = "16EC000"; // 学籍番号を入力すること
    String yourname = "千住旭"; // 氏名を入力すること
    System.out.println(gakuban + " " + yourname + "\n"); // 削除しないこと

    Scanner stdIn = new Scanner(System.in);
    System.out.print("整数a:");   int a = stdIn.nextInt();
    System.out.print("整数b:");   int b = stdIn.nextInt();
    System.out.print("整数c:");   int c = stdIn.nextInt();
    int mid = 0;
    // a,b,c の中央値を求め、変数 mid に代入する。
    if (a < b) {
      if (c < a) mid = a;
      else if (b < c) mid = b;
      else mid = c;
      } else {
      if (a < c) mid = a;
      else if (c < b) mid = b;
      else mid = c;
      }
    System.out.println("中央値は " + mid + " です。");
} }
