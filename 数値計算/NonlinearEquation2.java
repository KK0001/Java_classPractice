// f(x) = x2 - 5　の根を2分法，ニュートン法，割線法を使って求める


public class  NonlinearEquation2 {

  static final double EPS = 10e-5; //イプシロン

  public static void main(String [] args) {

    double ansBisection = 0.0;
    double ansNewton = 0.0;
    double ansDigitalNewton = 0.0;

    NonlinearEquation2 nonEqu2 = new NonlinearEquation2();

    ansBisection = nonEqu2.calculateBisection(1.0, 3.0);
    ansNewton = nonEqu2.calculateNewton(3.0);
    ansDigitalNewton = nonEqu2.calculateDigitalNewton(4.0, 3.0);

    System.out.println("理論値: " + Math.sqrt(5));
    System.out.println("2分法: " + ansBisection);
    System.out.println("ニュートン法: " + ansNewton);
    System.out.println("割線法: " + ansDigitalNewton);

  }  // main

 //対象の関数を定義
  double defineFunction(double x) {
    return x*x-5;
  }
  
  // ↑の微分
  double deriveFunction(double x) {
    return 2*x;
  }

  // 2分法
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
    }

    return c;

  }  // calculateBisection


  // ニュートン法
  double calculateNewton(double x) {

    double dx = 0.0;

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

      x2 = x1 - ( defineFunction(x1) * dx/dy);

      if (Math.abs(dx/x1) < EPS) break;

    }

    return x2;

  }  // calculateDigitalNewton


}  // class  NonlinearEquation
