package BackendCourse.FinalProject.service;

import BackendCourse.FinalProject.exception.ProductException;
import BackendCourse.FinalProject.model.Product;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.model.responseHandle.DeleteResponseHandle;
import BackendCourse.FinalProject.model.responseHandle.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    CreateResponseHandle createProduct(Product product) throws ProductException;
    List<ProductResponse> getAllCategoryProducts(String category) throws ProductException;
    ProductResponse getProduct(Integer code) throws ProductException;
    DeleteResponseHandle deleteProduct(Integer code) throws ProductException;

}
