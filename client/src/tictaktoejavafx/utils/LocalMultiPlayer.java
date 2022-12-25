package tictaktoejavafx.utils;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import tictaktoejavafx.controller.GameBoardControllerOnline;
import tictaktoejavafx.controller.GameBoardEasyController;
import tictaktoejavafx.controller.GameBoardMultiController;
import tictaktoejavafx.data.model.WinnerName;
import tictaktoejavafx.data.server.ServerConnection;
import tictaktoejavafx.view.GameBoardScreenBase;

public class LocalMultiPlayer {

    static int numberOfPresses = 0;
    static boolean gameEnded = false;

    public static boolean getGameEnded() {

        return gameEnded;
    }
   
private static int indexDiagonal=0;

    public static int getIndexDiagonal() {
        return indexDiagonal;
    }

    public static void setIndexDiagonal(int indexDiagonal) {
        LocalMultiPlayer.indexDiagonal = indexDiagonal;
    }

    public static void localMulti(ArrayList<String> d, Stage stage) {
        for (int i = 0; i < d.size(); i++) {

            if (d.get(i).equals("XXX")) {
                if (Navigator.isOnline) {
                    Navigator.setOnlineWinner(Navigator.getPlayerOne());
                }
             setIndexDiagonal(i+1);
             
                WinnerName.setWinnerName(Navigator.getPlayerOne());
                WinnerName.setWinnerName(Config.PLAYER_X);
                gameEnded = true;
                numberOfPresses = 0;
                GameBoardControllerOnline.arrlistButtons2 = null;
                ServerConnection.diagonals = null;
             
                  //   Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
   
             

            } else if (d.get(i).equals("OOO")) {

                if (Navigator.isOnline) {
                    Navigator.setOnlineWinner(Navigator.getPlayerTwo());
                }
                  setIndexDiagonal(i+1);
                WinnerName.setWinnerName(Navigator.getPlayerTwo());
                WinnerName.setWinnerName(Config.PLAYER_O);

                gameEnded = true;
                numberOfPresses = 0;
                GameBoardControllerOnline.arrlistButtons2 = null;
                ServerConnection.diagonals = null;
                //Navigator.setWinnerPlayer(Navigator.getPlayerTwo());
                Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
            }

        }
        numberOfPresses++;
    }

    public static void setGameEnded(boolean gameEnded) {
        LocalMultiPlayer.gameEnded = gameEnded;
    }

    public static void drawChecker(Stage stage) {
        if (numberOfPresses >= 9 && gameEnded == false) {
            if (Navigator.isOnline) {
                Navigator.setOnlineWinner("DRAW");
            }
            WinnerName.setWinnerName("DRAW");
            gameEnded = true;
            numberOfPresses = 0;
            GameBoardControllerOnline.arrlistButtons2 = null;
            ServerConnection.diagonals = null;
            Navigator.navigate(Navigator.WINNER_NOTIFY, stage);
        }
    }
    
 
}
