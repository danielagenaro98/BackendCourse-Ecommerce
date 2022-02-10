package BackendCourse.FinalProject.controller;

import BackendCourse.FinalProject.exception.CartException;
import BackendCourse.FinalProject.model.CartItem;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.model.responseHandle.DeleteResponseHandle;
import BackendCourse.FinalProject.service.CartService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/")
    public List<CartItem> getAllItems(@RequestParam String email) throws CartException{
        return cartService.getAllProducts(email);
    }

    @PostMapping
    public CreateResponseHandle createCart(@RequestBody ObjectNode body) throws CartException {
        String email = body.get("email").asText();
        return cartService.createCart(email);
    }

    @PostMapping("/add")
    public CreateResponseHandle addProductToCart(@RequestBody ObjectNode body) throws CartException{
        String email = body.get("email").asText();
        Integer code = body.get("code").asInt();
        Integer quantity = body.get("quantity").asInt();
        return cartService.addProductToCart(email, code, quantity);
    }

    @DeleteMapping
    public DeleteResponseHandle deleteProductToCart(@RequestBody ObjectNode body) throws CartException {
        String email = body.get("email").asText();
        Integer code = body.get("code").asInt();
        return cartService.deleteProductToCart(email, code);
    }
}
