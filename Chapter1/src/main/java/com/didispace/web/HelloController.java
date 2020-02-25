package com.didispace.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "index";
    }

    @RequestMapping("/my")
    public ModelAndView index2(Model model) {
        User user = new User();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index.jsp");
        mv.addObject("name", "liyafei");
        user.setAge(20);
        user.setName("wangwu");
        model.addAttribute("user", user);
        mv.addObject("user", user);

        //设置返回的数据为json类型，也可以不设置，返回对象
        //mv.setView(new MappingJackson2JsonView());
        return mv;
    }
}