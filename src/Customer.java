import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerId;
    private String name;

    //Has-A Many
    private List<Order> orders;
    
    //MIC - Mixed Instance Cohesion
    //Mixing some other instance data into this instance
    //Solve via Is-A - Move to RegisteredCustomer

    //Getters and Setters
    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    //Constructor
    public Customer() {
        this.orders = new ArrayList<>();
    }

    //Functional Methods
    public double getTotalOrderValueV1(){
        double totalOrderValue = 0.0;
        for (Order order : this.getOrders()) {
            for (OrderItem orderItem : order.getOrderItem()) {
                totalOrderValue += orderItem.getQuantity() * orderItem.getItem().getRate();
            }
        }
        return totalOrderValue;
    }
    public double getTotalOrderValueV2(){
        double totalOrderValue = 0.0;
        for (Order order : this.getOrders()) {    
            totalOrderValue += order.getTotalOrderValue();
        }
        return totalOrderValue;   
    }
}

