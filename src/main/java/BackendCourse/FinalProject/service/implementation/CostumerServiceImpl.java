package BackendCourse.FinalProject.service.implementation;

import BackendCourse.FinalProject.builder.CostumerBuilder;
import BackendCourse.FinalProject.exception.CostumerException;
import BackendCourse.FinalProject.model.Costumer;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.repository.CostumerRepository;
import BackendCourse.FinalProject.service.CostumerService;
import BackendCourse.FinalProject.service.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostumerServiceImpl implements CostumerService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private final CostumerRepository costumerRepository;
    private final EmailService emailService;

    @Override
    public CreateResponseHandle register(Costumer costumer) throws CostumerException {
        Costumer user = costumerRepository.findByEmail(costumer.getEmail());
        if (user != null) {
            throw new CostumerException("Usuario ya se encuentra registrado");
        }
        costumer.setPassword(passwordEncoder.encode(costumer.getPassword()));
        costumerRepository.save(CostumerBuilder.requestToDocument(costumer));
        emailService.sendMail(costumer.getEmail(), "Registro de usuario", "Registro de usuario exitoso.");
        return CostumerBuilder.documentToResponse(costumer);
    }
}
