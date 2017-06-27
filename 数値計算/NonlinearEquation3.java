/* ���t�����
 * ���K6.7
 * f(x) = x^2 + x - 6�@�̍�(> 0)��2���@�C�j���[�g���@�C�����@���g���ċ��߂�
 * �v���O���������D�������C2���@�C�j���[�g���@�C�����@�͂��ꂼ��
 * ���\�b�h�Ƃ��C���C���֐�����Ăяo���Ă��ꂼ��̌��ʂ�\��
 * ���邱�ƁD�܂��C���[0, 5]�C�� = 10E-5�Ƃ���D
 */


public class  NonlinearEquation3 {

  static final double EPS = 10e-5; //イプシロン

  public static void main(String [] args) {

    double ansBisection = 0.0;
    double ansNewton = 0.0;
    double ansDigitalNewton = 0.0;

    NonlinearEquation3 nonEqu = new NonlinearEquation3();

    ansBisection = nonEqu.calculateBisection(0.0, 5.0);
    ansNewton = nonEqu.calculateNewton(5.0);
    ansDigitalNewton = nonEqu.calculateDigitalNewton(5.0, 4.0);

    System.out.println("理論値: " + (-1+Math.sqrt(1*1-4*1*(-6)))/(2*1));
    System.out.println("2分法: " + ansBisection);
    System.out.println("ニュートン法: " + ansNewton);
    System.out.println("割線法: " + ansDigitalNewton);

  }  // main

  //関数の定義
  double defineFunction(double x) {
    return x*x + x - 6;
  }

  // ↑の関数の微分
  double deriveFunction(double x) {
    return 2*x + 1;
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
