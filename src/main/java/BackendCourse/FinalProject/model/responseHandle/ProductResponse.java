package BackendCourse.FinalProject.model.responseHandle;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
    private Integer code;
    private Float price;
    private String description;
    private String category;
}
