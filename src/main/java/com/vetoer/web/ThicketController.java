package com.vetoer.web;

import com.vetoer.entity.Thicket;
import com.vetoer.service.UserExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 后台管理系统
 */
@Component
@RequestMapping("/thicket")
public class ThicketController {
    @Autowired
    private UserExecutionService userExecutionService;

    // 增加丛林或闲居,通过url type值确定
    @RequestMapping(value = "/{thicketType}/add",method = RequestMethod.GET)
    public String thicketform(@PathVariable("thicketType") String thicketType, Model model){
        // 获取管理主页
        if("cl".equals(thicketType)) {
            model.addAttribute("addressType", "丛林");
            model.addAttribute("type", 1);
            return "addThicket";
        }else if("xj".equals(thicketType)) {
            model.addAttribute("addressType", "闲居");
            model.addAttribute("type", 0);
            return "addThicket";
        }else{
            return null;
        }
    }
    // 加盟操作
    public String thicketAdd(Thicket thicket,Model model){
        
        return "";
    }
}
