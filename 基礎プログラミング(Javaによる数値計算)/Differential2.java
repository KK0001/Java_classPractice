// sin(x)の導関数を求める

import java.io.*;

public class Differential2 {


  static final int DIV_NUM = 100;
  static final double X_MAX = 2 * Math.PI;
  static final double MIN_DIV = X_MAX/(double)DIV_NUM;

  public static void main(String [] args) {

    try {


      double dx = MIN_DIV;
      double x = 0.0;
      double dy0 = 0.0;
      double dy1 = 0.0, dy2 = 0.0;
      double d2y0 = 0.0;
      double d2y1 = 0.0;
      double d3y0 = 0.0;

      double y0 = 0.0, y1 = 0.0, y2 = 0.0, y3 = 0.0;

      FileWriter fout = new FileWriter("diff2.txt");

      Differential2 differential2 = new Differential2();

//      for (x=0; x<=X_MAX; x+=MIN_DIV) {
      for (int i=0; i<=DIV_NUM; i++) {

        y0 = differential2.defineFunction(x);
        y1 = differential2.defineFunction(x + dx);
        y2 = differential2.defineFunction(x + 2*dx);
        y3 = differential2.defineFunction(x + 3*dx);

        dy0 = (y1 - y0) / dx;
        dy1 = (y2 - y1) / dx;
        dy2 = (y3 - y2) / dx;

        d2y0 = (dy1 - dy0) / dx;
        d2y1 = (dy2 - dy1) / dx;

        d3y0 = (d2y1 - d2y0) / dx;

        fout.write(x + " " + y0 + " " + dy0 + " " + d2y0 + " " + d3y0 + "\n");

        System.out.println(x + "," + y0 + "," + dy0 + "," + d2y0 + "," + d3y0);

        x += dx;
      }

      fout.close();

    } catch (Exception e) {
      System.out.println(e);
    }

  } // main

  double defineFunction(double x) {
    return Math.sin(x);
  }


}  // class Differential
