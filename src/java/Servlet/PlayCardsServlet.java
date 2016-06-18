/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;


import Servlet.TheGameStates.GameState;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chalaka
 */
public class PlayCardsServlet extends HttpServlet {

    
    AGame agame = OpenServlet.agame;
    GameState state = TheGameStates.state;
    /**
     * When player play a card that request come to this servlet
     * 
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
        HttpSession session = request.getSession();
       
        Player [] players= agame.getPlayers();
        Player thePlayer = null;
              int i  ;         
            for(i= 0 ; i < 4 ; i++){
                if(players[i].getId().equals(session.getId())){
                    thePlayer =  players[i];
                    break;
                }
            }
        String  inputCarddName = request.getParameter("name").replace("\"", "");
        String  outputString = null;
        
            int toSwitch = agame.stateRotation.get(i);
            
            switch (toSwitch){
                case 0:
                    state = GameState.PLAYER1;
                    outputString = GameState.PLAYER1.eval(thePlayer, inputCarddName, agame);
                    break;
                case 1:
                    state = GameState.PLAYER2;
                    outputString = GameState.PLAYER2.eval(thePlayer, inputCarddName, agame);
                    break;
                case 2:
                    state = GameState.PLAYER3;
                    outputString = GameState.PLAYER3.eval(thePlayer, inputCarddName, agame);
                    break;
                case 3:
                    state = GameState.PLAYER4;
                    outputString = GameState.PLAYER4.eval(thePlayer, inputCarddName, agame);
                    break;
            }        

        
        try {
            
            out.println(outputString);
        
        } finally {
            out.close();
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
