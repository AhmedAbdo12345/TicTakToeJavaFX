package server.data.db;

import java.util.ArrayList;
import server.data.model.Player;

public interface DBCreateReadUpdateDelete {
     public ArrayList<Player> getOnlinePlayers();
     public int getCountPlayers();
     public String addPlayer(Player user); // register function
     public boolean updatePlayerStatus(boolean status,int id);
     public String isPlayer(String userName,String password); // login funciton
     public void clearAll();
}