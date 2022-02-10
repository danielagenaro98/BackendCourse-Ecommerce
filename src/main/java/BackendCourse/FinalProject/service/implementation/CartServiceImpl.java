package BackendCourse.FinalProject.service.implementation;

import BackendCourse.FinalProject.builder.CartBuilder;
import BackendCourse.FinalProject.exception.CartException;
import BackendCourse.FinalProject.model.Cart;
import BackendCourse.FinalProject.model.CartItem;
import BackendCourse.FinalProject.model.Product;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.model.responseHandle.DeleteResponseHandle;
import BackendCourse.FinalProject.repository.CartRepository;
import BackendCourse.FinalProject.repository.ProductRepository;
import BackendCourse.FinalProject.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Queue;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final MongoTemplate template;

    @Override
    public CreateResponseHandle createCart(String email) throws CartException {
        Cart cart = cartRepository.findByEmail(email);
        if(!Objects.isNull(cart)){
            throw new CartException("El carrito ya se encuentra creado");
        }
        cartRepository.save(CartBuilder.requestToDocument(email));
        return CartBuilder.documentToResponse("el carrito fue creado");
    }

    @Override
    public CreateResponseHandle addProductToCart(String email, Integer code, Integer quantity) throws CartException {

        existsCart(email);
        Product prod = existProduct(code);

        CartItem item = new CartItem(prod, quantity);
        Update update = new Update();
        update.push("items", item);
        Criteria criteria = Criteria.where("email").is(email);
        template.updateFirst(Query.query(criteria), update, "cart");
        return CartBuilder.documentToResponse("El producto fue agregado al carrito");
    }

    @Override
    public List<CartItem> getAllProducts(String email) throws CartException{
        Cart cart = existsCart(email);
        return cart.getItems();
    }

    @Override
    public DeleteResponseHandle deleteProductToCart(String email, Integer code) throws CartException {
        Cart cart = existsCart(email);
        CartItem item = searchItem(code, cart);
        Update update = new Update();
        update.pull("items", item);
        Criteria criteria = Criteria.where("email").is(email);
        template.updateFirst(Query.query(criteria), update, "cart");
        return CartBuilder.itemDeleteResponse(String.valueOf(code), "El producto fue eliminado del carrito");
    }

    private Cart existsCart(String email) throws CartException {
        Cart cart = cartRepository.findByEmail(email);
        if(Objects.isNull(cart)){
            throw new CartException("El carrito no existe");
        }
        return cart;
    }

    private Product existProduct(Integer code) throws CartException{
        Product prod = productRepository.findByCode(code);
        if(Objects.isNull(prod)){
            throw new CartException("El producto que intenta agregar al carrito no existe");
        }
        return prod;
    }

    private CartItem searchItem(Integer code, Cart cart) {
        CartItem item = null;
        List<CartItem> items = cart.getItems();

        for (CartItem it : items){
            if(Objects.equals(it.getProduct().getCode(), code)){
                item = it;
            }
        }

        return item;
    }
}
