package BackendCourse.FinalProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Costumer {
    @Id
    private String email;
    private String password;
    private String userName;
    private String address;
}
