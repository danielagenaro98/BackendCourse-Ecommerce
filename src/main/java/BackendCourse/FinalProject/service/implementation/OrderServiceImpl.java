package BackendCourse.FinalProject.service.implementation;

import BackendCourse.FinalProject.builder.OrderBuilder;
import BackendCourse.FinalProject.exception.OrderException;
import BackendCourse.FinalProject.model.Cart;
import BackendCourse.FinalProject.model.Costumer;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.repository.CartRepository;
import BackendCourse.FinalProject.repository.CostumerRepository;
import BackendCourse.FinalProject.repository.OrderRepository;
import BackendCourse.FinalProject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CartRepository cartRepository;
    private final CostumerRepository costumerRepository;
    private final OrderRepository orderRepository;

    @Override
    public CreateResponseHandle createOrder(String email, String state) throws OrderException {
        Cart cart = cartRepository.findByEmail(email);
        Costumer costumer = costumerRepository.findByEmail(email);
        Long orderNumber = orderRepository.countByCostumer(costumer);
        if(Objects.isNull(cart)){
            throw new OrderException("No se encuentra carrito de compras para ese usuario");
        }

        orderRepository.save(OrderBuilder.requestToDocument(cart, costumer, state, orderNumber));
        return OrderBuilder.documentToResponse("la orden se creo correctamente");
    }
}
