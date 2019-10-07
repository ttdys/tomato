package com.zjh.tomato.exception;

import com.zjh.tomato.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zjh
 */
@ControllerAdvice
public class CommonExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(CommonException.class)
    public ModelAndView commonException(CommonException e,ModelAndView modelAndView) {
        String message = e.getMessage();
        modelAndView.setViewName("error");
        modelAndView.addObject(ResultData.fail(message));
        logger.info("{} occur error things {}",e,e.getMessage());
        return modelAndView;
    }

}
