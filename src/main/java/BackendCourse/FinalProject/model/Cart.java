package BackendCourse.FinalProject.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document("cart")
public class Cart {
    private String email;
    private List<CartItem> items;

    public void addItem(CartItem item) {
        this.items.add(item);
    }

    public List<OrderItem> generateOrderItems() {
        List<OrderItem> res = null;
        for(CartItem item :items){
            res.add(new OrderItem(item.getProduct(), item.getQuantity(), item.getProduct().getPrice()));
        }
        return res;
    }
}
