// f(x) = x2 - 3　の根を2分法を使って求める

public class  NonlinearEquation {

  static final double EPS = 10e-5; //イプシロン

  public static void main(String [] args) {

    double ansBisection = 0.0;

    NonlinearEquation nonEqu = new NonlinearEquation(); //インスタンス

    ansBisection = nonEqu.calculateBisection(1.0, 3.0); //2分法

    System.out.println("理論値: " + Math.sqrt(3));
    System.out.println("2分法: " + ansBisection);

  }  // main

  double defineFunction(double x) {
    return x*x-3;
  }

  // 2分法のメソッド
  double calculateBisection(double a, double b) {

    double c = 0.0;
    double fa;
    double fc;

    int n = (int)(Math.log((b-a)/EPS)/Math.log(2.) + 0.5);

    for (int i=0; i<n; i++) {
      c = (a + b) / 2.0;

      fa = defineFunction(a);
      fc = defineFunction(c);

      if ( fa * fc < 0) {

        b = c;

      } else {

        a = c;

      }
    }//for

    return c;

  }  // calculateBisection

}  // class  NonlinearEquation
