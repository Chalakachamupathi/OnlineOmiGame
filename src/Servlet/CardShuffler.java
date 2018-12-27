/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author chalaka
 */
public class CardShuffler {
    
    private final String [] cards = {"cards/0_1.png","cards/0_2.png","cards/0_3.png","cards/0_4.png","cards/0_5.png","cards/0_6.png","cards/0_7.png","cards/0_8.png","cards/0_9.png","cards/0_10.png","cards/0_11.png","cards/0_12.png","cards/0_13.png",
                                    "cards/1_1.png","cards/1_2.png","cards/1_3.png","cards/1_4.png","cards/1_5.png","cards/1_6.png","cards/1_7.png","cards/1_8.png","cards/1_9.png","cards/1_10.png","cards/1_11.png","cards/1_12.png","cards/1_13.png",
                                    "cards/2_1.png","cards/2_2.png","cards/2_3.png","cards/2_4.png","cards/2_5.png","cards/2_6.png","cards/2_7.png","cards/2_8.png","cards/2_9.png","cards/2_10.png","cards/2_11.png","cards/2_12.png","cards/2_13.png",
                                    "cards/3_1.png","cards/3_2.png","cards/3_3.png","cards/3_4.png","cards/3_5.png","cards/3_6.png","cards/3_7.png","cards/3_8.png","cards/3_9.png","cards/3_10.png","cards/3_11.png","cards/3_12.png","cards/3_13.png"};
    
    private  ArrayList <String> list;
    
    public CardShuffler(){
         list = new ArrayList();
         shuffleCards();
    }
    
    private void shuffleCards(){
      
       list.addAll(Arrays.asList(cards));  
       Collections.shuffle(list);
    }
    
    public  ArrayList <String> getShuffledList(){
        return this.list;
    }
}
