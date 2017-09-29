package com.vetoer.web;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Component
public class IndexController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(Model model){
        // 获取主页
        return "/clxj/index";
    }
}
