//package ex03;
package addtaxapp;

import java.util.function.LongUnaryOperator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class AddTaxApp extends Application {

    public static String gakuban = "16EC000"; // 学籍番号を入力すること
    public static String yourname = "電大太郎"; // 氏名を入力すること

    // 税込み価格を計算するラムダ式
    public static LongUnaryOperator addTax = (price) -> 10*(long)((price * (1 + 0.01 * 8))*0.1);
	

    @Override
    public void start(Stage primaryStage) {

        Label label = new Label("税抜き価格");
        TextField textField1 = new TextField();
        Button button = new Button("税込み価格に変換する");
        TextField textField2 = new TextField();
        
        // ボタンのアクションを登録する
        button.setOnAction((event) -> { 
            long price;
            try {
                price = Long.valueOf(textField1.getText().trim());      
            } catch (Exception e) {
                price = -1;
            }
//            if()
            String taxed = String.format("%,d", addTax.applyAsLong(price));
            textField2.setText(taxed);
        });

        VBox pane = new VBox(label, textField1, button, textField2);
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("-");
        primaryStage.show();
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--AddTaxApp");
    }

}