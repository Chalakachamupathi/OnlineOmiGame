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
public class AGame {
    private final Player [] players;
    public int count = 0;
    private ArrayList <String> shuffledList;
    private String lastCard;
    public int cardCount = 0;
    ArrayList <Integer> stateRotation = new ArrayList();
    ArrayList<String> winner = new ArrayList();
    public AGame(){
        
        players = new Player[4];
        
        shuffledList = new CardShuffler().getShuffledList();
        
        lastCard = shuffledList.get(shuffledList.size() - 1 );
        
        for (int i = 0 ; i < 4 ; i++){
            stateRotation.add(i);
        }
     
    }    
    
    public void addPlayers(Player p){
        if(!this.isFull()){
            ArrayList<String> tem = new ArrayList();
            int i = cardCount;
            for(; i<13+cardCount ; i++){
                tem.add(shuffledList.get(i));
            }
            cardCount = i ;
            p.setCards(tem);
            players[count] = p;
            count ++;
        }
    }
    
    public boolean isFull(){
         if(count == 4){
             return true;
         }else{
             return false;
         }
    }
    
    public int getNumberOfPlayer(){
        return count;
    }
    
    public Player[] getPlayers(){
        return this.players;
    }
    
    public String getTrumpCard(){
        return this.lastCard;
    }
    public void setTrumpCard(String card){
        this.lastCard = card;
    }
    public void setCardList(ArrayList<String> list){
        this.shuffledList = list;
    }
}
