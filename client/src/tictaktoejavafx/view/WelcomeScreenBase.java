package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import tictaktoejavafx.utils.Navigator;

public abstract class WelcomeScreenBase extends AnchorPane {

    protected final Label label;
    protected final Button btn_single;
    protected final Button btn_two;
    protected final Button btn_online_mode;
    protected final ImageView imageView;
    protected final Button isRecord;
    protected final Button btn_History_Mode;

    public WelcomeScreenBase() {

        label = new Label();
        btn_single = new Button();
        btn_two = new Button();
        btn_online_mode = new Button();
        imageView = new ImageView();
        isRecord = new Button();
        btn_History_Mode = new Button();


        setId("AnchorPane");
        setPrefHeight(575.0);
        setPrefWidth(645.0);

        label.setLayoutX(105.0);
        label.setLayoutY(34.0);
        label.setPrefHeight(45.0);
        label.setPrefWidth(350.0);
        label.getStyleClass().add("title");
        label.setText("welcome in Tic Tac Toe");
        label.setFont(new Font("System Bold", 30.0));

        btn_single.setLayoutX(188.0);
        btn_single.setLayoutY(269.0);
        btn_single.setMnemonicParsing(false);
        btn_single.setOnAction(this::isSingle);
        btn_single.setPrefHeight(45.0);
        btn_single.setPrefWidth(214.0);
        btn_single.getStyleClass().add("main_button");
        btn_single.setText("Single Player");
        btn_single.setTextFill(javafx.scene.paint.Color.valueOf("#0a3257"));
        btn_single.setFont(new Font(22.0));
        
            Image img = new Image("file:/C:/Users/Ahmed/Desktop/English img/pc.png");
      ImageView view = new ImageView(img);
        view.setFitHeight(40);
        view.setFitWidth(40);
      view.setPreserveRatio(true);
       btn_single.setGraphic(view);
//------------------------------------
            Image img2 = new Image("file:/C:/Users/Ahmed/Desktop/English img/multi.png");
      ImageView view2 = new ImageView(img2);
        view2.setFitHeight(40);
        view2.setFitWidth(40);
      view2.setPreserveRatio(true);
       btn_two.setGraphic(view2);
//-------------------------------------


            Image img3 = new Image("file:/C:/Users/Ahmed/Desktop/English img/online.png");
      ImageView view3 = new ImageView(img3);
        view3.setFitHeight(40);
        view3.setFitWidth(40);
      view3.setPreserveRatio(true);
       btn_online_mode.setGraphic(view3);
//-------------------------------------
        btn_two.setLayoutX(188.0);
        btn_two.setLayoutY(328.0);
        btn_two.setMnemonicParsing(false);
        btn_two.setOnAction(this::isTwo);
        btn_two.setPrefHeight(45.0);
        btn_two.setPrefWidth(214.0);
        btn_two.getStyleClass().add("main_button");
        btn_two.setText("Two Player");
        btn_two.setTextFill(javafx.scene.paint.Color.valueOf("#0a3257"));
        btn_two.setFont(new Font(22.0));
   

        btn_online_mode.setLayoutX(188.0);
        btn_online_mode.setLayoutY(388.0);
        btn_online_mode.setMnemonicParsing(false);
        btn_online_mode.setOnAction(this::isOnlineMode);
        btn_online_mode.setPrefHeight(45.0);
        btn_online_mode.setPrefWidth(214.0);
        btn_online_mode.getStyleClass().add("main_button");
        btn_online_mode.setText("Online Mode");
        btn_online_mode.setTextFill(javafx.scene.paint.Color.valueOf("#0a3257"));
        btn_online_mode.setFont(new Font(22.0));

        imageView.setFitHeight(165.0);
        imageView.setFitWidth(176.0);
        imageView.setLayoutX(199.0);
        imageView.setLayoutY(79.0);
        imageView.getStyleClass().add("logo");
//        imageView.setImage(new Image(getClass().getResource("../assets/XOpicture.jpg").toExternalForm()));


        isRecord.setLayoutX(185.0);
        isRecord.setLayoutY(518.0);
        isRecord.setMnemonicParsing(false);
        isRecord.setOnAction(this::isRecorded);
        isRecord.setPrefHeight(48.0);
        isRecord.setPrefWidth(214.0);
        isRecord.setText("Record Mode");
        isRecord.setFont(new Font(22.0));
        btn_History_Mode.setLayoutX(190.0);
        btn_History_Mode.setLayoutY(449.0);
        btn_History_Mode.setMnemonicParsing(false);
        btn_History_Mode.setOnAction(this::isHistoryMode);
        btn_History_Mode.setPrefHeight(45.0);
        btn_History_Mode.setPrefWidth(214.0);
        btn_History_Mode.setText("History Mode");
        btn_History_Mode.setFont(new Font(22.0));

        getChildren().add(label);
        getChildren().add(btn_single);
        getChildren().add(btn_two);
        getChildren().add(btn_online_mode);
        getChildren().add(imageView);
        getChildren().add(isRecord);
        getChildren().add(btn_History_Mode);

    }

    protected abstract void isSingle(javafx.event.ActionEvent actionEvent);

    protected abstract void isTwo(javafx.event.ActionEvent actionEvent);
    protected abstract void isOnlineMode(javafx.event.ActionEvent actionEvent);
    protected abstract void isRecorded(javafx.event.ActionEvent actionEvent);
    protected abstract void isHistoryMode(javafx.event.ActionEvent actionEvent);

}
