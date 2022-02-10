package BackendCourse.FinalProject.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document("orders")
public class Order {
    private Long orderNumber;
    private String state;
    private Costumer costumer;
    private List<OrderItem> items;
}
