/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.CustomerFacade;

/**
 *
 * @author Lovro
 */
public class CustomerServlet extends HttpServlet {
private final CustomerFacade customerFacade = new CustomerFacade();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String formName = request.getParameter("formName");
        switch (formName) {
            case "LoginForm":
                try {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    Customer customer = customerFacade.getCustomer(username, password);
                    request.getSession().setAttribute("username", username);
                    request.getSession().setAttribute("password", password);
                    request.getSession().setAttribute("currentUser", customer);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (SQLException | NullPointerException e) {
                    request.setAttribute("errorMessageUserNotFound", "Incorrect username and/or password");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                break;
            case "NewMember":
                try {   
                    String username = request.getParameter("username");
                    String name = request.getParameter("name");
                    String email = request.getParameter("email");
                    String phone = request.getParameter("phone");
                    int balance = Integer.parseInt(request.getParameter("balance"));
                    String password = request.getParameter("password");
                    customerFacade.createCustomer(username, name, email, phone, balance, password);
                    request.setAttribute("messageUserCreated", "Congratulations, your new account has been created! Log in with your e-mail and password.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } catch (SQLException | NullPointerException e) {
                    System.out.println(e.getMessage());
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
                break;
        
    }
    }
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
