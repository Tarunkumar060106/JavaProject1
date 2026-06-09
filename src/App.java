
public class App {
    public static void main(String[] args) throws Exception {

        //Shopperstop company was incorporated
        var company = new Company("Shopperstop");
		System.out.println(company.getName());


        //Company buys 3 items: Shirt, Pant, Shoes
        var shirt = new Item(1, "Allen Solly", 2000.0);
        var pant = new Item(2, "Levis", 3000.0);
        var shoes = new Item(3, "Nike", 5000.0);
        //added to inventory
        company.addItem(shirt);
        company.addItem(pant);
        company.addItem(shoes);
        
        // Checking the available inventory
        // System.out.println("Items available in the company: ");
        // for(Item item : company.getItems()) {
        //     System.out.println(item.getTitle() + " - INR. " + item.getRate() + " - " + item.getItemNo());
        // }

        //Regular customer comes to buy items
        var regularCustomer = new Customer();
        regularCustomer.setName("Tarun");

        //2 pants and 1 shirt from the store
        var orderItem1 = new OrderItem(pant, 2);
        var orderItem2 = new OrderItem(shirt, 1);
        
        //regularCustomer -> billing counter
        var regularOrder = new Order();
        regularOrder.setOrderId(1);
        regularOrder.setCustomer(regularCustomer);

        //Items added to order
        regularOrder.addOrderItem(orderItem1);
        regularOrder.addOrderItem(orderItem2);

        //payment is done
        regularCustomer.addOrder(regularOrder);

        //transaction is complete, customer -> company
        company.addCustomer(regularCustomer);

        //---------------------------------------------
        //registered customer -> 10% discount
        var registeredCustomer = new RegisteredCustomer();
        registeredCustomer.setName("Manish");
        // registeredCustomer.setDiscount(20.0);
        // registeredCustomer.setFees(20000.0);
        // registeredCustomer.setMembershipType("Platinum");

        var membership = new Membership();
        membership.setMembershipType("Platinum");
        membership.setDiscount(20.0);
        membership.setFees(20000.0);

        registeredCustomer.setMembership(membership);

        var orderItem3 = new OrderItem(pant, 2);
        var orderItem4 = new OrderItem(shoes, 2);

        var registeredOrder = new Order();
        registeredOrder.setOrderId(2);

        registeredOrder.addOrderItem(orderItem3);
        registeredOrder.addOrderItem(orderItem4);

        registeredCustomer.addOrder(registeredOrder);

        

        company.addCustomer(registeredCustomer);

        //Checking the total order value of the company
        System.out.println("Total Order Value of the Company: " + company.getTotalOrderValueV2());
    }
}


/*

-- June 9th
Classes and Objects
Getters and Setters
Interfaces
Collections - List and Map
Design Principles and Patterns - SOLID, Structural Design Patterns
Unit Testable Code
Test Main Code - This is very important for you to know how to test your code

*/