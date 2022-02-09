package BackendCourse.FinalProject.builder;

import BackendCourse.FinalProject.model.Costumer;
import BackendCourse.FinalProject.model.Product;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.model.responseHandle.DeleteResponseHandle;
import BackendCourse.FinalProject.model.responseHandle.ProductResponse;

import java.util.ArrayList;
import java.util.List;

public class ProductBuilder {

    public static Product requestToDocument(Product request){
        return Product.builder()
                .code(request.getCode())
                .category(request.getCategory())
                .price(request.getPrice())
                .description(request.getDescription())
                .build();
    }

    public static CreateResponseHandle productCreationResponse(String id){
        return CreateResponseHandle.builder()
                .id(id)
                .build();
    }

    public static DeleteResponseHandle productDeleteResponse(String id, String msj) {
        return DeleteResponseHandle.builder()
                .id(id)
                .message(msj)
                .build();
    }

    public static ProductResponse documentToResponse(Product product){
        return ProductResponse.builder()
                .code(product.getCode())
                .category(product.getCategory())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }

    public static List<ProductResponse> listDocumentToResponse(List<Product> products){
        var response =  new ArrayList<ProductResponse>();
        products.forEach(doc ->response.add(documentToResponse(doc)));
        return response;
    }
}
