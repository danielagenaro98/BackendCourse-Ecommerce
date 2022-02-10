package BackendCourse.FinalProject.repository;

import BackendCourse.FinalProject.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findByEmail(String email);
}
