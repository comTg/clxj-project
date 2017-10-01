package com.vetoer.web;

import com.vetoer.dto.LeagueExecution;
import com.vetoer.entity.PageCode;
import com.vetoer.entity.Thicket;
import com.vetoer.entity.ThicketAdmin;
import com.vetoer.service.ThicketExecutionService;
import com.vetoer.service.UserExecutionService;
import com.vetoer.util.ModelUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理系统
 */
@Controller
@Component
@RequestMapping("/clxj")
public class ThicketController {
    @Autowired
    private ThicketExecutionService thickService;

    // 增加丛林或闲居,通过url type值确定
    @RequestMapping(value = "/{thicketType}/add")
    public String thicketform(@PathVariable("thicketType") String thicketType,
                              @CookieValue(value = "userPhone",required = false)String userPhone,
                              Model model){
        // 获取管理主页,首先判断cookie是否存在
        System.out.println(userPhone);
        if(userPhone==null){
            model = ModelUtil.alterModel(model,"110","您还没有登录,请先登录","/clxj/login",false);
            return "executionSuccess";
        }
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
    @RequestMapping(value = "/league",method = RequestMethod.POST)
    public String thicketAdd(Thicket thicket,Model model){
        // 先增加管理员用户
        // 再加盟
        int type = thicket.getType();
        String addressType = thicket.getAddressType();
        LeagueExecution execution = thickService.addAdmin(thicket.getThicketAdmin());
        if(execution.getState()==2){
            ThicketAdmin admin = thickService.queryAdmin(thicket.getThicketAdmin().getPhone());
            thicket.setThicketAdmin(admin);
            execution = thickService.addThicket(thicket);
            if(execution.getState()==1){
                // 加盟成功
                model = ModelUtil.alterModel(model,admin.getPhone(),"加盟成功","/clxj/index",false);
                return "executionSuccess";
            }
            model.addAttribute("error","加盟失败,请重试");
            model.addAttribute("addressType",addressType);
            model.addAttribute("type", type);
            return "addThicket";
        }
        model.addAttribute("error","该用户已加盟,请进入后台管理");
        model.addAttribute("addressType",addressType);
        model.addAttribute("type", type);
        return "addThicket";
    }
    // 所有丛林页面,分页显示
    @RequestMapping(value = "/{addressType}/list")
    public String thicket_list(@PathVariable("addressType")String addressType, Model model){
        int type=1;
        if("cl".equals(addressType)) {
            type = 1;
        }else if("xj".equals(addressType)){
            type = 0;
        }
        int countThicket = thickService.countThicket(type);
        Map<String,Object> maps = ModelUtil.getPageCode(model,addressType,0,countThicket);
        model = (Model) maps.get("model");
        List<PageCode> pageCodes = (List<PageCode>) maps.get("pageCode_list");
        System.out.println(countThicket+"~~~~~");
        String resultType = maps.get("resultType").toString();
        List<Thicket> thickets = thickService.queryAll(0,9,type);
        model.addAttribute("pageCode_list",pageCodes);
        model.addAttribute("addressType",resultType);
        model.addAttribute("thicket_list",thickets);
        model.addAttribute("urlType",addressType);
        model.addAttribute("activateState","active");
        return "thicketDetail";
    }
    // page从2开始
    @RequestMapping(value = "/{addressType}/list/page={page}")
    public String thicket_page(@PathVariable("addressType")String addressType,@PathVariable("page")int page, Model model){
        int type=1;
        if("cl".equals(addressType)) {
            type = 1;
        }else if("xj".equals(addressType)){
            type = 0;
        }
        int countThicket = thickService.countThicket(type);
        int offset = (page-1)*9-1;
        Map<String,Object> maps = ModelUtil.getPageCode(model,addressType,page,countThicket);
        List<PageCode> pageCodes = (List<PageCode>) maps.get("pageCode_list");

        model = (Model) maps.get("model");
        String resultType = maps.get("resultType").toString();
        List<Thicket> thickets = thickService.queryAll(offset,9,type);
        model.addAttribute("pageCode_list",pageCodes);
        model.addAttribute("addressType",resultType);
        model.addAttribute("thicket_list",thickets);
        model.addAttribute("urlType",addressType);
        return "thicketDetail";
    }
    // 进入丛林闲居详情页面
    @RequestMapping(value = "/thicket/detail/id={id}")
    public String getThicketDetail(@PathVariable("id")int id,Model model){
        Thicket thicket = thickService.queryById(id);
        model.addAttribute("thicket",thicket);
//        model.addAttribute("name",thicket.getName());
//        model.addAttribute("price",thicket.getPrice());
        return "onethicket";
    }

}
