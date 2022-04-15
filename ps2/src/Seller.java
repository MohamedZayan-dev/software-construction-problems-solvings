
import java.util.Vector;

public class Seller extends User {
    private int productsNum; 
    Vector<Product> myProducts;

    public Seller(){
        // INVARIANT
        this.name = " ";
    }


    public Seller(int userId,String name) {
        super(userId,name);

        super.accountType="Seller";
        myProducts = new Vector<Product>();
        productsNum=myProducts.size();
    }

    
    public void updateQuantity(Product p, int q){
        assert myProducts.contains(p) : "The product is in not your List";
        p.setQuantity(q);
    }

    @Override
    public void addProduct(Product p) {
        myProducts.add(p);
    }

    public void  removeProduct(Product p){
        assert myProducts.contains(p) : "The product doesn't exist in your list";
        myProducts.remove(p);
    }

    public int getProductsNum() {
        return productsNum;
    }

    @Override
    public void printInfo() {
        System.out.println("    Seller Information");
        System.out.println("********************************");
        super.printInfo();
    }

}

