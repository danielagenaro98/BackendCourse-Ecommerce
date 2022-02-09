package BackendCourse.FinalProject.model.responseHandle;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteResponseHandle {
    private String id;
    private String message;
}
