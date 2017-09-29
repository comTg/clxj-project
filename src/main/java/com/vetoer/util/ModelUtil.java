package com.vetoer.util;

import com.vetoer.entity.PageCode;
import com.vetoer.service.ThicketExecutionService;
import com.vetoer.service.impl.ThicketExecutionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工具类
 */
/*

 */
public class ModelUtil {
    // 只有 state=true时,写入cookie
    public static Model alterModel(Model model,String phone,String tips,String url,boolean state){
        model.addAttribute("phone",phone);
        model.addAttribute("tips",tips);
        model.addAttribute("url",url);
        model.addAttribute("state",state);
        return model;
    }
    // 分页操作util
    public static Map<String,Object> getPageCode(Model model,String addressType,int page,int countThicket){
        String resultType=null;
        if("cl".equals(addressType)) {
            resultType="丛林";
        }else if("xj".equals(addressType)){
            resultType="闲居";
        }
        List<PageCode> pageCodes = new ArrayList<>();
        for(int i =2;i<=(countThicket/9+1);i++){
            PageCode pageCode = new PageCode(i,null);
            if(page==i){
                pageCode.setClassType("active");
            }
            pageCodes.add(pageCode);
        }
        Map<String,Object> maps = new HashMap<>();
        maps.put("model",model);
        maps.put("resultType",resultType);
        maps.put("pageCode_list",pageCodes);
        return maps;
    }
}
