package BackendCourse.FinalProject.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("products")
public class Product {
    @Id
    private String id;
    private Integer code;
    private Float price;
    private String description;
    private String category;
}
