/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;


import Servlet.TheGameStates.GameState;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author chalaka
 */
public class OpenServlet extends HttpServlet {

    static AGame agame = new AGame();
    GameState state = TheGameStates.state;
    /**
     * This servlet handle player connection and update request from client 
     * 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext( );
        
        
        HttpSession session = request.getSession();
            
           
         JSONObject arrayObj = null;
         String outputString = null;
          if(session.isNew()){
                Player player = new Player(session.getId());

                agame.addPlayers(player);
          }
          
        if(agame.isFull()){
            
            Player [] players= agame.getPlayers();
            Player thePlayer = null;
            ArrayList<String> cardsList;
            int i = 0 ;
            for(; i < 4 ; i++){
                if(players[i].getId().equals(session.getId())){
                    thePlayer =  players[i];
                    break;
                }
            }
           
            if(thePlayer != null && thePlayer.cards.isEmpty()){
                    cardsList = thePlayer.getCards();
                    //create the output string from the json object
                    outputString =  new JsonObjectCreater(cardsList , true ,true ,"Play.." ,agame.getTrumpCard()).getJsonString();
               
            }   
            
            
                    int toSwitch = agame.stateRotation.get(i);
                     switch (toSwitch){
                        case 0:
                            if(agame.winner.isEmpty()){
                                state = GameState.PLAYER1;
                                outputString = GameState.PLAYER1.eval(thePlayer, null, agame);
                            }else{
                                if (agame.winner.get(0).equals(thePlayer.getId())){
                                    cardsList = thePlayer.getCards();
                                    outputString =  new JsonObjectCreater(cardsList , false ,false ,"CONGRATULATION YOU WON .........!" ,agame.getTrumpCard()).getJsonString();
                                }else{
                                    cardsList = thePlayer.getCards();
                                    outputString =  new JsonObjectCreater(cardsList , false ,false ,"SORRY YOU LOSE.........!" ,agame.getTrumpCard()).getJsonString();
                                }
                            }
                            break;
                            
                        case 1:
                            if(agame.winner.isEmpty()){
                                state = GameState.PLAYER2;
                                outputString = GameState.PLAYER2.eval(thePlayer, null, agame);
                            }else{
                                if (agame.winner.get(0).equals(thePlayer.getId())){
                                    cardsList = thePlayer.getCards();
                                    outputString =  new JsonObjectCreater(cardsList , false ,false ,"CONGRATULATION YOU WON .........!" ,agame.getTrumpCard()).getJsonString();
                                }else{
                                    cardsList = thePlayer.getCards();
                                    outputString =  new JsonObjectCreater(cardsList , false ,false ,"SORRY YOU LOSE.........!" ,agame.getTrumpCard()).getJsonString();
                                }
                            }
                            break;
                        case 2:
                            if(agame.winner.isEmpty()){
                                state = GameState.PLAYER3;
                                outputString = GameState.PLAYER3.eval(thePlayer, null, agame);
                            }else{
                                if (agame.winner.get(0).equals(thePlayer.getId())){
                                    cardsList = thePlayer.getCards();
                                    outputString =  new JsonObjectCreater(cardsList , false ,false ,"CONGRATULATION YOU WON .........!" ,agame.getTrumpCard()).getJsonString();
                                }else{
                                    cardsList = thePlayer.getCards();
                                    outputString =  new JsonObjectCreater(cardsList , false ,false ,"SORRY YOU LOSE.........!" ,agame.getTrumpCard()).getJsonString();
                                }
                            }
                            break;
                        case 3:
                            if(agame.winner.isEmpty()){
                                state = GameState.PLAYER4;
                                outputString = GameState.PLAYER4.eval(thePlayer, null, agame);
                            }else{
                                if (agame.winner.get(0).equals(thePlayer.getId())){
                                    cardsList = thePlayer.getCards();
                                    outputString =  new JsonObjectCreater(cardsList , false ,false ,"CONGRATULATION YOU WON .........!" ,agame.getTrumpCard()).getJsonString();
                                }else{
                                    cardsList = thePlayer.getCards();
                                    outputString =  new JsonObjectCreater(cardsList , false ,false ,"SORRY YOU LOSE.........!" ,agame.getTrumpCard()).getJsonString();
                                }
                            }
                            break;
                    }
         
              try {
                        out.println( outputString);

                    } finally {
                        out.close();
                    }
        
        }else{
             arrayObj = new JSONObject();

             JSONArray arr = new JSONArray();

             String messg = "Waiting for others to connect. Only "+agame.getNumberOfPlayer()+" players connected ..";
       
            try{    
                
                    arrayObj.put("cards", arr);
                    arrayObj.put("showHand" , false);
                    arrayObj.put("showCards", false);
                    arrayObj.put("message",messg);
                  
            }catch(Exception e){
                    e.printStackTrace();
            }        
             try {
                 out.println(arrayObj.toString() );

            } finally {
                out.close();
            } 
        
        
        }
            

       
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
