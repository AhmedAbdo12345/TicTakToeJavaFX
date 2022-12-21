package tictaktoejavafx.controller;

import java.io.IOException;
import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tictaktoejavafx.data.model.PlayerOffline;
import tictaktoejavafx.data.server.ServerConnection;
import tictaktoejavafx.utils.Config;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.UserMessage;
import tictaktoejavafx.view.WinnerAndlosserScreenBase;
import tictaktoejavafx.utils.CallBackAction;

public class WinnerAndLosserController extends WinnerAndlosserScreenBase {

    private final Stage stage;
    MediaPlayer mediaPlayer;

    public WinnerAndLosserController(Stage stage) {
        this.stage = stage;
        user_win.setText(PlayerOffline.getPlayerName());
        String name = PlayerOffline.getPlayerName();
        if (Navigator.isOnline) {
            if (Navigator.startGame) {
                if (Navigator.getPlayerOne().equals(Navigator.getOnlineWinner())) {
                    user_win.setText(Navigator.getPlayerOne());
                    String videoPath = Paths.get(Config.WINNER_VIDEO).toUri().toString();
                    mediaVideo(videoPath);
                } else if (Navigator.getOnlineWinner().equals("DRAW")) {
                    String videoPath = Paths.get(Config.DRAW_VIDEO).toUri().toString();
                    mediaVideo(videoPath);

                } else {
                    user_win.setText(Navigator.getPlayerTwo());
                    String videoPath = Paths.get(Config.LOSSER_VIDEO).toUri().toString();
                    mediaVideo(videoPath);

                }

            } else {

                if (Navigator.getPlayerOne().equals(Navigator.getOnlineWinner())) {
                    user_win.setText(Navigator.getPlayerOne());
                    String videoPath = Paths.get(Config.LOSSER_VIDEO).toUri().toString();
                    mediaVideo(videoPath);
                } else if(Navigator.getOnlineWinner().equals("DRAW")){
                    String videoPath = Paths.get(Config.DRAW_VIDEO).toUri().toString();
                    mediaVideo(videoPath);

                }else{
                    user_win.setText(Navigator.getPlayerTwo());
                    String videoPath = Paths.get(Config.WINNER_VIDEO).toUri().toString();
                    mediaVideo(videoPath);
                
                }

            }
            Navigator.setIsOnline(false);
        } else {
            if (name.equals("Player 1")) {
                String videoPath = Paths.get(Config.WINNER_VIDEO).toUri().toString();

                mediaVideo(videoPath);
            } else if (name.equals("Player 2")) {
                String videoPath = Paths.get(Config.LOSSER_VIDEO).toUri().toString();
                mediaVideo(videoPath);

            } else {
                String videoPath = Paths.get(Config.DRAW_VIDEO).toUri().toString();
                mediaVideo(videoPath);
            }
        }
        this.stage.setOnCloseRequest((WindowEvent event) -> {
            try {
                ServerConnection.closeThread();
            } catch (IOException ex) {
                new UserMessage().display(ex.getMessage(), new CallBackAction() {
                    @Override
                    public void sendOk() {
                        Navigator.navigate(Navigator.WELCOME, stage);
                    }

                    @Override
                    public void sendCancel() {
                        // Do Nothing
                    }
                }, Alert.AlertType.ERROR);
            }
        });
    }

    void mediaVideo(String videoPlayPath) {
        Media media = new Media(videoPlayPath);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }

    @Override
    protected void onHomeButtonClicked(ActionEvent actionEvent) {
        mediaPlayer.stop();

        Navigator.navigate(Navigator.WELCOME, stage);
    }

    @Override
    protected void onPlayAgainClicked(ActionEvent actionEvent) {
        mediaPlayer.stop();

        Navigator.navigate(Navigator.RECORD, stage);
    }

    @Override
    protected void onResultsClicked(ActionEvent actionEvent) {
        mediaPlayer.stop();
    }
}
