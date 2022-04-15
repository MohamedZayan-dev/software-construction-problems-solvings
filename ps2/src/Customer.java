
import java.util.Vector;

public class Customer extends User {
    private Seller seller;
    private double balance;
    private Vector<Product> customerCart;


    public Customer(){
        // INVARIANT
        assert this.balance >= 0 : "Balance Can't be less than 0";
    }


    public Customer(int userId, String name, double balance){

        super(userId,name);

        assert this.balance > 0 : "Balance Can't be less than 0";

        this.balance=balance;
        super.accountType="Customer";
        
        customerCart= new Vector<Product>();
    }

   

    public double getbalance() {
        return balance;
    }

    public Vector<Product> getCart() {
        return customerCart;
    }

   

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }

    @Override
    public void addProduct(Product p) {
        assert balance>p.getProductCost() : "no balance";
        if(balance<p.getProductCost() && seller.myProducts.contains(p)){
            System.out.println("You (" + name + ") Have insufficient balance to add product: "+p.getProductName());
        }

        if (p.getQuantity()== 0){
            System.out.println("Product: "+p.getProductName() + " is sold out.");
        }

        if (!seller.myProducts.contains(p)){
            System.out.println("Product: "+p.getProductName()+" is not Sold by " +
                    seller.getName());
        }
        if((balance>=p.getProductCost()) && (p.getQuantity()>0) && seller.myProducts.contains(p)){
            balance-=p.getProductCost();
            p.setQuantity(p.getQuantity()-1);
            customerCart.add(p);
        }
    }

    @Override
    public void removeProduct(Product p) {
        if(customerCart.contains(p)){
            customerCart.remove(p);
            balance+=p.getProductCost();
            p.setQuantity(p.getQuantity()+1);
        }
        else{
            System.out.println("Product: "+ p.getProductName() + "was not added to customerCart");
        }
    }

}

