
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

// for patternmatching
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CheckSIDApp extends Application {

    public static String gakuban = "16EC043"; 
    public static String yourname = "小瀬良開光";

    public static boolean checkSID(String sid) {
        Pattern p = Pattern.compile("^[0-9][0-9][a-zA-Z][a-zA-Z][0-9][0-9][0-9]$");
        Matcher m = p.matcher(sid);

        return m.find();
    }

    @Override
    public void start(Stage primaryStage) {
        // ラベルを作成する
        Label label = new Label("学籍番号");
        // ボタンを作成する
        Button button = new Button("確認");
        // テキストフィールドを作成する
        TextField textField = new TextField();
        Label label2 = new Label("");
        
        // ボタンのアクションを登録する
        button.setOnAction((ActionEvent event) -> {
            String name = textField.getText().trim();
            if (checkSID(name)) {
                label2.setText("OK");
            }else{
                label2.setText("NG");
            }
        });

        // ペインを作成し、コントロールを配置する
        VBox pane = new VBox(label, textField, button, label2);
        // シーンを作成し、ペインに入れる
        Scene scene = new Scene(pane, 300, 100);
        // ステージにペインを入れて、タイトルを設定する
        primaryStage.setScene(scene);
        primaryStage.setTitle("-");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
        System.out.println("--CheckSIDApp");
    }

}
