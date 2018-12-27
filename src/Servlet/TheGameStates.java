/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author chalaka
 */
public class TheGameStates {
    private final static HashMap< GameState ,String > hand = new HashMap();
    static GameState state = GameState.PLAYER1;
    static String currentCardType ;
    static HashMap< GameState ,Player > playerMap = new HashMap();
    
    public enum GameState {
			Evaluate {  
                                        @Override
					String eval(Player pl1 ,String card ,AGame agame) { 
                                                //evaluate and set state as winners state to playe
                                                state = checkForWinners( agame);
                                                playerMap.get(state).updatePoint();
                                                
                                                if (playerMap.get(state).getPoint() == 10){
                                                    agame.winner.add(playerMap.get(state).getId());
                                                }
                                                //System.out.println(playerMap.get(state).getPoint());
                                                hand.clear();
                                                switch(state){
                                                    case PLAYER2:
                                                         Collections.rotate(agame.stateRotation, 1);
                                                         break;
                                                    case PLAYER3:
                                                         Collections.rotate(agame.stateRotation, 2);
                                                         break;
                                                    case PLAYER4:
                                                         Collections.rotate(agame.stateRotation, 3);
                                                         break;
                                                        
                                                }
                                                
                                                if(pl1.cards.isEmpty()){
                                                    ArrayList<String> temlist = new CardShuffler().getShuffledList();
                                                    agame.setCardList(temlist);
                                                    agame.setTrumpCard(temlist.get(temlist.size() - 1 ));

                                                    agame.cardCount = 0;
                                                    agame.count = 0;
                                                    
                                                    Player[] plyer = agame.getPlayers();
                                                    for (int i =0 ; i < 4 ; i++ )
                                                    agame.addPlayers(plyer[i]);
                                                
                                                }
                                                
                                                playerMap.clear();
                                                state = PLAYER1;
						return null;
					}
			} ,
			PLAYER1 {
                                        @Override
					String eval(Player pl1 ,String card ,AGame agame) { 
                                                String  outputString = null;
                                                String card1 = null;
                                                String card2 = null;
                                                String card3 = null;
                                                String card4 = null;
                                                 if (state == PLAYER1){
                                                     outputString = "Your turn ..." ;
                                                 }else{
                                                    outputString = "Wait for your turn..." ;
                                                }
                                                if (state == PLAYER1 && card !=null){
                                                    playerMap.put(state, pl1);
                                                    String tem = getCurrentCardType();
                                                    if(tem != null){
                                                        currentCardType = tem;
                                                    }
                                                    if(pl1.checkPlayablity(currentCardType, card) || hand.isEmpty()){
                                                        pl1.removeCard(card);
                                                        hand.put(PLAYER1, card);
                                                        //outputString = "Wait for your turn..." ;
                                                        state = PLAYER2;
                                                    }else{
                                                        outputString = "Wrong card..." ;
                                                    }
                                                }
                                                card1 = hand.get(PLAYER1);
                                                card2 = hand.get(PLAYER2);
                                                card3 = hand.get(PLAYER3);
                                                card4 = hand.get(PLAYER4);
                                                String []playerPoint = new String[3];
                                                Player [] tem = agame.getPlayers();
                                                int j = 0 ;
                                                for (int i = 0 ; i < 4 ; i++){
                                                    if (!pl1.getId().equals(tem[i].getId())){
                                                        playerPoint[j] = tem[i].getPoint()+"";
                                                        j++;
                                                    }
                                                }
                                                //create the output string from the json object
                                                return   new JsonObjectCreater(pl1.getCards() ,
                                                                                        true ,
                                                                                        true ,
                                                                                        outputString ,
                                                                                         agame.getTrumpCard(),
                                                                                         card2,
                                                                                         card3,
                                                                                         card4,
                                                                                         card1,
                                                                                         pl1.getPoint()+"",
                                                                                         playerPoint[0],
                                                                                         playerPoint[1],
                                                                                         playerPoint[2]).getJsonString();
						

					}
			} ,
			PLAYER2 {
                                        @Override
					String eval(Player pl1 ,String card ,AGame agame) { 
                                                String  outputString = null;
                                                String card1 = null;
                                                String card2 = null;
                                                String card3 = null;
                                                String card4 = null;
                                                 if (state == PLAYER2){
                                                     outputString = "Your turn ..." ;
                                                 }else{
                                                    outputString = "Wait for your turn..." ;
                                                }
                                                if (state == PLAYER2 && card !=null){
                                                    playerMap.put(state, pl1);
                                                    String tem = getCurrentCardType();
                                                    if(tem != null){
                                                        currentCardType = tem;
                                                    }
                                                    if(pl1.checkPlayablity(currentCardType, card) || hand.isEmpty()){
                                                        pl1.removeCard(card);
                                                        hand.put(PLAYER2, card);
                                                        //outputString = "Wait for your turn..." ;
                                                        state = PLAYER3;
                                                    }else{
                                                        outputString = "Wrong card..." ;
                                                    }
                                                }
                                                card1 = hand.get(PLAYER1);
                                                card2 = hand.get(PLAYER2);
                                                card3 = hand.get(PLAYER3);
                                                card4 = hand.get(PLAYER4);
                                                String []playerPoint = new String[3];
                                                Player [] tem = agame.getPlayers();
                                                int j = 0 ;
                                                for (int i = 0 ; i < 4 ; i++){
                                                    if (!pl1.getId().equals(tem[i].getId())){
                                                        playerPoint[j] = tem[i].getPoint()+"";
                                                        j++;
                                                    }
                                                }
                                                //create the output string from the json object
                                                return   new JsonObjectCreater(pl1.getCards() ,
                                                                                        true ,
                                                                                        true ,
                                                                                        outputString ,
                                                                                         agame.getTrumpCard(),
                                                                                         card1,
                                                                                         card3,
                                                                                         card4,
                                                                                         card2,
                                                                                         pl1.getPoint()+"",
                                                                                         playerPoint[0],
                                                                                         playerPoint[1],
                                                                                         playerPoint[2]).getJsonString();

					}
			},
			PLAYER3 {
                                        @Override
					String eval(Player pl1 ,String card ,AGame agame) { 
                                                String  outputString = null;
                                                String card1 = null;
                                                String card2 = null;
                                                String card3 = null;
                                                String card4 = null;
                                                 if (state == PLAYER3){
                                                     outputString = "Your turn ..." ;
                                                 }else{
                                                    outputString = "Wait for your turn..." ;
                                                }
                                                if (state == PLAYER3 && card !=null){
                                                    playerMap.put(state, pl1);
                                                    String tem = getCurrentCardType();
                                                    if(tem != null){
                                                        currentCardType = tem;
                                                    }
                                                    if(pl1.checkPlayablity(currentCardType, card) || hand.isEmpty()){
                                                        pl1.removeCard(card);
                                                        hand.put(PLAYER3, card);
                                                        //outputString = "Wait for your turn..." ;
                                                        state = PLAYER4;
                                                    }else{
                                                        outputString = "Wrong card..." ;
                                                    }
                                                }
                                                card1 = hand.get(PLAYER1);
                                                card2 = hand.get(PLAYER2);
                                                card3 = hand.get(PLAYER3);
                                                card4 = hand.get(PLAYER4);
                                                String []playerPoint = new String[3];
                                                Player [] tem = agame.getPlayers();
                                                int j = 0 ;
                                                for (int i = 0 ; i < 4 ; i++){
                                                    if (!pl1.getId().equals(tem[i].getId())){
                                                        playerPoint[j] = tem[i].getPoint()+"";
                                                        j++;
                                                    }
                                                }
                                                //create the output string from the json object
                                                return   new JsonObjectCreater(pl1.getCards() ,
                                                                                        true ,
                                                                                        true ,
                                                                                        outputString ,
                                                                                         agame.getTrumpCard(),
                                                                                         card1,
                                                                                         card2,
                                                                                         card4,
                                                                                         card3,
                                                                                         pl1.getPoint()+"",
                                                                                         playerPoint[0],
                                                                                         playerPoint[1],
                                                                                         playerPoint[2]).getJsonString();
					}
			},
			PLAYER4 {
                                        @Override
					String eval(Player pl1 ,String card ,AGame agame) { 

						String  outputString = null;
                                                String card1 = null;
                                                String card2 = null;
                                                String card3 = null;
                                                String card4 = null;
                                                 if (state == PLAYER4){
                                                     outputString = "Your turn ..." ;
                                                 }else{
                                                    outputString = "Wait for your turn..." ;
                                                }
                                                if (state == PLAYER4 && card !=null){
                                                    playerMap.put(state, pl1);
                                                    String tem = getCurrentCardType();
                                                    if(tem != null){
                                                        currentCardType = tem;
                                                    }
                                                    if(pl1.checkPlayablity(currentCardType, card) || hand.isEmpty()){
                                                        pl1.removeCard(card);
                                                        hand.put(PLAYER4, card);
                                                        //outputString = "Wait for your turn..." ;
                                                        state = Evaluate;
                                                        Evaluate.eval(pl1, card, agame);
                                                    }else{
                                                        outputString = "Wrong card..." ;
                                                    }
                                                }
                                                card1 = hand.get(PLAYER1);
                                                card2 = hand.get(PLAYER2);
                                                card3 = hand.get(PLAYER3);
                                                card4 = hand.get(PLAYER4);
                                                String []playerPoint = new String[3];
                                                Player [] tem = agame.getPlayers();
                                                int j = 0 ;
                                                for (int i = 0 ; i < 4 ; i++){
                                                    if (!pl1.getId().equals(tem[i].getId())){
                                                        playerPoint[j] = tem[i].getPoint()+"";
                                                        j++;
                                                    }
                                                }
                                                //create the output string from the json object
                                                return   new JsonObjectCreater(pl1.getCards() ,
                                                                                        true ,
                                                                                        true ,
                                                                                        outputString ,
                                                                                         agame.getTrumpCard(),
                                                                                         card1,
                                                                                         card2,
                                                                                         card3,
                                                                                         card4 ,
                                                                                         pl1.getPoint()+"",
                                                                                         playerPoint[0],
                                                                                         playerPoint[1],
                                                                                         playerPoint[2]).getJsonString();
					}
			};

			abstract String eval(Player pl1 ,String card ,AGame agame);


	}
    public static String getCurrentCardType(){
        if(hand.size()==1){       
            HashMap.Entry<GameState,String> entry=hand.entrySet().iterator().next();
            return entry.getValue();          
        }
        return null;
    }
    public static GameState checkForWinners( AGame agame){
        
        ArrayList < TheGameStates.GameState > trp = ScoreChecker.trumCardChecker(hand, agame.getTrumpCard());
        
        if (trp.isEmpty()){
             ArrayList < TheGameStates.GameState > tem = ScoreChecker.trumCardChecker(hand, currentCardType);
              HashMap< GameState ,String > temhand = new HashMap();
            
            for (int i = 0 ; i < trp.size() ; i++){
                temhand.put(trp.get(i), hand.get(trp.get(i)));
            }
            
            return ScoreChecker.checkForNormalHandWin(hand, currentCardType);
        }else if (trp.size()==1){
            System.out.println(trp.get(0));
            return trp.get(0);
        }else {
            HashMap< GameState ,String > temhand = new HashMap();
            
            for (int i = 0 ; i < trp.size() ; i++){
                temhand.put(trp.get(i), hand.get(trp.get(i)));
            }
            
            return ScoreChecker.checkForNormalHandWin(temhand, agame.getTrumpCard());
        
        }

    }
}
