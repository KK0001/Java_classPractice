//Gauss-Jordan法
// 1.degreeを設定
// 2.行列を入力
// 3.既知ベクトルを入力
// 4.未知ベクトルの要素数を対応させる
// 5.実行

public class LinearEquationCalculation2{

  public static void main(String [] args) {

  try {
    int degree = 5;  //行列の行数
    double [][] coefficient_matrix = { {  5.31, -2.55,  5.12, 3.20, 2.74},
                                       {  3.76, 3.40, 4.24, -4.56, 5.26},
                                       {  2.60, 4.61,  -3.16, 5.38, 1.37},
                                       {  -4.82, 1.45,  4.20, 5.14, 3.63},
                                        {  1.59, -5.40,  2.06, -3.18, 4.96}};  //行列
    double [] unknown_vector = {0.0, 0.0, 0.0, 0.0, 0.0};  //求める未知ベクトル(解ベクトル)
    double [] known_vector = {7.25, -5.88, 8.30, -6.45, 9.32};  //既知ベクトル

    LinearEquationSolver2 les = new LinearEquationSolver2(degree, coefficient_matrix, unknown_vector, known_vector);

    unknown_vector = les.calculateGJE();

    System.out.println("Gaussian-Jordan Elimination: ");
    for (int i=0; i<degree; i++) {
      System.out.println("x[" + i + "] = " + unknown_vector[i]);
    }
  } catch (Exception e) {
    System.out.println(e);
  }

  }  // main

}  // class LinearEquationCalculation





//Solver
class LinearEquationSolver2 {

  // フィールド
  int degree;
  double [][] coefficient_matrix;
  double [] unknown_vector;
  double [] known_vector;

  // コンストラクタ
  LinearEquationSolver2(int n, double [][] matrix, double [] vector1, double [] vector2) {
    degree = n;
    coefficient_matrix = matrix;
    unknown_vector = vector1;
    known_vector = vector2;
  }

  // Gauss消去法の計算
  // public double [] calculateGE() {  // GE: Gaussian Elimination
  //
  //   double pivot;
  //   double solution_element;
  //   double coefficient_element;
  //
  //   for (int k=0; k<degree-1; ++k) {
  //
  //     pivot = coefficient_matrix[k][k];
  //
  //     for (int j=k+1; j<degree; ++j) {
  //       coefficient_matrix[k][j] /= pivot;
  //     }
  //
  //     known_vector[k] /= pivot;
  //
  //
  //     for (int i=k+1; i<degree; ++i) {
  //       coefficient_element = coefficient_matrix[i][k];
  //
  //       for (int j=k+1; j<degree; ++j) {
  //         coefficient_matrix[i][j] -= coefficient_element * coefficient_matrix[k][j];
  //       }
  //
  //       known_vector[i] -= coefficient_element * known_vector[k];
  //     }
  //   }
  //
  //   unknown_vector[degree-1] = known_vector[degree-1] / coefficient_matrix[degree-1][degree-1];
  //
  //
  //   for (int k=degree-2; k>=0; --k) {
  //
  //     solution_element = known_vector[k];
  //
  //     for (int j=k+1; j<degree; ++j) {
  //       solution_element -= coefficient_matrix[k][j] * unknown_vector[j];
  //     }
  //
  //     unknown_vector[k] = solution_element;
  //   }
  //
  //
  //   return unknown_vector;
  // } // calculateGE()



  // Gauss-Jordan法の計算
  public double [] calculateGJE() {  // GJE: Gaussian-Jordan Elimination

    double pivot;
    double solution_element;
    double coefficient_element;

    // Gauss-Jordan
    for (int k=0; k<degree; ++k) {

      pivot = coefficient_matrix[k][k];

      coefficient_matrix[k][k] = 1.0;

      for (int j=k+1; j<degree; ++j) {
        coefficient_matrix[k][j] /= pivot;
      }

      known_vector[k] /= pivot;

      for (int i=0; i<degree; ++i) {
        if (i != k) {

          coefficient_element = coefficient_matrix[i][k];
          coefficient_matrix[i][k] = 0.0;

          for (int j=k+1; j<degree; ++j) {
            coefficient_matrix[i][j] -= coefficient_element * coefficient_matrix[k][j];
          }

          known_vector[i] -= coefficient_element * known_vector[k];
        }
      }
    }

    return known_vector;

  }  // calculateGJE()


}  // class LinearEquationSolver
