package com.team.appinfo.controller.user;

import com.github.pagehelper.PageInfo;
import com.team.appinfo.entity.DevUser;
import com.team.appinfo.service.DevUserService;
import com.team.appinfo.until.PageMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.awt.ModalExclude;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DevUserController {

    @Autowired
    private DevUserService devUserService;

    //登录
@RequestMapping(value = "/login")
    public String login(String userNname,String userPassword,Model model,HttpSession session){
    DevUser devUser = devUserService.getUser(userNname, userPassword);
    if(devUser==null){
        model.addAttribute("info","用户名密码不正确");
        return "jsp/devlogin";
    }else{
        session.setAttribute("login",devUser);
        session.setMaxInactiveInterval(10*60);//session的活动时间为10分钟
        return "jsp/developer/main";
    }

    }


    //退出
    @RequestMapping("/dev/logout")
    public String loginAction(HttpSession session){
        //清空session   把登入的人清空
        session.removeAttribute("login");
        return "jsp/devlogin";    //返回登入页
    }

}
