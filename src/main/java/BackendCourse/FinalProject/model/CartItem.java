package BackendCourse.FinalProject.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {
    private Product product;
    private Integer quantity;

    public CartItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
