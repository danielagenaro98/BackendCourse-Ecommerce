package BackendCourse.FinalProject.model;

public class OrderItem extends CartItem {

    private Float price;

    public OrderItem(Product product, Integer quantity, Float price) {
        super(product, quantity);
        this.price = price;
    }
}
