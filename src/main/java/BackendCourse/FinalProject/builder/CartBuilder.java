package BackendCourse.FinalProject.builder;

import BackendCourse.FinalProject.model.Cart;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.model.responseHandle.DeleteResponseHandle;

import java.util.ArrayList;

public class CartBuilder {

    public static CreateResponseHandle documentToResponse(String msj){
        return CreateResponseHandle.builder()
                .id(msj)
                .build();
    }

    public static Cart requestToDocument(String email){
        return Cart.builder()
                .email(email)
                .items(new ArrayList<>())
                .build();
    }

    public static DeleteResponseHandle itemDeleteResponse(String id, String msj) {
        return DeleteResponseHandle.builder()
                .id(id)
                .message(msj)
                .build();
    }
}
