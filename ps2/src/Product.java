

public class Product {
    private int id;
    private double cost;
    private String name;
    private int quantity;

    public Product(int id,String name,double cost)
    {
        // INVARIANT
        assert this.quantity >= 0 :"Quantity can not be less than 0";
        assert this.cost >0 :"Product cost must be positive";

        this.id=id;
        this.name=name;
        this.cost=cost;

    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId(){return id;}
    public String getProductName(){return name;}
    public int getQuantity(){return quantity;}
    public double getProductCost(){return cost;}

    public void printInfo(){
        System.out.println("Product ID: " + id);
        System.out.println("Product: " + name);
        System.out.println("Price: " + cost);
    }
}

