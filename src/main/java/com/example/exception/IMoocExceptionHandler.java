package com.example.exception;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class IMoocExceptionHandler {

    private static final String IMOOC_ERROR_VIEW = "error";

    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(IMOOC_ERROR_VIEW);
        return mav;
    }
}
