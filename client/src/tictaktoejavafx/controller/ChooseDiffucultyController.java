package tictaktoejavafx.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.view.ChooseDiffucultyScreenBase;

public class ChooseDiffucultyController extends ChooseDiffucultyScreenBase{
    private Stage stage;

    public ChooseDiffucultyController(Stage stage) {
        this.stage = stage;
    }
    
    
    @Override
    protected void isEasyMode(ActionEvent actionEvent) {
       Navigator.navigate(Navigator.GAMEBOARD, stage);

    }

    @Override
    protected void isMiddleMode(ActionEvent actionEvent) {
       Navigator.navigate(Navigator.GAMEBOARDMIDDLE, stage);
      
    }

    @Override
    protected void isHardMode(ActionEvent actionEvent) {
       
        Navigator.navigate(Navigator.GAMEBOARDHARD, stage);
    }

    @Override
    protected void isStartGame(ActionEvent actionEvent) {
        Navigator.navigate(Navigator.GAMEBOARD, stage);
    }
    
}
