package com.team.appinfo.controller.backend;


import com.github.pagehelper.PageInfo;
import com.team.appinfo.entity.AppInfo;
import com.team.appinfo.entity.AppVersion;
import com.team.appinfo.entity.DataDictionary;
import com.team.appinfo.service.AppInfoService;
import com.team.appinfo.service.AppVersionService;
import com.team.appinfo.service.CateGoryService;
import com.team.appinfo.service.DataDictionaryService;
import com.team.appinfo.until.PageMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppListController {
    @Autowired
    private AppVersionService appVersionService;

    @Autowired
    private AppInfoService appInfoService;
    @Autowired
    private DataDictionaryService dataDictionaryService;

    @Autowired
    private CateGoryService cateGoryService;


    /**
     * 查询待审核app信息
     * @param pageMeter
     * @param model
     * @return
     */
    @RequestMapping(value = "/applist")
    public String getAppInfo(PageMeter pageMeter, Model model) {
        PageInfo<AppInfo> noPassAppinfo = appInfoService.getNoPassAppinfo(pageMeter);
        model.addAttribute("noPassAppinfo",noPassAppinfo);
        //还原表单（查询数据回显）
        model.addAttribute("pageMeter",pageMeter);
        return "jsp/backend/applist";
    }


    /**
     * 查看单条未审核app信息
     * @param aid
     * @param model
     * @param
     * @return
     */
    @RequestMapping(value = "/check")
    public String checkApp(Long aid,Model model){
            AppInfo appInfo = appInfoService.getAppinfo1(aid);
            AppVersion oneAppVersion = appVersionService.newsAppVersion(aid);
            model.addAttribute("appInfo",appInfo);
            model.addAttribute("oneAppVersion",oneAppVersion);


        return "jsp/backend/appcheck";
    }

    /**
     * 修改App状态  审核通过 审核不通过
     * @param appid
     * @param status
     * @return
     */
    @RequestMapping(value = "/checksave")
    public String check(Long appid,Long status){
        int temp = appInfoService.updateAppInfoState(appid, status);
        if(temp>0){
            return "redirect:applist";
        }else{
            return "redirect:jsp/error.jsp";
        }
    }
}
