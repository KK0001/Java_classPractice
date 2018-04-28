// Exercise 03-1T: AddTax Lambda Expression Tester
package addtaxapp;

public class AddTaxTester {

    static int score = 1, maxScore = 10;
    static String appName = "AddTax";
    static String method = "applyAsLong";

    static void executeTest() {
        long[] param1 = { // Checkpoint 1
            1000, 10, 100, 200, 500, 3000, 43210,
            5000000000L, 9876543210L,};
        long[] expect = { // Checkpoint 2
            1080, 10, 100, 210, 540, 3240, 46660,
            5400000000L, 10666666660L,};
        int passed = 0;
        for (int i = 0; i < param1.length; i++) {
            String info1 = "", info2 = "";
            Exception ex = null;
            long returned = 0; // Checkpoint 3
            try {
                returned = AddTaxApp.addTax.applyAsLong(param1[i]); // Checkpoint 4
                if (expect[i] == returned) { // Checkpoint /5
                    info1 = "OK";
                    score++;
                } else {
                    info1 = "NG";
                    info2 = String.format(" <= 正解は %s", expect[i]);
                }
            } catch (Exception e) {
                info1 = "NG";
                info2 = "例外が発生しました";
                ex = e;
            } finally {
                String line = String.format("*** Test#%d %s %s(\"%s\") => ",
                        i + 1, info1, method, param1[i]);
                if ("OK".equals(info1)) {
                    System.out.println(line + returned + info2);
                } else if (ex == null) {
                    System.err.println(line + returned + info2);
                } else {
                    System.err.println(line + info2);
                    ex.printStackTrace();
                }
            }
        }
        printScore(null);
    }

    static void printScore(String msg) {
        if (msg != null) {
            System.err.println("ERROR! " + msg);
        }
        System.out.println(String.format(
                "\n【実行対象:%s, 学籍番号:%s, 学生氏名:%s, 評点:%d】",
                appName, AddTaxApp.gakuban, AddTaxApp.yourname, score));
    }

    // Main method
    public static void main(String[] args) {
        executeTest();
    }

}