// オイラー法
// 修正オイラー法
// 4次のルンゲ・クッタ法
// 1.入力関数を定義
// 2.入力関数の微分を定義
// 3.メインのクラスでのインストラクタの引数を書き換える→(分割数, 初期値, xの範囲)
// 4.実行

import java.io.*;

public class DifferentialEquationCalculation2 {

  public static void main(String [] args) {

    // (分割数, x初期値, y初期値, xの範囲(0~))
    DifferentialEquationSolver4 des = new DifferentialEquationSolver4(100, 0.0, 0.0, 10);

    // 算出
    // des.calculateEuler(); //オイラー法
    // des.calculateModifiedEuler(); //修正オイラー法
    des.calculateRungeKutta(); //ルンゲ・クッタ法

  }

}  // class DifferentialEquationCalculation




// 計算部分
class DifferentialEquationSolver4 {

  int division_number;
  double initial_x;
  double initial_y;
  double maximum_x;

  // コンストラクタ
  DifferentialEquationSolver4(int n, double xi, double yi, double xm) {
    division_number = n;
    initial_x = xi;
    initial_y = yi;
    maximum_x = xm;
  }


  // 関数を定義
  public double defineFunction(double x, double y) {
    return (x*Math.sin(x) - y)/(10*20);
    // return (x*x - y)/(10*20);
  }

  // ↑をxで微分(yもxの関数であることに注意)
  public double defineDerivedFunction(double x, double y) {
    return (Math.sin(x)+x*Math.cos(x) - defineFunction(x, y))/(10*20);
    // return (2*x - defineFunction(x, y))/(10*20);
  }


  // オイラー法
  public double calculateEuler() {

    try {

      FileWriter fout = new FileWriter("euler.txt");

      double x = initial_x;
      double y = initial_y;
      double h = (maximum_x - initial_x) / (double)division_number;

      fout.write(x + " " + y + "\n");

      System.out.println(x + " " + y);

      for (int i=1; i<=division_number; i++) {

        y += h * defineFunction(x, y);
        x = initial_x + i * h;

        fout.write(x + " " + y + "\n");
        System.out.println(x + " " + y);

      }

      fout.close();

      return y;

    } catch (Exception e) {
      System.out.println(e);
      return -1;
    }

  }  //  double calculateEuler()


  // 修正オイラー法
  public double calculateModifiedEuler() {

    try {

      FileWriter fout = new FileWriter("modified_euler.txt");

      double x = initial_x;
      double y = initial_y;
      double h = (maximum_x - initial_x) / (double)division_number;

      fout.write(x + " " + y + "\n");
      System.out.println(x + " " + y);

      for (int i=1; i<=division_number; i++) {

        y += h * defineFunction(x, y) + h * h * defineDerivedFunction(x, y) / 2;
        x = initial_x + i * h;

        fout.write(x + " " + y + "\n");
        System.out.println(x + " " + y);
      }

      fout.close();

      return y;

    } catch (Exception e) {
      System.out.println(e);
      return -1;
    }

  }  //  double calculateEuler()


  // ルンゲ・クッタ法
  public double calculateRungeKutta() {

    try {

      double x = initial_x;
      double y = initial_y;
      double h = (maximum_x - initial_x) / (double)division_number;
      double k1, k2, k3, k4;  // 4次

      FileWriter fout = new FileWriter("runge_kutta.txt");

      fout.write(x + " " + y + "\n");
      System.out.println(x + " " + y);

      for (int i=1; i<=division_number; i++) {

        k1 = h * defineFunction(x, y);
        k2 = h * defineFunction(x + h/2, y + k1/2);
        k3 = h * defineFunction(x + h/2, y + k2/2);
        k4 = h * defineFunction(x + h, y + k3);

        y += (k1 + 2*k2 + 2*k3 + k4) / 6;
        x = initial_x + i * h;

        fout.write(x + " " + y + "\n");
        System.out.println(x + " " + y);

      }

      fout.close();

      return y;

    } catch (Exception e) {
      System.out.println(e);
      return -1;
    }

  }  // double calculateRungeKutta()

}  // class DifferentialEquationSolver
