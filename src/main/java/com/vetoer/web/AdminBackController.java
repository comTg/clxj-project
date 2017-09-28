package com.vetoer.web;

import com.vetoer.service.UserExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 后台管理系统
 */
@Component
@RequestMapping("/clxjback")
public class AdminBackController {
    @Autowired
    private UserExecutionService userExecutionService;

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(Model model){
        // 获取管理主页
        return "/clxjback/admin";
    }
}
