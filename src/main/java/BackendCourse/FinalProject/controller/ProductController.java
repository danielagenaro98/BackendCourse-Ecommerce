package BackendCourse.FinalProject.controller;

import BackendCourse.FinalProject.exception.ProductException;
import BackendCourse.FinalProject.model.Product;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.model.responseHandle.DeleteResponseHandle;
import BackendCourse.FinalProject.model.responseHandle.ProductResponse;
import BackendCourse.FinalProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/")
    public List<ProductResponse> getCategoryProducts(@RequestParam String category) throws ProductException {
        return productService.getAllCategoryProducts(category);
    }

    @GetMapping("/{code}")
    public ProductResponse getProduct(@PathVariable Integer code) throws ProductException {
        return productService.getProduct(code);
    }

    @PostMapping
    public CreateResponseHandle createProduct(@RequestBody Product product) throws ProductException {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{code}")
    public DeleteResponseHandle deleteProduct(@PathVariable Integer code) throws ProductException {
        return productService.deleteProduct(code);
    }
}
