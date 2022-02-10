package BackendCourse.FinalProject.service;

import BackendCourse.FinalProject.exception.OrderException;
import BackendCourse.FinalProject.model.responseHandle.CreateResponseHandle;

public interface OrderService {
    CreateResponseHandle createOrder(String email, String state) throws OrderException;
}
