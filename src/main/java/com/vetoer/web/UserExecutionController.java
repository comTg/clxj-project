package com.vetoer.web;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.vetoer.dto.AjaxResult;
import com.vetoer.dto.UserExecution;
import com.vetoer.entity.User;
import com.vetoer.entity.Validation;
import com.vetoer.service.UserExecutionService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;

@Component
@RequestMapping("/clxj") //url:模块/资源/{}/细分
public class UserExecutionController {
    @Autowired
    private UserExecutionService userExecutionService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        // 获取登录页面
        if (model.containsAttribute("user")) {
            System.out.println("用户已登录");
            return "index";
        } else {
            return "login";
        }

    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String form_to_login(User user, Model model) {
        UserExecution loginExecution = userExecutionService.loginUser(user.getPhone(), user.getPassword());
        if (loginExecution.getState() == 1) {
            System.out.println("登录成功!");
            model.addAttribute("user", loginExecution.getUser());
            model.addAttribute("tips", "登录成功");
            model.addAttribute("url", "/clxj/index");
            return "executionSuccess";
        } else {
            System.out.println("登录失败");
            model.addAttribute("error", loginExecution.getStateInfo());
            return "login";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        //获取注册页面
        return "register";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String form_to_register(User user, Model model) {
        user.setRegisterTime(new Date());
        UserExecution registerExecution = userExecutionService.registerUser(user);
        if (registerExecution.getState() == 1) {
            System.out.println("注册成功");
            model.addAttribute("user", registerExecution.getUser());
            model.addAttribute("tips", "注册成功");
            model.addAttribute("url", "/clxj/login");
            return "executionSuccess";
        } else {
            model.addAttribute("error", registerExecution.getStateInfo());
            return "register";
        }
    }

    /**
     * ajax判断手机号码是否已经注册
     */
    @RequestMapping(value = "/{Phone}/judge",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public AjaxResult<UserExecution> judgePhone(@PathVariable("Phone") String phone) {
        UserExecution userExecution = userExecutionService.queryByPhone(phone);
        if (userExecution.getState() == 0) {
            System.out.println("手机号码不存在");
            return new AjaxResult<UserExecution>(false, "手机号码未注册");
        } else {
            return new AjaxResult<UserExecution>(true, "手机号码存在");
        }
    }

    /**
     * ajax判断是否登录成功
     */
    @RequestMapping()
    @ResponseBody
    public AjaxResult<UserExecution> judgeLogin() {
        return null;
    }

    /**
     * 忘记密码页面
     */
    @RequestMapping(value = "/forgetpasswd",method = RequestMethod.GET)
    public String validaPhone(Model model){
        return "forgetpassword";
    }

    /**
     * 得到验证码
     * @param session
     * @param phone
     * @return
     */
    @RequestMapping(value = "/{Phone}/getcode",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public AjaxResult<UserExecution> validaPhone(HttpSession session, @PathVariable("Phone") String phone) {
        if(phone!=null && userExecutionService.queryByPhone(phone).getState()==2){
            String code = RandomStringUtils.randomAlphanumeric(4);
            String valida_phone = phone + "code";
            session.setAttribute(valida_phone, code);
            System.out.println("验证手机:"+phone+"\n验证码:"+code);
            return new AjaxResult<UserExecution>(true,"验证码已发送");
        }else{
            return new AjaxResult<UserExecution>(false,"手机号不存在");
        }
    }
    @RequestMapping(value = "/alterPasswd",method = RequestMethod.POST)
    //@RequestParam("phone") String phone, @RequestParam("validatecode") String validatecode
    public String validacode(Validation validation,HttpServletRequest request,
                             HttpServletResponse response){
        HttpSession session = request.getSession();
        String phone = validation.getPhone();
        String validatecode = validation.getValidatecode();
        System.out.println(validation+"/////////");
        String valida_phone = phone+"code";
        if(session.getAttribute(valida_phone)!=null){
            String systemcode = session.getAttribute(valida_phone).toString().toLowerCase();
            String usercode = validatecode.toLowerCase();
            if(usercode.equals(systemcode)) {
                // 验证码输入正确
                System.out.println("验证码输入正确");
                request.setAttribute("phone",phone);
                return "executionSuccess";
            }else{
                // 验证码输入错误,跳回前一个页面
                System.out.println("验证码输入错误");
                return "forgetpassword";
            }
        }else{
            return "login";
        }
    }
    /**
     * 显示首页,在首页内容中显示丛林和闲居的信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {

        return "index";
    }
}
