import java.util.*;
public class Order {

    //Data Members
    private int orderId;

    //Has-A One
    private Customer customer;
    private List<OrderItem> orderItems;

    //Getter and Setter
    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItem() {
        return this.orderItems;
    }

    public void addOrderItem(OrderItem orderItem){
        this.orderItems.add(orderItem);
    }

    //Constructor
    public Order(){
        this.orderItems = new ArrayList<>();
    }

    public double getTotalOrderValue() {
        double totalOrderValue = 0.0;
        for(OrderItem orderItem : this.getOrderItem()){
            totalOrderValue += orderItem.getItemTotal();
        }

        return totalOrderValue;
    }
}
