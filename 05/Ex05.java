/*
 * Ex05
 * 正の整数 n (<= 25) を入力して、実数 x を 1. から 5. まで 0.001 ずつ増加させていき、
 * x * x が n を超えない範囲で最も近くなるような x を出力する。
 * 例えば、入力が 2 ならば 1.414、 入力が 9 ならば 3.000 を出力。
 */

import java.util.Scanner;

class Ex05 {

    public static void main(String[] args) {
        String gakuban = "16EC000"; // 学籍番号を入力すること
        String yourname = "千住旭"; // 氏名を入力すること
        System.out.println(gakuban + " " + yourname + "\n"); // 削除しないこと

        Scanner stdIn = new Scanner(System.in);
        System.out.print("正の整数：");
        int n = stdIn.nextInt();    // 正の整数
        double ans = 0.0;           // 平方根の答え

        // √n の近似値を計算するプログラムを記入
        for (int i = 1; i <= 5000; i++) {
          float x = (float)i / 1000;
          if(x*x<=n)
           ans = x;
        }

        // 以下の行は削除しないこと
        System.out.printf("√%d = %5.3f\n", n, ans); // 結果を出力する
    }
}
