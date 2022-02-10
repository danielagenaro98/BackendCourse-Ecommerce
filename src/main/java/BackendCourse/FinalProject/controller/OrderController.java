package BackendCourse.FinalProject.controller;

import BackendCourse.FinalProject.exception.OrderException;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.service.OrderService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public CreateResponseHandle createOrder(@RequestBody ObjectNode body) throws OrderException {
        String email = body.get("email").asText();
        String state = body.get("state").asText();
        return orderService.createOrder(email, state);
    }
}
