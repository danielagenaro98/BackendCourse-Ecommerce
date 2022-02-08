package BackendCourse.FinalProject.repository;

import BackendCourse.FinalProject.model.Costumer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends MongoRepository<Costumer, String> {
    Costumer findByUserName(String name);
    Costumer findByEmail(String email);
}
