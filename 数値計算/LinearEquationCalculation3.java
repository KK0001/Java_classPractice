//逆行列計算
// 1.degreeを設定
// 2.行列を入力
// 3.実行

public class LinearEquationCalculation3{

  public static void main(String [] args) {

    int degree = 5;  //行列の行数
    double [][] square_matrix = { {  5.31, -2.55,  5.12, 3.20, 2.74},
                                       {  3.76, 3.40, 4.24, -4.56, 5.26},
                                       {  2.60, 4.61,  -3.16, 5.38, 1.37},
                                       {  -4.82, 1.45,  4.20, 5.14, 3.63},
                                        {  1.59, -5.40,  2.06, -3.18, 4.96}};  //行列

    // System.out.println(degree + "�������s��\n");
    // for(int i=0; i<degree; i++) {
    //   for (int j=0; j<degree; j++) {
    //     System.out.print(" " + square_matrix[i][j]);
    //   }
    //   System.out.print("\n");
    // }

    LinearEquationSolver3 les = new LinearEquationSolver3(degree, square_matrix);

    square_matrix = les.calculateInverseMatrix();

    System.out.println("逆行列: ");
    for(int i=0; i<degree; i++) {
      for (int j=0; j<degree; j++) {
        System.out.print(" " + square_matrix[i][j]);
      }
      System.out.print("\n");
    }

  }  // main

}  // class LinearEquationCalculation3










//Solver
class LinearEquationSolver3 {

  // フィールド
  int degree;
  double [][] coefficient_matrix;
  double [] unknown_vector;
  double [] known_vector;

  // コンストラクタ
  LinearEquationSolver3(int n, double [][] matrix, double [] vector1, double [] vector2) {
    degree = n;
    coefficient_matrix = matrix;
    unknown_vector = vector1;
    known_vector = vector2;
  }

  // コンストラクタ
  LinearEquationSolver3(int n, double [][] matrix) {
    degree = n;
    coefficient_matrix = matrix;
  }

  // // Gauss�̏����@���s�����\�b�h
  // public double [] calculateGE() {  // GE: Gaussian Elimination
  //
  //   double pivot;  // �s�{�b�g
  //   double solution_element;  // ���m�x�N�g���̊e��v�f
  //   double coefficient_element;  // �W���x�N�g���̊e�W���v�f
  //
  //   // Gauss�̏����@�̌v�Z
  //   // �O�i����
  //   for (int k=0; k<degree-1; ++k) {
  //
  //     // k�s�ڂ̌v�Z
  //     // ��k�s�̎��̃s�{�b�g�����D
  //     pivot = coefficient_matrix[k][k];
  //
  //     // �W���s��k�s�ڂ�j��ȍ~�����Ƀs�{�b�g�Ŋ���D
  //     for (int j=k+1; j<degree; ++j) {
  //       coefficient_matrix[k][j] /= pivot;
  //     }
  //
  //     // k�s�̊��m�x�N�g�����s�{�b�g�Ŋ���D
  //     known_vector[k] /= pivot;
  //
  //
  //     // k+1�s�ڈȍ~�̌v�Z
  //     for (int i=k+1; i<degree; ++i) {
  //       // i�sk��̌W���v�f��coefficient_element�ɑ��
  //       coefficient_element = coefficient_matrix[i][k];
  //
  //       for (int j=k+1; j<degree; ++j) {
  //         // �W���s���i�sj�񂩂�k�s��coefficient_matrix[i][k]�{������
  //         coefficient_matrix[i][j] -= coefficient_element * coefficient_matrix[k][j];
  //       }
  //
  //       known_vector[i] -= coefficient_element * known_vector[k];
  //     }
  //   }
  //
  //   // ���߂関�m�x�N�g���̍ŏI���������ɂ�苁�܂�D
  //   unknown_vector[degree-1] = known_vector[degree-1] / coefficient_matrix[degree-1][degree-1];
  //
  //
  //   // ��ޑ��
  //   for (int k=degree-2; k>=0; --k) {
  //     // k�s�̒萔�x�N�g����solution_element�ɑ������D
  //     solution_element = known_vector[k];
  //
  //     // ���m�x�N�g����j�s�̒l��k�s�̕������ɑ�����C
  //     // ���m�x�N�g����k�s�ڂ��v�Z����D
  //     for (int j=k+1; j<degree; ++j) {
  //       solution_element -= coefficient_matrix[k][j] * unknown_vector[j];
  //     }
  //
  //     // �v�Z���ʂ𖢒m�x�N�g����k�s�ڂɑ������D
  //     unknown_vector[k] = solution_element;
  //   }
  //
  //
  //   return unknown_vector;  // ���s���Ԃ�
  //
  // }  // calculateGE()
  //
  //
  // // Gauss-Jordan�@���s�����\�b�h
  // public double [] calculateGJE() {  // GJE: Gaussian-Jordan Elimination
  //
  //   double pivot;  // �s�{�b�g
  //   double solution_element;  // ���m�x�N�g���̊e��v�f
  //   double coefficient_element;  // �W���x�N�g���̊e�W���v�f
  //
  //   // Gauss-Jordan�@�̌v�Z
  //   for (int k=0; k<degree; ++k) {
  //
  //     // k�s�ڂ̌v�Z
  //     // ��k�s�̎��̃s�{�b�g�����D
  //     pivot = coefficient_matrix[k][k];
  //
  //     // �s�{�b�g�̓s�{�b�g���g�Ŋ����1�ɂȂ�̂ŁC�v�Z���Ȃ��D
  //     coefficient_matrix[k][k] = 1.0;
  //
  //     // �W���s��k�s�ڂ�j��ȍ~�����Ƀs�{�b�g�Ŋ���D
  //     for (int j=k+1; j<degree; ++j) {
  //       coefficient_matrix[k][j] /= pivot;
  //     }
  //
  //     // k�s�̊��m�x�N�g�����s�{�b�g�Ŋ���D
  //     known_vector[k] /= pivot;
  //
  //
  //     // k�s�ڈȊO�̌v�Z
  //     // �ŏI�I�Ȓ萔�x�N�g��known_vector[]���v�Z�ŏ㏑������ĉ��ƂȂ�D
  //     for (int i=0; i<degree; ++i) {
  //       if (i != k) {  // k�s�ڈȊO�̍s��x���̏����D
  //
  //         // i�sk��̌W���v�f��coefficient_element�ɑ��
  //         coefficient_element = coefficient_matrix[i][k];
  //         coefficient_matrix[i][k] = 0.0;
  //
  //         for (int j=k+1; j<degree; ++j) {
  //           // �W���s���i�sj�񂩂�k�s��coefficient_matrix[i][k]�{������
  //           coefficient_matrix[i][j] -= coefficient_element * coefficient_matrix[k][j];
  //         }
  //
  //         // �萔�x�N�g����k�s�ڈȊO�̍s����k�s�ڂ�coefficient_matrix[k+1][k]�{�������D
  //         known_vector[i] -= coefficient_element * known_vector[k];
  //       }
  //     }
  //   }
  //
  //   return known_vector;  // ���x�N�g����Ԃ�
  //
  // }  // calculateGJE()


  //逆行列の計算
  public double [][] calculateInverseMatrix() {
    double pivot;
    double coefficient_element;

    // Gauss-Jordan
    for (int k=0; k<degree; ++k) {

      pivot = coefficient_matrix[k][k];

      coefficient_matrix[k][k] = 1.0;

      for (int j=0; j<degree; ++j) {
        coefficient_matrix[k][j] /= pivot;
      }

      for (int i=0; i<degree; ++i) {
        if (i != k) {

          coefficient_element = coefficient_matrix[i][k];
          coefficient_matrix[i][k] = 0.0;


          for (int j=0; j<degree; ++j) {
            coefficient_matrix[i][j] -= coefficient_element * coefficient_matrix[k][j];
          }
        }
      }
    }

    return coefficient_matrix;

  }  // calculateInverseMatrix()


}  // class LinearEquationSolver
