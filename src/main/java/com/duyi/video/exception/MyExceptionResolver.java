package com.duyi.video.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sujuntao
 */
@Component
public class MyExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");

        if (e instanceof UserException) {

            mv.addObject("message", e.getMessage());
        }else {

            mv.addObject("message", "出错了");
        }
        return mv;
    }
}
