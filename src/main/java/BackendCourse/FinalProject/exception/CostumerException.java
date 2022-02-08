package BackendCourse.FinalProject.exception;

import lombok.Data;

@Data
public class CostumerException extends Exception {

    public CostumerException(String message){
        super(message);
    }
}
