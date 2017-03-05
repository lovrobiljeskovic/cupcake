/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import model.Customer;
import java.sql.SQLException;

/**
 *
 * @author Lovro
 */
public interface ICustomerFacade {
  Customer getCustomer(String username, String password)  throws SQLException, NullPointerException;
  void createCustomer(String username, String name, String email, String phone,int balance, String password)throws SQLException, NullPointerException ;
  
}
