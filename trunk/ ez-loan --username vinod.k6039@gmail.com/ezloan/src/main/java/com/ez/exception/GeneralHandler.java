package com.ez.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

//@ControllerAdvice
public class GeneralHandler {

   @ExceptionHandler
   public ModelAndView handleException (NoSuchRequestHandlingMethodException ex) {
        ModelAndView mav = new ModelAndView();
        return mav;
   }
}
