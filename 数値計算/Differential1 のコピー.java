// 微分
// 1.関数を定義
// 2.分割数, 区間を設定
// 3.実行

import java.io.*;

public class Differential1 {

  static final int DIV_NUM = 100;//分割数
  static final double X_MAX = 1.0;
  static final double MIN_DIV = X_MAX/(double)DIV_NUM;

  public static void main(String [] args) {

    try {


      double dx = MIN_DIV;
      double x = 0.0;
      double dy1 = 0.0, dy2 = 0.0;
      double d2y = 0.0;

      double y0 = 0.0, y1 = 0.0, y2 = 0.0, y3 = 0.0;

      // FileWriter fout = new FileWriter("diff1.txt"); //出力ファイル

      Differential1 differential = new Differential1();  //インスタンス

      // for (x=0; x<=X_MAX; x+=MIN_DIV) {
      for (int i=0; i<DIV_NUM; i++) {

        y0 = differential.defineFunction(x);
        y1 = differential.defineFunction(x + dx);
        y2 = differential.defineFunction(x + 2*dx);

        dy1 = (y1 - y0) / dx;
        dy2 = (y2 - y1) / dx;

        d2y = (dy2 - dy1) / dx;// d2y = (y2 - 2*y1 + y0) / (dx*dx)

        // fout.write(x + " " + y0 + " " + dy1 + " " + d2y + " " + "\n");

        System.out.println(x + " " + y0 + " " + dy1 + " " + d2y);

        x += MIN_DIV;
      }

      // fout.close();

    } catch (Exception e) {
      System.out.println(e);
    }

  } // main

  // 関数を定義
  double defineFunction(double x) {
    return Math.exp(x);
  }


}  // class Differential
