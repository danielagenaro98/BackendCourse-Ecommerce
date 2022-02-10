package BackendCourse.FinalProject.repository;

import BackendCourse.FinalProject.model.Costumer;
import BackendCourse.FinalProject.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    Long countByCostumer(Costumer costumer);
}
