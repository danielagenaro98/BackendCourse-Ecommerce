package BackendCourse.FinalProject.iterceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ProductInterceptor {

    @After(value = "execution(* BackendCourse.FinalProject.service.implementation.ProductServiceImpl.*(..))")
    void afterMethods(){
        log.info("Se ejecuto el after advice luego de la ejecucion de un metodo de la capa ProductService");
    }
    @AfterThrowing("execution(* BackendCourse.FinalProject.service.implementation.ProductServiceImpl.*(..))")
    void afterThrowingMethods(){
        log.error("Se ejecuto el after advice luego de una excepcion de un metodo de la capa ProductService");
    }
}
