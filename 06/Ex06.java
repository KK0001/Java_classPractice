import java.util.Scanner;

class Ex06 {
  public static void main(String[] args) {
    String gakuban = "16EC000"; // 学籍番号を入力すること
    String yourname = "千住旭"; // 氏名を入力すること
    System.out.println(gakuban + " " + yourname + "\n"); // 削除しないこと
    Scanner stdIn = new Scanner(System.in);
    System.out.print("配列の要素数：");
    int n = stdIn.nextInt(); // 要素数
    int[] x = new int[n]; // 配列
    for(int i = 0; i < n; i++) {
    System.out.printf("x[%d]：", i);
    x[i] = stdIn.nextInt(); // 要素の値
    }
    double u = 0.; // 平均
    double v = 0.; // 分散

    // 平均と分散を計算するプログラムを記入
    // 平均を計算
    for(int i = 0; i < n; i++)
      u+=x[i];
    u/=n; // 平均値

    // 分散を計算
    for(int i = 0; i < n; i++)
      v+=(x[i]-u)*(x[i]-u);
    v/=n; // 分散値

    // 以下の行は削除しないこと
    System.out.printf("平均 u = %4.2f, 分散 v = %4.2f\n", u, v);
    // 結果を出力する
  }
}
