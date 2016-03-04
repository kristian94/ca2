/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet("/Servlet2/*")
public class Servlet2 extends HttpServlet {

    private static List<Person> persons = new ArrayList<>();
    Gson gson = new Gson();
    Random r = new Random();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("application/json");
        
        if(persons.size() == 0) initPersons();
        
        
        String json = gson.toJson(persons.get(r.nextInt(persons.size())));
        
        //System.out.println("hey");
        response.getWriter().write(json);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String json = request.getParameter("json");
        System.out.println(json);
        Person p = gson.fromJson(json, Person.class);
        persons.add(p);
        
        for(Person per: persons){
            System.out.println(per.getName());
        }
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

    private void initPersons() {
        Person p1 = new Person();
        p1.setAge(20);
        p1.setIsMale(true);
        p1.setName("John");
        p1.setOccupation("Fisherman");
        
        Person p2 = new Person();
        p2.setAge(55);
        p2.setIsMale(false);
        p2.setName("Neena");
        p2.setOccupation("Middle School Teacher");
        
        persons.add(p1);
        persons.add(p2);
    }

}
