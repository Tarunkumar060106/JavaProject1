public class RegisteredCustomer extends Customer{
    private double discount;

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    //Functional Methods
    @Override
    public double getTotalOrderValueV1() {
        double totalOrderValue = 0.0;
        for(Order order : this.getOrders()) {
            for(OrderItem orderItem: order.getOrderItem()){
                totalOrderValue += orderItem.getQuantity() * orderItem.getItem().getRate();
            }
        }
        return totalOrderValue * (1-this.discount/100);
    }

    @Override
    public double getTotalOrderValueV2() {
        double totalOrderValue = 0.0;

        for (Order order : this.getOrders()) {
            totalOrderValue += order.getTotalOrderValue();
        }

        return totalOrderValue * (1 - this.discount / 100);
    }
}
