package BackendCourse.FinalProject.service;

import BackendCourse.FinalProject.exception.CartException;
import BackendCourse.FinalProject.model.CartItem;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.model.responseHandle.DeleteResponseHandle;

import java.util.List;

public interface CartService {
    CreateResponseHandle createCart(String email) throws CartException;
    CreateResponseHandle addProductToCart(String email, Integer code, Integer quantity) throws CartException;
    List<CartItem> getAllProducts(String email) throws CartException;
    DeleteResponseHandle deleteProductToCart(String email, Integer code) throws CartException;
}
