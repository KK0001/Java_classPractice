// 常微分方程式をオイラー法の近似式で表わす
// 1.入力関数を定義
// 2.入力関数の微分を定義
// 3.メインのクラスでのインストラクタの引数を書き換える
// 4.実行


import java.io.*;

public class DifferentialEquationCalculation {

  public static void main(String [] args) {

    //(分割数,x初期値,y初期値,xの範囲(0~))
    DifferentialEquationSolver des = new DifferentialEquationSolver(100, 0.0, 0.0, 10.0);

    // 算出
    des.calculateModifiedEuler(); //修正オイラー法
    // des.calculateEuler(); //オイラー法

  }

}  // class DifferentialEquationCalculation




//オイラー法
class DifferentialEquationSolver {

  // フィールド
  int division_number; //次元数?
  double initial_x; // x初期値
  double initial_y; // y初期値
  double maximum_x; // xの範囲(0~)

  // コンストラクタ
  DifferentialEquationSolver(int n, double xi, double yi, double xm) {
    division_number = n;
    initial_x = xi;
    initial_y = yi;
    maximum_x = xm;
  }


  //関数の定義(2変数)
  public double defineFunction(double x, double y) {
    return (x*x - y)/(10*20);
  }

  //↑の関数の微分(xで微分。yもxの関数であることに注意。)
  public double defineDerivedFunction(double x, double y) {
    return (2*x - defineFunction(x, y))/(10*20);
  }

  //オイラー法
  double calculateEuler() {

    try {

      FileWriter fout = new FileWriter("euler.txt");

      double x = initial_x;
      double y = initial_y;
      double h = (maximum_x - initial_x) / (double)division_number;  //分割値？

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
  double calculateModifiedEuler() {

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

}  // class DifferentialEquationSolver
