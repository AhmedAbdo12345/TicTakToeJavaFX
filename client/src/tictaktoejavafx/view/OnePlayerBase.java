package tictaktoejavafx.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tictaktoejavafx.utils.Config;

public abstract class OnePlayerBase extends AnchorPane {

    protected final ImageView imageView;
    protected final TextField player_name;
    protected final Button StartGame;
    protected final Button button;

    public OnePlayerBase() {

        imageView = new ImageView();
        player_name = new TextField();
        StartGame = new Button();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(575.0);
        setPrefWidth(466.0);

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(133.0);
        imageView.setLayoutY(66.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.getStyleClass().add("logo");
        imageView.setImage(new Image(Config.LOGO));

        player_name.setLayoutX(121.0);
        player_name.setLayoutY(312.0);
        player_name.setPrefHeight(30.0);
        player_name.setPrefWidth(224.0);
        player_name.setPromptText("Player Name");
        player_name.getStyleClass().add("main_input");

        StartGame.setLayoutX(195.0);
        StartGame.setLayoutY(370.0);
        StartGame.setMnemonicParsing(false);
        StartGame.setOnAction(this::isStartGame);
        StartGame.getStyleClass().add("main_button");
        StartGame.setText("Start Game");

        button.setLayoutX(14.0);
        button.setLayoutY(14.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::onBackClicked);
        button.getStyleClass().add("back_button");
        button.setText("<");

        getChildren().add(imageView);
        getChildren().add(player_name);
        getChildren().add(StartGame);
        getChildren().add(button);

    }

    protected abstract void isStartGame(javafx.event.ActionEvent actionEvent);

    protected abstract void onBackClicked(javafx.event.ActionEvent actionEvent);

}
