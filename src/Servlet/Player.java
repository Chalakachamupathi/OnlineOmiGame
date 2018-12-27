/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.util.ArrayList;

/**
 *
 * @author chalaka
 */
public class Player {
    private final String id;
    private int points = 0;
    ArrayList<String> cards;
    private String jsonString;
    
    public Player(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
    public void setJsonString(String st){
        this.jsonString = st;
    }
    
    public String getJsonString(){
        return this.jsonString;
    }
    
    public void setCards(ArrayList<String> cards){
        this.cards = cards;
    }
    public ArrayList<String> getCards(){
        return this.cards;
    }
    public void removeCard(String card){
        cards.remove(card);
    }
    /**
     * Check wether crad that this one played actually playable or not 
     * @param currentHandCardType
     * @param currentCard
     * @return 
     */
    public boolean checkPlayablity(String currentHandCardType,String currentCard){
        if(currentHandCardType != null){
                String [] tem1 = currentHandCardType.split("/");
                    char currenHand = tem1[1].charAt(0);
                String [] tem2 = currentCard.split("/");
                    char currcard = tem2[1].charAt(0);

                    if (currenHand == currcard){
                        return true;
                    }else{
                        for (String card : cards) {
                          String [] tem = card.split("/");
                           char temChar = tem[1].charAt(0);
                           if(currenHand == temChar)
                               return false;
                        }
                        return true;
                    }


        }
         return false;
    }
    
    public void updatePoint(){
        this.points ++ ;
    }
   public int getPoint(){
       return this.points;
   }
    
}
