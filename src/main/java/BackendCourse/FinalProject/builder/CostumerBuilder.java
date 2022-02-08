package BackendCourse.FinalProject.builder;

import BackendCourse.FinalProject.model.Costumer;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;

public class CostumerBuilder {

    public static Costumer requestToDocument(Costumer request){
        return Costumer.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public static CreateResponseHandle documentToResponse(Costumer costumer){
        return CreateResponseHandle.builder()
                .id(costumer.getEmail())
                .build();
    }
}
