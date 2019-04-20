package com.example.exception;

import com.example.utils.BBResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class BBExceptionHandler {

    public static final String IMOOC_ERROR_VIEW = "thymeleaf/error";
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest httpRequest,
                               HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        if (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) ) {
            return BBResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", httpRequest.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
        }
    }

}
