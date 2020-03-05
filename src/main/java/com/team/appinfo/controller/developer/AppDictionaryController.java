package com.team.appinfo.controller.developer;


import com.team.appinfo.entity.DataDictionary;
import com.team.appinfo.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AppDictionaryController {
   @Autowired
    private DataDictionaryService dataDictionaryService;

    /**
     * app状态
     * @return
     */
   @RequestMapping(value = "/getStatus")
   @ResponseBody  //注解返回json数据
   public List<DataDictionary> getStatus(){
       List<DataDictionary> list = dataDictionaryService.getStatus();
       return list;
   }

    /**
     * app平台
     * @return
     */
    @RequestMapping(value = "/getFlatFrom")
    @ResponseBody
    public List<DataDictionary> getFlatFrom(){
        List<DataDictionary> list = dataDictionaryService.getFlatFrom();
        return list;
    }




}
