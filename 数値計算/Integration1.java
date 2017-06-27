// f(x) = sin(x)の積分を区分求積法，中点法，台形法それぞれによって求める

public class Integration1 {

  static final double DIV_NUM = 100.0; //分割数
  static final double X_MAX = Math.PI; //xの範囲(0~)
  static final double MIN_DIV = X_MAX/DIV_NUM;  //分割値

  public static void main (String [] args) {

    double dx = MIN_DIV;
    double x = 0.0;
    double sum_parts = 0.0;
    double sum_midpoint = 0.0;
    double sum_trapezoid = 0.0;

    double y0;
    double y1;
    double y2;

    Integration1 integration = new Integration1();

    for (int n=0; n<DIV_NUM; n++) {

      y0 = integration.defineFunction(x);
      y1 = integration.defineFunction(x+dx/2.0);
      y2 = integration.defineFunction(x+dx);

      sum_parts += y0 * dx;
      sum_midpoint += y1 * dx;
      sum_trapezoid += ( y0 + y2 ) * dx/2.0;

      x+=dx;
    }

    System.out.println("理論値: " + (-Math.cos(Math.PI) - (-Math.cos(0.0))));
    System.out.println("区分求積法: " + sum_parts);
    System.out.println("中点法: " + sum_midpoint);
    System.out.println("台形法: " + sum_trapezoid);

  }

  double defineFunction(double x) {
    return Math.sin(x);
  }

}
