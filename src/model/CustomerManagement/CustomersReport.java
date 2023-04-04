/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CustomersReport {
    ArrayList<CustomerSummary> customerlist;
    
    public CustomersReport(){
        customerlist = new ArrayList();

    }
    public void addCustomerSummary(CustomerSummary cs){
        customerlist.add(cs);
    }

    public void printCustomersReport(){
        for(CustomerSummary cs: customerlist){
            cs.printCustomerSummary();
        }
    }
}
