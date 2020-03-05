package com.team.appinfo.controller.developer;

import com.team.appinfo.entity.AppInfo;
import com.team.appinfo.entity.AppVersion;
import com.team.appinfo.service.AppInfoService;
import com.team.appinfo.service.AppVersionService;
import com.team.appinfo.until.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class AppVersionController {
    @Autowired
    private AppVersionService appVersionService;
    @Autowired
    private AppInfoService appInfoService;

    /**
     * 查询历史版本号
     *
     * @param model
     * @param appid
     * @return
     */
    @RequestMapping(value = "/appversionadd")
    public String showAppVersion(Model model, Long appid) {
        List<AppVersion> appVersionList = appVersionService.getAppVersion(appid);
        model.addAttribute("appVersionList", appVersionList);
        model.addAttribute("appid", appid);
        return "jsp/developer/appversionadd";
    }

    /**
     * 新增版本信息
     *
     * @param appVersion
     * @return
     */
    @RequestMapping(value = "/addAppVersion")
    public String addAppversion(AppVersion appVersion,
                                @RequestParam(name = "a_downloadLink", required = false) CommonsMultipartFile file,
                                HttpServletRequest request
    ) {

        try {
            //1.上传app文件  app文件保存到项目的upload/apk目录中
            //设置保存文件的位置
            String path = request.getSession().getServletContext().getRealPath("upload/apk");
            String fileName = FileUploadUtil.upload(file, path);  //上传
            //2.将信息保存到数据库
            //设置实体的apk文件名称
            appVersion.setApkfilename(file.getOriginalFilename());
            //设置实体的apk文件的相对路径
            appVersion.setDownloadlink("upload/apk/" + fileName);
            //重点: 设置版本对应的app信息ID   表示版本属于某个app
            //利用表单的隐藏域传递appid到实体
            appVersionService.addAppVersion(appVersion);
            System.out.println(appVersion.getAppid());
            //跳转到继续添加页
            return "redirect:addAppVersion?appid=" + appVersion.getAppid();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:jsp/error.jsp";
    }

    /**
     * 修改回显
     * 查询历史版本列表
     *
     * @param model
     * @param id
     * @param versionId
     * @return
     */
    @RequestMapping(value = "/appversionmodify")
    public String showAppVersion1(Model model, Long id, Long versionId) {
        List<AppVersion> appVersionList = appVersionService.getAppVersion(id);
        AppVersion oneAppVersion = appVersionService.getOneAppVersion(versionId);
        model.addAttribute("oneAppVersion", oneAppVersion);
        model.addAttribute("appVersionList", appVersionList);

        return "jsp/developer/appversionmodify";

    }

    /**
     * 修改最新版本信息
     *
     * @param appVersion
     * @param
     * @return
     */
    @RequestMapping(value = "/appversionmodifysave")
    public String updateAppVersion(AppVersion appVersion,
                                   @RequestParam(name = "a_logoPicPath", required = false) CommonsMultipartFile file,
                                   HttpServletRequest request) {
        try {
            //1.上传app文件  app文件保存到项目的upload/apk目录中
            //设置保存文件的位置
            String path = request.getSession().getServletContext().getRealPath("upload/apk");
            String fileName = FileUploadUtil.upload(file, path);  //上传
            //2.将信息保存到数据库
            //设置实体的apk文件名称
            appVersion.setApkfilename(file.getOriginalFilename());
            //设置实体的apk文件的相对路径
            appVersion.setDownloadlink("upload/apk/" + fileName);
            //重点: 设置版本对应的app信息ID   表示版本属于某个app
            //利用表单的隐藏域传递appid到实体
            appVersionService.updateAppVersion(appVersion);
            //跳转到继续添加页
            return "redirect:appinfolist";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:jsp/error.jsp";
    }
}


