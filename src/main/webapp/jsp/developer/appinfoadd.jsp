<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>新增APP基础信息 <i class="fa fa-user"></i><small>${devUserSession.devName}</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content">
           <div class="clearfix"></div>
        <form class="form-horizontal form-label-left" enctype="multipart/form-data" action="/appinfoaddsave" method="post">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">软件名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="softwareName" name="softwarename" class="form-control col-md-7 col-xs-12"
               data-validate-length-range="20" data-validate-words="1"   required="required"
               placeholder="请输入软件名称" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APK名称 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="APKName" name="apkname" class="form-control col-md-7 col-xs-12"
              	data-validate-length-range="20" data-validate-words="1"  required="required"
              	placeholder="请输入APK名称" type="text">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">支持ROM <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="supportROM"  name="supportrom" class="form-control col-md-7 col-xs-12"
              	data-validate-length-range="20" data-validate-words="1"   required="required"
              	placeholder="请输入支持的ROM" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">界面语言 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="interfaceLanguage" name="interfacelanguage" class="form-control col-md-7 col-xs-12"
              data-validate-length-range="20" data-validate-words="1"   required="required"
              placeholder="请输入软件支持的界面语言" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">软件大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="softwareSize" name="softwaresize"   required="required" onkeyup="value=value.replace(/[^\d]/g,'')"
              data-validate-minmax="10,500"  placeholder="请输入软件大小，单位为Mb" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">下载次数 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="downloads" name="downloads"   required="required"
              data-validate-minmax="10,500"  placeholder="请输入下载次数" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="select">所属平台 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="flatformid" id="flatformid" class="form-control"   required="required">
                  <option value="">--请选择--</option>
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">一级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categorylevel1" id="queryCategoryLevel5" class="form-control"   required="required">
                <option value="">--请选择--</option>
              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="select">二级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categorylevel2" id="queryCategoryLevel6" class="form-control"  required="required">

              </select>
            </div>
          </div>
          
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="select">三级分类 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="categorylevel3" id="queryCategoryLevel7" class="form-control"  required="required">

              </select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">APP状态 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            	<input type="hidden" name="status" id="status" value="1">待审核
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">应用简介 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appInfo" name="appinfo"  required="required"
              placeholder="请输入本软件的相关信息，本信息作为软件的详细信息进行软件的介绍。" class="form-control col-md-7 col-xs-12"></textarea>
            </div>
          </div>
           <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">LOGO图片 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
            <input type="file" class="form-control col-md-7 col-xs-12" name="a_logoPicPath"  required="required" id="a_logoPicPath"/>
            ${fileUploadError }
            </div>
          </div>
          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button id="send" type="submit" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back">返回</button>
              <br/><br/>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<%--<script src="${pageContext.request.contextPath }/statics/localjs/appinfoadd.js"></script>--%>
<script>
</script>
<script language="JavaScript">
  //异步加载请求
  $(function () {
      //获取平台属性
      $.post("getFlatFrom",null,function (data) {
          for(var i=0;data.length;i++){
              var option="<option value="+data[i].valueid+">"+data[i].valuename+"</option>";
              $("#flatformid").append(option);
          }
      },"json")

        //发送异步请求加载一级分类
        $.post("getOneCategroy", null, function (data) {
            //获取数据动态添加到下拉列表
            for (var i = 0; i < data.length; i++) {
                var option = "<option value=" + data[i].id + ">" + data[i].categoryname + "</option>";
                $("#queryCategoryLevel5").append(option);
            }
        }, "json");
        //发送异步请求加载二级分类
        $("#queryCategoryLevel5").change(function () {
            $("#queryCategoryLevel6>option:gt(0)").remove();

            var tid = $("#queryCategoryLevel5").val();
            $.post("showCategoryLevel2", {"tid": tid}, function (data) {
                //获取数据动态添加到下拉列表

                for (var i = 0; i < data.length; i++) {
                    var option = "<option value=" + data[i].id + ">" + data[i].categoryname + "</option>";
                    $("#queryCategoryLevel6").append(option);
                }
            }, "json");

        })
        //发送异步请求加载二级分类
        $("#queryCategoryLevel6").change(function () {
            var tid = $("#queryCategoryLevel6").val();
            $.post("showCategoryLevel3", {"tid": tid}, function (data) {
                //获取数据动态添加到下拉列表

                for (var i = 0; i < data.length; i++) {
                    var option = "<option value=" + data[i].id + ">" + data[i].categoryname + "</option>";
                    $("#queryCategoryLevel7").append(option);
                }
            }, "json");

        })

    });

</script>