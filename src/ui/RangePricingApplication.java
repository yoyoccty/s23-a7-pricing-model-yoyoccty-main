/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.Random;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.Order;
import model.Personnel.Person;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductsReport;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class RangePricingApplication {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here


    // 1. Populate the model +

    Business business = ConfigureABusiness.createABusinessAndLoadALotOfData("Xerox", 30, 10, 30, 100, 10);


    // set customer id
    for (int i = 0; i < business.getCustomerDirectory().getCustomerList().size(); i++){
      business.getCustomerDirectory().getCustomerList().get(i).setCustomerId(Integer.toString(i));
    }
   // 2. Maybe some interaction with the user (optional)

   

    
   // 3. Show some analytics (Summerizing, comparing, sorting, grouping data by some criteria)

        //populate the model with 30 suppliers

  


    //pick 5 different Suppliers and add 20 Products to each
    for (int i = 0; i < 5; i++){
      Supplier randomSupplier = business.getSupplierDirectory().pickRandomSupplier();
      for (int j = 0; j < 20; j++){
        randomSupplier.getProductCatalog().newProduct("Product" + j, 10, 20, 30);
      }
    }






    // For each Customer add 5 to 15 Orders with 1 to 5 Items to each
    for (int i = 0; i < business.getCustomerDirectory().getCustomerList().size(); i++){ // all customers
      CustomerProfile selectedCustomer = business.getCustomerDirectory().findCustomer(Integer.toString(i));
      selectedCustomer.setOrders(new ArrayList<Order>()); //workaround 
      System.out.println("Customer ID: " + selectedCustomer.getCustomerId());
      Random random = new Random();
      int randomNumber = random.nextInt(11) + 5;
      for (int j = 0; j < randomNumber; j++){ // 5 to 15 orders
        Order order = new Order(selectedCustomer);
        int randomNumber1 = random.nextInt(5) + 1;
        for(int k = 0; k < randomNumber1; k++){ // 1 to 5 items
          order.newOrderItem(new Product("Product"+k, 10, 20, 30), 10, 2);
        }
        //selectedCustomer.addCustomerOrder(order); 
        System.out.println("Total Order: " + selectedCustomer.getTotalOrder());
      }
      System.out.println("Number of orders: " + selectedCustomer.getOrder().size());
    }
    System.out.println("========================DSADSAD=====");

    System.out.println(business.getCustomerDirectory().getCustomerList().size());
    System.out.println("===========================DSDSAD==");

    //report
    for (int i = 0; i < business.getCustomerDirectory().getCustomerList().size(); i++){
      CustomerProfile customer = business.getCustomerDirectory().getCustomerList().get(i);
      System.out.println("Customer ID: " + customer.getCustomerId());
      System.out.println("Total Order: " + customer.getTotalOrder());
      System.out.println("Number of orders: " + customer.getOrder().size());
      System.out.println("Total number of items: " + customer.getTotalNumberOfItems());
      System.out.println("=============================");
    }

    

    SupplierDirectory sd = business.getSupplierDirectory();
    Supplier randomSupplier = sd.pickRandomSupplier();
    ProductCatalog pd = randomSupplier.getProductCatalog();
    ProductsReport myFirstReport = pd.generatProductPerformanceReport();
    myFirstReport.printProductReport();






  }
}