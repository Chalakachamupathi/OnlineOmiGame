/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author chalaka
 */
public class JsonObjectCreater {
    
    private ArrayList<String> list ;
    private boolean showHand ;
    private boolean showCards ; 
    private String message;
    private String trumpCard;
    private String output;
    private String card1;
    private String card2;
    private String card3;
    private String card4;
    private String player0;
    private String player1;
    private String player2;
    private String player3;
    
    /**
     * This constructor to create card with out playing main.webapp.cards
     * @param list
     * @param showHand
     * @param showCards
     * @param message
     * @param trumpCard 
     */
  
    public  JsonObjectCreater(ArrayList<String> list ,
                                boolean showHand , 
                                boolean showCards , 
                                String message,
                                String trumpCard){
        this.list = list;
        this.showCards = showCards;
        this.showHand = showHand;
        this.message = message;
        this.trumpCard = trumpCard;
        
        createJsonnObject();
    }
    // Last card should be my card
    /**
     * This constructor to create JSON object with playing card and marks of the players
     * @param list
     * @param showHand
     * @param showCards
     * @param message
     * @param trumpCard
     * @param card1
     * @param card2
     * @param card3
     * @param card4
     * @param player0
     * @param player1
     * @param player2
     * @param player3 
     */
    public  JsonObjectCreater(ArrayList<String> list ,
                                boolean showHand , 
                                boolean showCards , 
                                String message,
                                String trumpCard,
                                String card1,
                                String card2,
                                String card3,
                                String card4,
                                String player0,
                                String player1,
                                String player2,
                                String player3){
        this.list = list;
        this.showCards = showCards;
        this.showHand = showHand;
        this.message = message;
        this.trumpCard = trumpCard;
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.card4 = card4;
        this.player0 = player0;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        
        
        createJsonnObjectWithCards();
    }
    
    private void createJsonnObject(){
    
            JSONObject arrayObj = new JSONObject();
            
            JSONObject img2     = new JSONObject();
            JSONArray arr       = new JSONArray();
            
            for(int i = 0 ; i < list.size() ; i++){
                JSONObject img  = new JSONObject(); 
                
                String add =list.get(i) ;
                try{
                    img.put("image", add);
                    arr.put(img);
                }catch(Exception e){
                    e.printStackTrace();
                }
            } 
       
            try{    
                    arrayObj.put("cards", arr);
                    arrayObj.put("trump", trumpCard);
                    arrayObj.put("showHand" , showHand);
                    arrayObj.put("showCards", showCards);
                    arrayObj.put("message", message);
                    
                    this.output = arrayObj.toString();
                  
            }catch(Exception e){
                    e.printStackTrace();
            }
    }
    
    private void createJsonnObjectWithCards(){
    
            JSONObject arrayObj = new JSONObject();
            
            JSONObject img2     = new JSONObject();
            JSONArray arr       = new JSONArray();
            
            
            
            
            for(int i = 0 ; i < list.size() ; i++){
                JSONObject img  = new JSONObject(); 
                
                String add =list.get(i) ;
                try{
                    img.put("image", add);
                    arr.put(img);
                }catch(Exception e){
                    e.printStackTrace();
                }
            } 
       
            try{    
                    arrayObj.put("card1" , card1);
                    arrayObj.put("card2" , card2);
                    arrayObj.put("card3" , card3);
                    arrayObj.put("mycard" ,card4);
                    arrayObj.put("cards", arr);
                    arrayObj.put("trump", trumpCard);
                    
                    arrayObj.put("showHand" , showHand);
                    arrayObj.put("showCards", showCards);
                    arrayObj.put("message", message);
                    arrayObj.put("player0", player0);
                    arrayObj.put("player1", player1);
                    arrayObj.put("player2", player2);
                    arrayObj.put("player3", player3);
                    
                    this.output = arrayObj.toString();
                  
            }catch(Exception e){
                    e.printStackTrace();
            }
    }
    
    public String getJsonString(){
        return output;
    }
}
