package BackendCourse.FinalProject.builder;

import BackendCourse.FinalProject.model.Cart;
import BackendCourse.FinalProject.model.Costumer;
import BackendCourse.FinalProject.model.Order;
import BackendCourse.FinalProject.model.OrderItem;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;

import java.util.List;

public class OrderBuilder {

    public static CreateResponseHandle documentToResponse(String msj){
        return CreateResponseHandle.builder()
                .id(msj)
                .build();
    }

    public static Order requestToDocument(Cart cart, Costumer costumer, String state, Long orderNumber){
        List<OrderItem> items = cart.generateOrderItems();
        return Order.builder()
                .costumer(costumer)
                .items(items)
                .state(state)
                .orderNumber(orderNumber)
                .build();
    }
}
