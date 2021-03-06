// 根を求める
// 2分法, ニュートン法, 割線法

/* 方法 */
// 1.関数と関数の微分を定義
// 2.イプシロンを定義
// 3.初期値を設定
// 4.実行

public class  NonlinearEquation {

  static final double EPS = 10e-5; //イプシロン

  public static void main(String [] args) {

    double ansBisection = 0.0;
    double ansNewton = 0.0;
    double ansDigitalNewton = 0.0;

    NonlinearEquation nonEqu = new NonlinearEquation();

    ansBisection = nonEqu.calculateBisection(1.0, 2.0);
    // ansNewton = nonEqu.calculateNewton(1.0);
    // ansDigitalNewton = nonEqu.calculateDigitalNewton(5.0, 4.0);

    // System.out.println("理論値: " + (-1+Math.sqrt(1*1-4*1*(-6)))/(2*1));
    System.out.println("2分法: " + ansBisection);
    // System.out.println("ニュートン法: " + ansNewton);
    // System.out.println("割線法: " + ansDigitalNewton);

  }  // main

  //関数の定義
  double defineFunction(double x) {
    // return Math.exp(x)+Math.cos(x)-4;
    // return Math.exp(x/2.0)+3*(x*x)-2;
    return 7*x*x -7*x -7;
  }

  // ↑の関数の微分
  double deriveFunction(double x) {
    // return Math.exp(x)-Math.sin(x);
    // return Math.exp(x/2.0)/2.0 +6*x;
    return 14*x -7;
  }

  // 2分法
  double calculateBisection(double a, double b) {

    double c = 0.0;
    double fa;
    double fc;

    int n = (int)(Math.log((b-a)/EPS)/Math.log(2.) + 0.5);

    for (int i=0; i<n; i++) {
      c = (a + b) / 2.0;
      if ( defineFunction(a) * defineFunction(c) < 0) {
        b = c;
      } else {
        a = c;
      }
    }

    return c;

  }  // calculateBisection

  // ニュートン法
  double calculateNewton(double x) {

    double dx=0.0;

    while (true) {

      dx = defineFunction(x) / deriveFunction(x);

      x -= dx;

      if (Math.abs(dx/x) < EPS) break;
    }

    return x;

  }  // calculateNewton


  // 割線法
  double calculateDigitalNewton(double x1, double x2) {

    double dx=0.0;
    double dy=0.0;

    while (true) {

      dx = x1 - x2;

      dy = defineFunction(x1) - defineFunction(x2);

      x1 = x2;

      x2 = x1 - (defineFunction(x1) * dx/dy);

      if (Math.abs(dx/x1) < EPS) break;

    }

    return x2;

  }  // calculateDigitalNewton


}  // class  NonlinearEquation
