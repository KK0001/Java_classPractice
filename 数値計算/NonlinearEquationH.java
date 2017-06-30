// 根を求める
// 2分法, ニュートン法, 割線法

/* 方法 */
// 1.関数と関数の微分を定義
// 2.イプシロンを定義
// 3.初期値を設定
// 4.実行

public class  NonlinearEquationH {

  static final double EPS = 10e-5; //イプシロン

  public static void main(String [] args) {

    double ansBisection = 0.0;
    double ansNewton = 0.0;
    double ansDigitalNewton = 0.0;

    NonlinearEquationH nonEqu = new NonlinearEquationH();


    // System.out.println();

    ansBisection = nonEqu.Hanpuku(1.0, 2.0);
    // ansNewton = nonEqu.calculateNewton(1.0);
    // ansDigitalNewton = nonEqu.calculateDigitalNewton(5.0, 4.0);

    // System.out.println("理論値: " + (-1+Math.sqrt(1*1-4*1*(-6)))/(2*1));
    // System.out.println("2分法: " + ansBisection);
    // System.out.println("ニュートン法: " + ansNewton);
    // System.out.println("割線法: " + ansDigitalNewton);

  }  // main

  // //関数の定義
  // double defineFunction(double x) {
  //   // return Math.exp(x)+Math.cos(x)-4;
  //   return Math.exp(x/2.0)+3*(x*x)-2;
  // }
  //
  // // ↑の関数の微分
  // double deriveFunction(double x) {
  //   // return Math.exp(x)-Math.sin(x);
  //   return Math.exp(x/2.0)/2.0 +6*x ;
  // }

  // 2分法
  double Hanpuku(double a, double b) {

    double c = 0.0;
    double fa;
    double fc;

    int n = (int)(Math.log((b-a)/EPS)/Math.log(2.) + 0.5);

    System.out.println(n);
    //
    // for (int i=0; i<n; i++) {
    //   c = (a + b) / 2.0;
    //   if ( defineFunction(a) * defineFunction(c) < 0) {
    //     b = c;
    //   } else {
    //     a = c;
    //   }
    // }

    return c;

  }  // calculateBisection

}  // class  NonlinearEquation
