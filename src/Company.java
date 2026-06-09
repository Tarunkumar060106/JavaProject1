import java.util.ArrayList;
import java.util.List;

public class Company {
    //Data Elements - Private and Protected
    private String name;
    //Has-A Company has many items
    //Early intialization
    //private List<Item> items = new ArrayList<Item>();
    //Define the variable
    private List<Item> items;

    //Has-A Many Unidirectional
    private List<Customer> customers;

    //Getters and setters - Methods with which you access the data
    //Get method is to access the element from outside
    public String getName(){
        return this.name;
    }
    //Set method is to set the value insidethe variable
    public void setName(String name){
        this.name = name;
    }
    public List<Item> getItems(){
        return this.items;
    }
    //Whenever we have collections, we always have an add method
    //this will add one item at a time into the colletion
    public void addItem(Item item){
        this.items.add(item);
    }

    public List<Customer> getCustomers(){
        return this.customers;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }


    //Constructors - Parameterised
    public Company(String name){
        this.name = name;
        //Initialise the object inside the constructor
        this.items = new ArrayList<Item>();
        this.customers = new ArrayList<Customer>();
    }


    //Functional Methods

        public double getTotalOrderValueV1(){
        double totalOrderValue = 0.0;
       
        //Write the logic to calculate the total order value of the company
        //Should take the rate and multiply with the quantity and add to the total order value
        for(Customer customer: this.customers){
            for(Order order: customer.getOrders()){
                for(OrderItem orderItem: order.getOrderItem()){
                    //We are multiplying the quantity and the rate and adding to the total order value
                    if(customer instanceof RegisteredCustomer){
                        RegisteredCustomer registeredCustomer = (RegisteredCustomer) customer;
                        double discount = registeredCustomer.getDiscount();
                        totalOrderValue += orderItem.getQuantity() * orderItem.getItem().getRate() * (1 - discount/100);
                    }
                    //OCP - Open Closed Principle
                    //A class should be Open for extension but Closed for modification
                    //if(customer instanceof PrivilegeCustomer){
                    //    //Write logic here
                    //}
                    //Solved with the help of Run Time Polymorphism - Method Overriding
                    else
                        totalOrderValue += orderItem.getQuantity() * orderItem.getItem().getRate();
                }
            }
        }
        
        return totalOrderValue;
    }

    public double getTotalOrderValueV2(){
        double totalOrderValue = 0.0;
       
        //No if else and any type of customer and still the logic will worl seamlessly without a change in this code
        for(Customer customer: this.customers){
            totalOrderValue += customer.getTotalOrderValueV2();
        }
        
        return totalOrderValue;
    }
    //Helper Methods
}
