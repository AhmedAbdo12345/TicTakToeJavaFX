package tictaktoejavafx.controller;

import java.util.ArrayList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tictaktoejavafx.utils.Navigator;
import tictaktoejavafx.utils.PlayerName;
import tictaktoejavafx.view.GameBoardScreenBase;

public class GameBoardController extends GameBoardScreenBase{
    int count =0;
    ArrayList arrlist=new ArrayList();
    ArrayList arrlistButtons=new ArrayList();
    private Stage stage;

    public GameBoardController(Stage stage) {
        this.stage = stage;
        addbuttonInList();
    }
    
    @Override
    protected void isGameOne(ActionEvent actionEvent) {
         arrlistButtons.remove(btn_Game_one);
                count++;
                btn_Game_one.setDisable(true);
                if(count %2 !=0){
                   btn_Game_one.setText("X");
                  btn_Game_one.setStyle("-fx-font-weight: bold;");
                        check();
                      random();
                }
    }
 @Override
    protected void isGameTwo(ActionEvent actionEvent) {
   arrlistButtons.remove(btn_Game_two);
                count++;
                btn_Game_two.setDisable(true);
                if(count %2 !=0){
                   btn_Game_two.setText("X");
                 check();
                      random();

                }
    }
    @Override
    protected void isGameFour(ActionEvent actionEvent) {
   arrlistButtons.remove(btn_Game_four);
                count++;
                btn_Game_four.setDisable(true);
                if(count %2 !=0){
                   btn_Game_four.setText("X");
                 check();
                      random();

                }    }

    @Override
    protected void isGameSeven(ActionEvent actionEvent) {
        arrlistButtons.remove(btn_Game_seven);
                count++;
                btn_Game_seven.setDisable(true);
                if(count %2 !=0){
                   btn_Game_seven.setText("X");
                 check();
                      random();

                }       }

   

    @Override
    protected void isGameThree(ActionEvent actionEvent) {
  arrlistButtons.remove(btn_Game_three);
                count++;
                btn_Game_three.setDisable(true);
                if(count %2 !=0){
                   btn_Game_three.setText("X");
                 check();
                      random();

                }       }

    @Override
    protected void isGameFive(ActionEvent actionEvent) {
  arrlistButtons.remove(btn_Game_five);
                count++;
                btn_Game_five.setDisable(true);
                if(count %2 !=0){
                   btn_Game_five.setText("X");
                 check();
                      random();

                }       }

    @Override
    protected void isGameSix(ActionEvent actionEvent) {
  arrlistButtons.remove(btn_Game_six);
                count++;
                btn_Game_six.setDisable(true);
                if(count %2 !=0){
                   btn_Game_six.setText("X");
                 check();
                      random();

                }       }

    @Override
    protected void isGameEight(ActionEvent actionEvent) {
  arrlistButtons.remove(btn_Game_eight);
                count++;
                btn_Game_eight.setDisable(true);
                if(count %2 !=0){
                   btn_Game_eight.setText("X");
                 check();
                      random();

                }       }

    @Override
    protected void isGameNine(ActionEvent actionEvent) {
        arrlistButtons.remove(btn_Game_nine);
                count++;
                btn_Game_nine.setDisable(true);
                if(count %2 !=0){
                   btn_Game_nine.setText("X");
                 check();
                      random();

                }       }
    //-----------------------------------------
    void check(){
 
    //-------------rows----------------------------
    arrlist.add(btn_Game_one.getText()+btn_Game_two.getText()+btn_Game_three.getText());
    arrlist.add(btn_Game_four.getText()+btn_Game_five.getText()+btn_Game_six.getText());
    arrlist.add(btn_Game_seven.getText()+btn_Game_eight.getText()+btn_Game_nine.getText());
    
    //-------------Colums----------------------------

    arrlist.add(btn_Game_one.getText()+btn_Game_four.getText()+btn_Game_seven.getText());
    arrlist.add(btn_Game_two.getText()+btn_Game_five.getText()+btn_Game_eight.getText());
    arrlist.add(btn_Game_three.getText()+btn_Game_six.getText()+btn_Game_nine.getText());
 
 
    //-------------cross----------------------------
    arrlist.add(btn_Game_one.getText()+btn_Game_five.getText()+btn_Game_nine.getText());
    arrlist.add(btn_Game_three.getText()+btn_Game_five.getText()+btn_Game_seven.getText());
        
    for(int i=0; i<arrlist.size();i++){
    if(arrlist.get(i).equals("XXX")){
   // result_label.setText("Player 1 is Winner");
    disableButton();
    PlayerName.setPlayerName("Player 1");
    playVideo();
    }else if(arrlist.get(i).equals("OOO")){
      //  result_label.setText("Player 2 is Winner");
disableButton();
    PlayerName.setPlayerName("Player 2");

playVideo();
    }
        
    }
    }
                
   void disableButton(){
   btn_Game_one.setDisable(true);
   btn_Game_two.setDisable(true);
   btn_Game_three.setDisable(true);
   
   btn_Game_four.setDisable(true);
   btn_Game_five.setDisable(true);
   btn_Game_six.setDisable(true);
   
   btn_Game_seven.setDisable(true);
   btn_Game_eight.setDisable(true);
   btn_Game_nine.setDisable(true);
   }
            
        void playVideo(){
            Navigator.navigate(Navigator.WINNER_NOTIFY, stage);

          
    }

    void random(){
       
          Random random_method = new Random();
           
          try{
              if(arrlistButtons.size() >0){
          int index = random_method.nextInt(arrlistButtons.size());
                    System.out.println(index);

         if(index  < arrlistButtons.size() ){
            
      Button button=(Button)arrlistButtons.get(index);
      if(button != null && !button.isDisable()){
                count++;
                button.setDisable(true);
                arrlistButtons.remove(button);
                if(count %2 ==0){
                  button.setText("O");
                        check();
                }
      }
    
         }}
         }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            }
        
    }
    void addbuttonInList(){
        arrlistButtons.add(btn_Game_one);
        arrlistButtons.add(btn_Game_two);
        arrlistButtons.add(btn_Game_three);
        arrlistButtons.add(btn_Game_four);
        arrlistButtons.add(btn_Game_five);
        arrlistButtons.add(btn_Game_six);
        
        arrlistButtons.add(btn_Game_seven);
        arrlistButtons.add(btn_Game_eight);
        arrlistButtons.add(btn_Game_nine);
    }
    //-----------------------------------------
}