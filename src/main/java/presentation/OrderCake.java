/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bottom;
import model.Cupcake;
import model.CupcakeFacade;
import model.Customer;
import model.OrderLine;
import model.Topping;

/**
 *
 * @author Lovro
 */
public class OrderCake extends HttpServlet {

    DataMapper dm = new DataMapper();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String formName = request.getParameter("formName");
        switch (formName) {
            case "shopping":
                try {
                    String toppingName = (String) request.getParameter("Topping");
                    float toppingPrice = dm.getToppingPrice(toppingName);
                    String bottomName = (String) request.getParameter("Bottom");
                    float bottomPrice = dm.getBottomPrice(bottomName);
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    Topping topping = new Topping(toppingName, toppingPrice);
                    Bottom bottom = new Bottom(bottomName, bottomPrice);
                    Cupcake cupcake = new Cupcake(topping, bottom);
                    cupcake.setPrice(bottomPrice + toppingPrice);
                    double totalPrice = (cupcake.getPrice() * quantity);
                    cupcake.setPrice(totalPrice);
                    request.setAttribute("cupcake", cupcake);
                    request.setAttribute("totalQuantity", quantity);
                    request.setAttribute("totalPrice", totalPrice);
                    request.getRequestDispatcher("OrderConfirmation.jsp").forward(request, response);
                } catch (SQLException | NullPointerException e) {
                    request.setAttribute("errorMessageUserNotFound", "Incorrect username and/or password");
                    request.getRequestDispatcher("OrderConfirmation.jsp").forward(request, response);
                }
                break;
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
