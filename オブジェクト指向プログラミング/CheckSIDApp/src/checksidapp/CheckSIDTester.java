// Exercise 02-1T: CheckSID Method Tester
//package ex02;

public class CheckSIDTester {

    static int score = 1, maxScore = 10;
    static String appName = "CheckSID";
    static String method = "checkSID";

    static void executeTest() {
        String[] param1 = { // Checkpoint 1
            "12EC345", "23E4567", "34EC56", "45EC6789", "56ec789",
            "67Ec890", "A12EC345", "00ec000", "",};
        boolean[] expect = { // Checkpoint 2
            true, false, false, false, true, true, false, true, false,};
        int passed = 0;
        for (int i = 0; i < param1.length; i++) {
            String info1 = "", info2 = "";
            Exception ex = null;
            boolean returned = false; // Checkpoint 3
            try {
                returned = CheckSIDApp.checkSID(param1[i]); // Checkpoint 4
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
                appName, CheckSIDApp.gakuban, CheckSIDApp.yourname, score));
    }

    // Main method
    public static void main(String[] args) {
        executeTest();
    }

}
