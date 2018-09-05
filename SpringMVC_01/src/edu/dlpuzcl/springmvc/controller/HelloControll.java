package edu.dlpuzcl.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControll {
    @RequestMapping("hello")
    public ModelAndView hello(){
        System.out.println("hello springmvc....");
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据，用于传递到jsp
        modelAndView.addObject("msg","hello springmvc......");
        //设置视图名字，用于相应用户
        modelAndView.setViewName("/WEB-INF/jsp/hello.jsp");

        return modelAndView;
    }
}
