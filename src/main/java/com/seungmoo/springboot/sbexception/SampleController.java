package com.seungmoo.springboot.sbexception;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* 스프링 MVC 예외 처리 방법은 크게 @ControllerAdvice, @ExceptionHandler 이렇게 있다.
* 스프링부트에서는 기본적으로 BasicErrorController라는 것을 제공하고 있으며 따로 exception 처리안하면 디폴트로 에러처리 해준다.
* */

@Controller
public class SampleController {
    @GetMapping("/hello")
    public String hello() {
        throw new SampleException();
    }

    @ExceptionHandler(SampleException.class)
    public @ResponseBody AppError sampleError(SampleException e) {
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("IDK IDK IDK");
        return appError;
    }
}
