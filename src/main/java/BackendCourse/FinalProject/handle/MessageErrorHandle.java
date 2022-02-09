package BackendCourse.FinalProject.handle;

import BackendCourse.FinalProject.exception.CostumerException;
import BackendCourse.FinalProject.exception.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MessageErrorHandle {
    @ResponseBody
    @ExceptionHandler({CostumerException.class, ProductException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorMessage messageErrorHandle(Exception ex){
        return ErrorMessage.of(ex.getMessage());
    }
}
