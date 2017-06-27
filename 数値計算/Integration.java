// 積分
// 1.関数を定義
// 2.分割数,区間を設定
// 3.実行

public class Integration {

  static final int DIV_NUM = 100; //分割数
  static final double X_MAX = 1.0; //xの区間(0~)
  static final double MIN_DIV = X_MAX/(double)DIV_NUM; //分割

  public static void main (String [] args) {

    double dx = MIN_DIV; //dx
    double x = 0.0;  //x
    double sum_parts = 0.0; //区分求積法
    double sum_midpoint = 0.0; //中点法
    double sum_trapezoid = 0.0; //台形法

    double y0 = 0.0;
    double y1 = 0.0;
    double y2 = 0.0;

    Integration integration = new Integration();

    for (int i=0; i<DIV_NUM; i++) {

      y0 = integration.defineFunction(x); //区分求積法,台形法用
      y1 = integration.defineFunction(x+dx/2); //中点法用
      y2 = integration.defineFunction(x+dx); //台形法用

      sum_parts += y0*dx;  //区分求積法
      sum_midpoint += y1*dx; //中点法
      sum_trapezoid += (y0+y2)*dx/2; //台形法

      x += dx;
    }

    System.out.println("理論値: " + 0.5); //目指すところ
    System.out.println("区分求積法: " + sum_parts);
    System.out.println("中点法: " + sum_midpoint);
    System.out.println("台形法: " + sum_trapezoid);
  }

  //積分する関数の定義
  double defineFunction(double x) {
    return x;
  }

}
