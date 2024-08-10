package db;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private DBConnection() {
        this.customerList = new ArrayList<>();
    }

    private static DBConnection instance;
    private List<Customer> customerList;


    public static DBConnection getInstance() {
        if(instance == null) {
            return instance = new DBConnection();
        }
        return instance;
    }

    public List<Customer> getConnection(){
        return customerList;
    }


}
