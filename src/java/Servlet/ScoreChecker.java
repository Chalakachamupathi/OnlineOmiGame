/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.Servlet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author chalaka
 */
public class ScoreChecker {
    
    
    public static ArrayList < TheGameStates.GameState > trumCardChecker(HashMap< TheGameStates.GameState ,String > hand, String trumCard){
        String[] tem = trumCard.split("/");
        char trumType = tem[1].charAt(0);
        TheGameStates.GameState[] players = TheGameStates.GameState.values();
        ArrayList<TheGameStates.GameState> newPlayer = new ArrayList() ;
        
        for(int i = 0 ; i < hand.size() ; i++){
            String[] tem1 =hand.get(players[i+1]).split("/");
            char trumTypeq = tem1[1].charAt(0);
            
            if (trumType == trumTypeq){
              newPlayer.add(players[i+1]);
            }
        }
        return newPlayer;
    }
    
    
    public static TheGameStates.GameState  checkForNormalHandWin(HashMap< TheGameStates.GameState ,String > hand, String currentHandType){
        
            String[] tem = currentHandType.split("/");
            char trumType = tem[1].charAt(0);
            TheGameStates.GameState[] players = TheGameStates.GameState.values();
            int cardValue = -1;
             TheGameStates.GameState winner = null;
            for(int i = 0 ; i < hand.size() ; i++){
                
                if (hand.get(players[i+1])!=null){
                
                    String[] tem1 =hand.get(players[i+1]).split("/");
                    char cardType = tem1[1].charAt(0);
                    if (trumType == cardType){
                        String [] tem3 = tem1[1].split("_");
                        String [] tem4 = tem3[1].split("\\.");
                        int temValue = Integer.parseInt(tem4[0]);
                        if (temValue == 1){
                            temValue = 14;
                        }
                        if(cardValue < temValue){
                            cardValue = temValue;
                            winner = players[i+1];
                        }

                    } 
                }
        }
            return winner;
            
    }
    
    
    

}
