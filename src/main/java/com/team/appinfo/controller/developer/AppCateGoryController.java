package com.team.appinfo.controller.developer;

import com.team.appinfo.entity.AppCategory;
import com.team.appinfo.service.CateGoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AppCateGoryController {
    @Autowired
    private CateGoryService cateGoryService;

    /**
     * 获取一级类别
     * @return
     */
    @RequestMapping("/getOneCategroy")
    @ResponseBody
    public List<AppCategory> showOneCategroy() {
        //调用业务
        List<AppCategory> list = cateGoryService.getCategoryBeloginType(null);
        //将list转化为json响应给客户端
        return list;
    }

    /**
     * 获取二级类别
     * @param tid
     * @return
     */
    @RequestMapping("/showCategoryLevel2")
    @ResponseBody
    public List<AppCategory> showCategoryLevel2(@RequestParam("tid") Long tid) {
        return cateGoryService.getCategory2(tid);

    }

    /**
     * 获取三级类别
     * @param tid
     * @return
     */
    @RequestMapping("/showCategoryLevel3")
    @ResponseBody
    public List<AppCategory> showCategoryLevel3(@RequestParam("tid") Long tid) {
        return cateGoryService.getCategory3(tid);

    }


}
