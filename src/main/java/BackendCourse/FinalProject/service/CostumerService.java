package BackendCourse.FinalProject.service;

import BackendCourse.FinalProject.exception.CostumerException;
import BackendCourse.FinalProject.model.Costumer;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;

public interface CostumerService {
    CreateResponseHandle register(Costumer request) throws CostumerException;
}
