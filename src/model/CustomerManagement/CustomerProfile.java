/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;

import model.MarketModel.Market;
import model.OrderManagement.Order;
import model.Personnel.Person;

/**
 *
 * @author kal bugrara
 */
public class CustomerProfile {
    ArrayList<Order> orders;
    ArrayList<Market> markets;
    
    Person person;

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public CustomerProfile(Person p) {

        person = p;
        orders = new ArrayList();

    }

           
    public int getTotalPricePerformance(){
        
 
        //for each order in the customer orderlist calculate order price performance and add it to the sum
        int sum = 0;
        for(Order o: orders){
            sum = sum + o.getOrderPricePerformance();
        }
        return sum;


        }
 
    public int    getNumberOfOrdersAboveTotalTarget(){
        //for each order in the customer order list 
        //calculate if order is positive (actual order total is greater than sum of item targets
        //if yes then add 1 to total 
        int sum = 0;
        for(Order o: orders){
            if(o.isOrderAboveTotalTarget()==true) sum = sum + 1;
        }
        
        return sum;}
    
    public int getNumberOfOrdersBelowTotalTarget(){
         //for each order in the customer order list calculate if order is negative if yes then add 1 to total
        int sum = 0;
        for(Order o: orders){
            if(o.isOrderAboveTotalTarget()==true) sum = sum + 1;
        }
        return sum;

        
    }

    public int getTotalOrder(){
        //for each order in the customer order list calculate order total and add it to the sum
        int sum = 0;
        for(Order o: orders){
            sum = sum + o.getOrderTotal();
        }
        return sum;
    }
    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }
    public void addCustomerOrder(Order o){
        orders.add(o);
    }
    @Override
    public String toString(){
        return person.getPersonId();
    }
    public String getCustomerId(){
        return person.getPersonId();
    }

    public void setCustomerId(String id){
        person.setPersonId(id);
    }
            public Person getPerson(){
        return person;
    }

    public ArrayList<Order> getOrder(){
        return orders;
    }
    
    public void printCustomersReport(){
        System.out.println("Customer ID: " + person.getPersonId());
        System.out.println("Customer Total Order: " + getTotalOrder());
        System.out.println("Customer Total Price Performance: " + getTotalPricePerformance());
        System.out.println("Customer Number of Orders: " + orders.size());
        System.out.println("Customer Number of Markets: " + markets.size());
        
    
    }


    public int getTotalNumberOfItems() {
        int sum = 0;
        for(Order o: orders){
            sum = sum + o.getOrderitemsSize();
        }
        return sum;
    }

    public String getAverageOrderValue() {
        return String.format("%.2f", (double)getTotalOrder()/orders.size());
    }

    public String getAverageItemValue() {
        return String.format("%.2f", (double)getTotalOrder()/getTotalNumberOfItems());
        
    }
}
