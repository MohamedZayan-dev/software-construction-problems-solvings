import java.util.*;

public class Order{
    Vector<Product> orderItems;
    Customer customer;
    Seller seller;
    private Date dateCreated;
    private int orderId;
    private double orderPrice;

    Order(int orderId){
        orderItems =new Vector<Product>();
        customer= new Customer();
        seller=new Seller();
        this.orderId=orderId;
    }
    public int getOrderId() {
        return orderId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setCart(Vector<Product> orderItems) {
        assert orderItems.size()>0 : "no items";
        this.orderItems = orderItems;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSeller(Seller seller) {
        assert this.seller !=null : "no seller";
        this.seller = seller;
    }

    public double calcPrice(){
        
        orderPrice=0;
        for (int i=0;i<orderItems.size();i++){
            orderPrice+=orderItems.elementAt(i).getProductCost();
        }
        return orderPrice;
    }

    public void printOrder(){
        System.out.println("Seller "+seller.getName()+", Customer: " + customer.getName()+".");
        dateCreated=new Date();
        System.out.println("Order Details");
        System.out.println("Date: " + dateCreated);
        System.out.println("Products");
        for(int i=0; i<orderItems.size();i++){
            orderItems.elementAt(i).printInfo();
            System.out.println();
        }
        System.out.println("Total" + calcPrice());
    }

}

