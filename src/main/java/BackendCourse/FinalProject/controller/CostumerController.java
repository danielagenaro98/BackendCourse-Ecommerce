package BackendCourse.FinalProject.controller;

import BackendCourse.FinalProject.exception.CostumerException;
import BackendCourse.FinalProject.model.Costumer;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;
import BackendCourse.FinalProject.service.CostumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class CostumerController {
    private final CostumerService costumerService;

    @PostMapping
    public CreateResponseHandle register(@RequestBody Costumer costumer) throws CostumerException {
        return costumerService.register(costumer);
    }
}
