package server.data.server;

import server.data.model.Player;

public interface Authentication {
     
     /**
      * @param userName
      * @param password
      @return String userId Or Null
      **/
     public String loign(String userName,String password);
     
     /**
      * @param player
      @return String userId Or Null
      **/
     public String register(Player player);

     
     
}
