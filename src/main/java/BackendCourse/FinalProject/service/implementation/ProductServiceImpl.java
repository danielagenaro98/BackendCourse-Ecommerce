package BackendCourse.FinalProject.service.implementation;

import BackendCourse.FinalProject.builder.ProductBuilder;
import BackendCourse.FinalProject.exception.ProductException;
import BackendCourse.FinalProject.model.Product;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.model.responseHandle.DeleteResponseHandle;
import BackendCourse.FinalProject.model.responseHandle.ProductResponse;
import BackendCourse.FinalProject.repository.ProductRepository;
import BackendCourse.FinalProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> getAllProducts() {
        return ProductBuilder.listDocumentToResponse(productRepository.findAll());
    }

    @Override
    public List<ProductResponse> getAllCategoryProducts(String category) throws ProductException{
        List<Product> products = productRepository.findByCategory(category);
        if (products.isEmpty()) {
            throw new ProductException("No se encontraron productos en esa categoria");
        }
        return ProductBuilder.listDocumentToResponse(products);
    }

    @Override
    public ProductResponse getProduct(Integer code) throws ProductException{
        Product prod = productRepository.findByCode(code);
        if (Objects.isNull(prod)) {
            throw new ProductException("No se encuentran productos con ese código");
        }
        return ProductBuilder.documentToResponse(prod);
    }

    @Override
    public CreateResponseHandle createProduct(Product product) throws ProductException {
        Product prod = productRepository.findByCode(product.getCode());
        if (!Objects.isNull(prod)) {
            throw new ProductException("El producto ya se encuentra registrado");
        }
        productRepository.save(ProductBuilder.requestToDocument(product));
        return ProductBuilder.productCreationResponse(product.getCategory());
    }

    @Override
    public DeleteResponseHandle deleteProduct(Integer code) throws ProductException{
        Product prod = productRepository.findByCode(code);
        if (Objects.isNull(prod)) {
            throw new ProductException("El producto que intenta eliminar no existe");
        }
        productRepository.delete(prod);
        return ProductBuilder.productDeleteResponse(String.valueOf(code), "Producto eliminado correctamente");
    }
}
