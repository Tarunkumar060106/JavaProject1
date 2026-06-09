public class OrderItem {
    //Data Members
    public Item item;
    private int quantity;

    //Getter and Setter
    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Constructor
    public OrderItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getItemTotal() {
        return this.quantity * this.item.getRate();
    }
}
