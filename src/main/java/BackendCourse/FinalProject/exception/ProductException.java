package BackendCourse.FinalProject.exception;

import lombok.Data;

@Data
public class ProductException extends Exception{
    public ProductException(String message){
        super(message);
    }
}
