package model;

import data.DataMapper;
import data.ICustomerFacade;
import model.Customer;
import java.sql.SQLException;

public class CustomerFacade implements ICustomerFacade{
    
    private DataMapper dm = new DataMapper();
    
    @Override
    public Customer getCustomer(String username, String password)  throws SQLException, NullPointerException {
        return dm.customerLogin(username, password);
    }    
    
    @Override
    public void createCustomer(String username, String name, String email, String phone,int balance, String password)throws SQLException, NullPointerException {
       dm.customerSignup(username, name, email, phone, balance, password);
    }

    
}
