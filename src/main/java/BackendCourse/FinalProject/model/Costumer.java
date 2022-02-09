package BackendCourse.FinalProject.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Data
@Builder
public class Costumer {
    @Id
    private String email;
    private String password;
    private String userName;
    private String address;
}
