package BackendCourse.FinalProject.service.implementation;

import BackendCourse.FinalProject.builder.CostumerBuilder;
import BackendCourse.FinalProject.exception.CostumerException;
import BackendCourse.FinalProject.model.Costumer;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.repository.CostumerRepository;
import BackendCourse.FinalProject.service.CostumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostumerServiceImpl implements CostumerService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final CostumerRepository costumerRepository;

    @Override
    public CreateResponseHandle register(Costumer costumer) throws CostumerException {
        Costumer user = costumerRepository.findByEmail(costumer.getEmail());
        if (user != null) {
            throw new CostumerException("Usuario ya se encuentra registrado");
        }
        costumer.setPassword(passwordEncoder.encode(costumer.getPassword()));
        costumerRepository.save(CostumerBuilder.requestToDocument(costumer));
        return CostumerBuilder.documentToResponse(costumer);
    }
}
