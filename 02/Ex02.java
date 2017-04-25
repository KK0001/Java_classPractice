// キーボードから球の半径（実数）を読み込み、球の体積と表面積を表示せよ。

import java.util.Scanner;

class Ex02 {

    public static void main(String[] args) {
        String gakuban = "学籍番号"; // 学籍番号を入力すること
        String yourname = "名前"; // 氏名を入力すること
        System.out.println(gakuban + " " + yourname + "\n"); // この行は削除しないこと

        final double PI = 3.1416;   // 円周率
        Scanner stdIn = new Scanner(System.in);

        System.out.println("半径を入力: ");// 半径の入力を促す
        int r = stdIn.nextInt();// 球の半径を読み込む

        System.out.println("体積: "+ 4. / 3. * PI * r*r*r);// 体積を表示
        // × double s = 4 / 3 * PI * r * r * r;
        // △ double s = 4 * PI * r * r * r / 3;
        System.out.println("表面積: "+ 4 * PI * r*r);// 表面積を表示
    }
}
