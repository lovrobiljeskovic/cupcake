/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import model.Bottom;
import model.Customer;
import model.Cupcake;
import model.Topping;

/**
 *
 * @author Lovro
 */
public class DataMapper {

    private final Connection con;

    public DataMapper() {
        con = new Connector().getConnection();
    }

    public void customerSignup(String username, String name, String email, String phone,int balance, String password) throws SQLException, NullPointerException {
        PreparedStatement updateCustomer = null;
        String str = "INSERT INTO customer(username, name, email, phone, balance, password) VALUES (?,?,?,?,?,?);";
        updateCustomer = con.prepareStatement(str);
        con.setAutoCommit(false);
        updateCustomer.setString(1, username);
        updateCustomer.setString(2, name);
        updateCustomer.setString(3, email);
        updateCustomer.setString(4, phone);
        updateCustomer.setInt(5, balance);
        updateCustomer.setString(6, password);

        int rowAffected = updateCustomer.executeUpdate();
        if (rowAffected == 1) {
            con.commit();
        } else {
            con.rollback();
        }
    }
 public Customer customerLogin(String username, String password) throws SQLException, NullPointerException {
        ResultSet rs = null;
        Customer customer = null;
        PreparedStatement getBorrower = null;
        String getBorrowerString = "SELECT * FROM customer WHERE username = ? AND Password = ? ;";
        getBorrower = con.prepareStatement(getBorrowerString);
        getBorrower.setString(1, username);
        getBorrower.setString(2, password);
        rs = getBorrower.executeQuery();
        if (rs.next()) {
            customer = new Customer(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    rs.getString(5),
                                    rs.getInt(6),
                                    rs.getString(7));
        }
        return customer;
        
    }
 public Cupcake getCupcake(String topping, String bottom)throws SQLException, NullPointerException {
    ResultSet rs = null;
        Cupcake cupcake = null;
        PreparedStatement getCupcake = null;
        String getCupcakeString = "SELECT Topping.name, Topping.price, Bottom.name, Bottom.price FROM Topping INNER JOIN Bottom WHERE Topping.name = ? AND Bottom.name = ?;";
        getCupcake = con.prepareStatement(getCupcakeString);
        getCupcake.setString(1, topping);
        getCupcake.setString(2, bottom);
        rs = getCupcake.executeQuery();
        if (rs.next()) {
            Topping selectedTopping = new Topping(rs.getString(1),
                                                  rs.getDouble(2));
            Bottom selectedBottom   = new Bottom( rs.getString(3),
                                                  rs.getDouble(4));
            cupcake = new Cupcake(selectedTopping, selectedBottom);
        }
        return cupcake;
 }
  public float getToppingPrice(String topping)throws SQLException{
     PreparedStatement insertStatement;
     ResultSet rs;
     try{
         String selectStatement = "select price from topping where name1 = ?";
         insertStatement = con.prepareStatement(selectStatement);
         insertStatement.setString(1,topping);
         
          rs = insertStatement.executeQuery();
          if (rs.next()){
          return rs.getFloat("toppingPrice");
          }
         
     
     }catch(SQLException e){System.out.println("You have an error in getToppingPrice method");}
     return 0;
    } 
  public float getBottomPrice(String bottom){
     PreparedStatement insertStatement;
     ResultSet rs;
     try{
         String selectStatement = "select price from bottom where name = ?";
         insertStatement = con.prepareStatement(selectStatement);
         insertStatement.setString(1,bottom);
         
          rs = insertStatement.executeQuery();
          if (rs.next()){
          return rs.getFloat("bottomPrice");
          }
         
     
     }catch(SQLException e){System.out.println("You have an error in getBottomPrice method" ) 
             ; e.printStackTrace();}
     return 0;
  }
}
