package BackendCourse.FinalProject.exception;

import lombok.Data;

@Data
public class CartException extends Exception{
    public CartException(String message){
        super(message);
    }
}
