// Exercise 05: Golden Button Application
//package ex05;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

public class GoldenButtonApp extends Application {

    public static String gakuban = "16EC999"; // 学籍番号を入力すること
    public static String yourname = "電大太郎"; // 氏名を入力すること
    
    Scene askScene, goldScene, silverScene, copperScene, honestScene;
    Label askLabel, goldLabel, silverLabnel, copperLabel, honestLabel;
    Button goldButton, silverButton, copperButton, yesButton, noButton, restartButton, exitButton;
    
    @Override
    public void start(Stage primaryStage) {
        // askScene
        askLabel = new Label("ボタンをどれか押してください");
        goldButton = new Button("金");
        silverButton = new Button("銀");
        copperButton = new Button("銅");
        
        HBox askHBox1 = new HBox(askLabel);
        HBox askHBox2 = new HBox(10,goldButton,silverButton,copperButton);
        askHBox1.setAlignment(Pos.CENTER);
        askHBox2.setAlignment(Pos.CENTER);
        VBox askVBox = new VBox(10,askHBox1,askHBox2);
        askScene = new Scene(askVBox, 300, 100);

        // goldScene
        askLabel = new Label("ボタンをどれか押してください");
        goldButton = new Button("金");
        silverButton = new Button("銀");
        copperButton = new Button("銅");
        
        HBox askHBox1 = new HBox(askLabel);
        HBox askHBox2 = new HBox(10,goldButton,silverButton,copperButton);
        askHBox1.setAlignment(Pos.CENTER);
        askHBox2.setAlignment(Pos.CENTER);
        VBox askVBox = new VBox(10,askHBox1,askHBox2);
        askScene = new Scene(askVBox, 300, 100);
        
        // sulverScene
        
        // copperScene
        
        
        // honestScene
        // Create Scene2
        // 以下のコードはダミー。課題04-2のコードで書き換え
//        label2 = new Label("0");
//        VBox pane2 = new VBox(10, label2);
//        pane2.setAlignment(Pos.CENTER);
//        scene2 = new Scene(pane2, 200, 200);

        // Add the scene to the stage, set the title and show the stage
        primaryStage.setScene(askScene);
        primaryStage.setTitle("CountUpDownApp");
        primaryStage.show();
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--GoldenButtonApp");
    }

}

/* 考察 -- 調査したこと、考慮したこと、工夫したことを記述




 */
