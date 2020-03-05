package com.team.appinfo.controller.developer;

import com.github.pagehelper.PageInfo;
import com.team.appinfo.entity.*;
import com.team.appinfo.service.AppInfoService;
import com.team.appinfo.service.AppVersionService;
import com.team.appinfo.service.CateGoryService;
import com.team.appinfo.service.DataDictionaryService;
import com.team.appinfo.until.PageMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class AppInfoController {
    @Autowired
    private AppInfoService appInfoService;
    @Autowired
    private DataDictionaryService dataDictionaryService;
    @Autowired
    private AppVersionService appVersionService;
    @Autowired
    private CateGoryService cateGoryService;

    /**
     * 分页查询
     * @param pageMeter
     * @param model
     * @return
     */
    @RequestMapping(value = "/appinfolist")
    public String getAppInfo(PageMeter pageMeter, Model model,HttpSession session) {

        //给查询条件添加用户id
        //从session中取出登入人的用户id
        DevUser devUser=(DevUser)session.getAttribute("login");
        pageMeter.setDevid(devUser.getId());

        PageInfo<AppInfo> pageInfo = appInfoService.getAppInfo(pageMeter);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("pageMeter", pageMeter);
        return "jsp/developer/appinfolist";
    }

    /**
     * 跳转添加App页面
     * @param model
     * @return
     */
    @RequestMapping(value = "addappshow")
    public String showAppInfo(Model model) {
       /* List<DataDictionary> pingtai = dataDictionaryService.getPingtai();*/
      /*  model.addAttribute("pingtai", pingtai);*/
        return "jsp/developer/appinfoadd";
    }


    /**
     * 添加信息
     * @param appInfo
     * @return
     */
 @RequestMapping(value = "/appinfoaddsave")
  public String addAppInfo(AppInfo appInfo, @RequestParam(name = "a_logoPicPath",required = false)
         CommonsMultipartFile file, HttpServletRequest request, HttpSession session){
     try {
         //1.获取保存位置将相对路径转化绝对路径
         String path = request.getSession().getServletContext().getRealPath("upload/logo/");
         //2.设置保存文件
         String uploadFileName = file.getOriginalFilename();
         String expname = uploadFileName.substring(uploadFileName.lastIndexOf("."));
         //3.生成唯一的名称
         String fileName = System.currentTimeMillis() + expname;
         String saveName = path + "/" + fileName;
         //4.创建保存文件
         File saveFile = new File(saveName);
         //5.上传
         file.transferTo(saveFile);
         appInfo.setLogopicpath("upload/logo/" + fileName);

         //给实体添加用户id属性值
         DevUser devUser = (DevUser) session.getAttribute("login");
         appInfo.setDevid(devUser.getId());
         int i = appInfoService.AddAppinfo(appInfo);

         return "/jsp/developer/appinfoadd";
     }catch (Exception e){
         e.printStackTrace();
     }
     return "jsp/error";
  }

    /**
     * 修改回显
     * @param id
     * @param model
     * @return
     */
   @RequestMapping(value = "/getOneAppInfo")
    public String getoneappinfo(long id,Model model){
       AppInfo appInfo = appInfoService.getOneAppinfo(id);
       model.addAttribute("appInfo",appInfo);
     return "jsp/developer/appinfomodify";
   }


    /**
     * 修改app信息
     * @param appInfo
     * @param oldPicpath
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateappinfo")
    public String updateAppinfo(AppInfo appInfo,String oldPicpath, @RequestParam(name = "a_logoPicPath",required = false)
            CommonsMultipartFile file, HttpServletRequest request) {
        try {
            //判断图片是否有上传
            String fileName = file.getOriginalFilename();
            if (!fileName.equals("")) {
                //文件上传
                //1.获取保存位置将相对路径转化绝对路径
                String path = request.getSession().getServletContext().getRealPath("upload/logo/");
                //2.设置保存文件
                String uploadFileName = file.getOriginalFilename();
                String expname = uploadFileName.substring(uploadFileName.lastIndexOf("."));
                //3.生成唯一的名称
               String newfileName = System.currentTimeMillis() + expname;
                String saveName = path + "/" + newfileName;
                //4.创建保存文件
                File saveFile = new File(saveName);
                //5.上传
                file.transferTo(saveFile);
                //修改实体，添加图片的路径去数据库修改
                appInfo.setLogopicpath("upload/logo/"+newfileName);

                //删除原有图片
                File fdel=new File(request.getSession().getServletContext().getRealPath("/")+oldPicpath);
                fdel.delete();  //删除图片
                appInfoService.updateAppinfo(appInfo);
            }
        }catch (Exception e) {
            return "redirect:error.jsp";
            }
            return "redirect:appinfolist";
        }

    /**
     *  //查询单条app信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/appview")
    public String getAppinfo(Long id,Model model){
        AppInfo appInfo = appInfoService.getAppinfo1(id);
        List<AppVersion> appVersionList = appVersionService.getAppVersion(id);
        model.addAttribute("appVersionList",appVersionList);
        model.addAttribute("appInfo",appInfo);
        return "jsp/developer/appinfoview";
    }

    /**
     * 下架
     * @param appInfo
     * @return
     */
    @RequestMapping(value = "/soldOut")
    public String soldOut(AppInfo appInfo){
        int i = appInfoService.soldOut(appInfo);
        return "";
    }

    /**
     * 删除app信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteAppInfo")
    public String deleteAppInfo(Long id){
        try {
            int i = appInfoService.deleteAppInfo(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:appinfolist";
    }

    /**
     * 上架下架
     * @param appid
     * @param status
     * @return
     */
     @RequestMapping(value = "/App")
     @ResponseBody
     public String upDownApp(Long appid,Long status){
        int temp = appInfoService.updateAppInfoState(appid, status);
     System.out.println(temp);
        if(temp>0){
           return "{\"result\":\"1\"}";     //1表示成功
        }else{
            return "{\"result\":\"0\"}";    //2表示失败
        }

    }











}
