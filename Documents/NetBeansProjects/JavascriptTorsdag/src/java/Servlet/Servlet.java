/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kristian Nielsen
 */
@WebServlet("/Servlet/*")
public class Servlet extends HttpServlet {

    Random r = new Random();
    public int lastHour = 9999;
    public String currentQuote = "";
    public int quoteIndex = 1;
    public List<String> quotes = new ArrayList<>();
    
    /**
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        Date timeNow = new Date(utilDate.getTime());
        
        
        int h = cal.get(Calendar.HOUR_OF_DAY);
        
        
        if(quotes.size() == 0) initQuotes();
        
        if(lastHour == 9999){
            lastHour = h;
            newQuote();
        }else if(h != lastHour) newQuote();
        
        String text = currentQuote;
        

        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        response.getWriter().write(text);
    }


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

    private void newQuote() {
        int i = r.nextInt(quotes.size());
        currentQuote = quotes.get(i);
    }

    private void initQuotes() {
        quotes.add("Defeat is not the worst of failures. Not to have tried is the true failure.");
        quotes.add("We are what we repeatedly do. Excellence then, is not an act, but a habit.");
        quotes.add("That which does not kill us makes us stronger.");
        quotes.add("Be careful the environment you choose for it will shape you; be careful the friends you choose for you will become like them.");
        quotes.add("Never argue with stupid people, they will drag you down to their level and then beat you with experience.");
        quotes.add("Great minds discuss concepts,  Average minds discuss events, Small minds discuss others, Minute minds only discuss themselves.");
        quotes.add("Insanity: Doing the same thing over and over again and expecting different results.");
        quotes.add("Books are the quietest and most constant of friends; they are the most accessible and wisest of counselors, and the most patient of teachers.");
        quotes.add("Knowing is not enough; we must apply. Willing is not enough: we must do.");
        quotes.add("It is not because things are difficult that we do not dare; it is because we do not dare that things are difficult.");
    }

}
