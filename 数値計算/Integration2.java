// 単位円の方程式の区間[0, 1]の面積を，区分求積法，中点法，台形法それぞれによって求めて4倍

public class Integration2 {

  static final double X_MAX = 1.0; //xの区間
  static final double DIV_NUM = 100.0; //分割数
  static final double MIN_DIV = X_MAX/DIV_NUM; //分割値

  public static void main (String [] args) {

    double dx = MIN_DIV;
    double x = 0.0;
    double sum_parts = 0.0;
    double sum_midpoint = 0.0;
    double sum_trapezoid = 0.0;

    double y0;
    double y1;
    double y2;

    Integration2 integration = new Integration2();

    for (int n=0; n<DIV_NUM; n++) {

      y0 = integration.defineFunction(x);
      y1 = integration.defineFunction(x+dx/2.0);
      y2 = integration.defineFunction(x+dx);

      sum_parts += y0 * dx;
      sum_midpoint += y1 * dx;
      sum_trapezoid += (y0 + y2) * dx/2.0;

      x += dx;
    }

    System.out.println("理論値: " + Math.PI);
    System.out.println("区分求積法: " + sum_parts * 4.0);
    System.out.println("中点法: " + sum_midpoint * 4.0);
    System.out.println("台形法: " + sum_trapezoid * 4.0);

  }

  double defineFunction(double x) {
    return Math.sqrt(1-x*x);
  }

}
