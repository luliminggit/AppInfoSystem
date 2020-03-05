<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="common/header.jsp" %>
<script language="JavaScript">
    function go(page) {
        //给表单设置页码
        document.getElementById("setPage").value = page;
        //提交表单
        document.getElementById("form1").submit();
    }
</script>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>
                    APP 信息管理维护 <i class="fa fa-user"></i>
                    <small>${devUserSession.devName}
                        - 您可以通过搜索或者其他的筛选项对APP的信息进行修改、删除等管理操作。^_^
                    </small>
                </h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form method="post" id="form1" action="/appinfolist">
                    <input type="hidden" name="page" id="setPage" value="1">
                    <ul>
                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input name="querySoftwareName" type="text" class="form-control col-md-7 col-xs-12"
                                           value="${pageMeter.querySoftwareName }">
                                </div>
                            </div>
                        </li>

                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <select name="queryStatus" id="queryStatus" class="form-control">
                                        <%--<c:if test="${tyname != null }">--%>
                                            <option value="">--请选择--</option>
                                           <%-- <c:forEach var="dataDictionary" items="${tyname}">
                                                <option
                                                        <c:if test="${dataDictionary.valueid == pageMeter.queryStatus }">selected="selected"</c:if>
                                                        value="${dataDictionary.valueid}">${dataDictionary.valuename}</option>
                                            </c:forEach>--%>
                                       <%-- </c:if>--%>
                                    </select>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <select name="queryFlatformId" id="queryFlatformId" class="form-control">
                                      <%--  <c:if test="${pingtai != null }">--%>
                                            <option value="">--请选择--</option>
                                          <%--  <c:forEach var="dataDictionary" items="${pingtai}">
                                                <option
                                                        <c:if test="${dataDictionary.valueid == pageMeter.queryFlatformId}">selected="selected"</c:if>
                                                        value="${dataDictionary.valueid}">${dataDictionary.valuename}</option>
                                            </c:forEach>--%>
                                      <%--  </c:if>--%>
                                    </select>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">

                                    <select id="queryCategoryLevel5" name="queryCategoryLevel5" class="form-control">
                                        <option value="">--请选择--</option>

                                    </select>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="hidden" name="categorylevel2list" id="categorylevel2list"/>
                                    <select name="queryCategoryLevel6" id="queryCategoryLevel6" class="form-control">
                                        <option value="">--请选择--</option>
                                       <%-- <c:if test="${categoryList2!=null}">
                                            <c:forEach items="${categoryList2}" var="category2">
                                                <option <c:if test="${category2.id==pageMeter.queryCategoryLevel6}"> selected="selected"</c:if>
                                                        value="${category2.id}" >${category2.categoryname}</option>
                                            </c:forEach>

                                        </c:if>--%>
                                    </select>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <select name="queryCategoryLevel7" id="queryCategoryLevel7" class="form-control">
                                    <option value="">--请选择--</option>
                                        <%--<c:if test="${categoryList3!=null}">
                                            <c:forEach items="${categoryList3}" var="category3">
                                                <option <c:if test="${category3.id==pageMeter.queryCategoryLevel7}"> selected </c:if> value="${category3.id}" >${category3.categoryname}</option>
                                            </c:forEach>

                                        </c:if>--%>
                                    </select>
                                </div>
                            </div>
                        </li>
                        <li>
                            <button type="submit" class="btn btn-primary"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询</button>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_content">
                <p class="text-muted font-13 m-b-30"></p>
                <div id="datatable-responsive_wrapper"
                     class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                    <div class="row">
                        <div class="col-sm-12">
                            <a href="addappshow" class="btn btn-success btn-sm">新增APP基础信息</a>
                            <table id="datatable-responsive"
                                   class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
                                   cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info"
                                   style="width: 100%;">
                                <thead>
                                <tr role="row">
                                    <th class="sorting_asc" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="First name: activate to sort column descending"
                                        aria-sort="ascending">软件名称
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        APK名称
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        软件大小(单位:M)
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        所属平台
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        所属分类(一级分类、二级分类、三级分类)
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        状态
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        下载次数
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        最新版本号
                                    </th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        style="width: 124px;"
                                        aria-label="Last name: activate to sort column ascending">
                                        操作
                                    </th>
                                </tr>

                                </thead>
                                <tbody>
                                <c:forEach var="appInfo" items="${pageInfo.list }" varStatus="status">
                                    <tr role="row" class="odd">
                                        <td tabindex="0" class="sorting_1">${appInfo.softwarename}</td>
                                        <td>${appInfo.apkname }</td>
                                        <td>${appInfo.softwaresize }</td>
                                        <td>${appInfo.flatfromname }</td>
                                        <td>${appInfo.cname1 } -> ${appInfo.cname2 }
                                            -> ${appInfo.cname3 }</td>
                                        <td><span id="appInfoStatus${appInfo.id}">${appInfo.statusname }</span></td>
                                        <td>${appInfo.downloads }</td>
                                        <td>${appInfo.versionno }</td>
                                        <td>
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-danger">点击操作</button>
                                                <button type="button" class="btn btn-danger dropdown-toggle"
                                                        data-toggle="dropdown" aria-expanded="false">
                                                    <span class="caret"></span>
                                                    <span class="sr-only">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu" role="menu">
                                                <%--    <li>
                                                        <c:choose>
                                                            <c:when test="${appInfo.status == 2 || appInfo.status == 5}">
                                                                <a class="saleSwichOpen" saleSwitch="open"
                                                                   appinfoid=${appInfo.id }  appsoftwarename=${appInfo.softwarename }
                                                                   data-toggle="tooltip" data-placement="top" title=""
                                                                   data-original-title="恭喜您，您的审核已经通过，您可以点击上架发布您的APP">上架</a>
                                                            </c:when>
                                                            <c:when test="${appInfo.status == 4}">
                                                                <a class="saleSwichClose" saleSwitch="close"
                                                                   appinfoid=${appInfo.id }  appsoftwarename=${appInfo.softwarename }
                                                                   data-toggle="tooltip" data-placement="top" title=""
                                                                   data-original-title="您可以点击下架来停止发布您的APP，市场将不提供APP的下载">下架</a>
                                                            </c:when>
                                                        </c:choose>
                                                    </li>--%>
                                                    <c:if test="${appInfo.status==2 || appInfo.status==5}">
                                                        <li><a  name="upJia" appid="${appInfo.id}"
                                                                 data-toggjle="tooltip" data-placement="top" title="">上架</a></li>
                                                    </c:if>

                                                    <c:if test="${appInfo.status==4}">
                                                        <li><a name="upJia" appid="${appInfo.id}"
                                                               data-toggle="tooltip" data-placement="top" title="">下架</a></li>
                                                    </c:if>

                                                    <li><a href="/appversionadd?appid=${appInfo.id}" class="addVersion" <%--appinfoid="${appInfo.id }--%>
                                                           data-toggle="tooltip" data-placement="top" title=""
                                                           modifyVersiondata-original-title="新增APP版本信息">新增版本</a>
                                                    </li>
                                                    <li><a  class="modifyVersion"
                                                           appinfoid="${appInfo.id}" versionid="${appInfo.versionid }"

                                                           status="${appInfo.status }"
                                                           statusname="${appInfo.statusname }"
                                                           data-toggle="tooltip" data-placement="top" title=""
                                                           data-original-title="修改APP最新版本信息">修改版本</a>
                                                    </li>
                                                    <li><a class="modifyAppInfo"
                                                           appinfoid="${appInfo.id }" status="${appInfo.status }"
                                                           statusname="${appInfo.statusname }"
                                                           data-toggle="tooltip" data-placement="top" title=""
                                                           data-original-title="修改APP基础信息">修改</a></li>
                                                    <li><a href="/appview?id=${appInfo.id }" data-toggle="tooltip"
                                                           data-placement="top" title=""
                                                           data-original-title="查看APP基础信息以及全部版本信息">查看</a></li>
                                                    <li><a <%--class="deleteApp"
                                                           appinfoid=${appInfo.id }  appsoftwarename=${appInfo.softwarename }--%>
                                                            href="/deleteAppInfo?id=${appInfo.id}"
                                                           data-toggle="tooltip" data-placement="top" title=""
                                                           data-original-title="删除APP基础信息以及全部版本信息">删除</a></li>
                                                </ul>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-5">
                            <div class="dataTables_info" id="datatable-responsive_info"
                                 role="status" aria-live="polite">共${pageInfo.total }条记录
                                ${pageInfo.pageNum }/${pageInfo.pages }页
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <div class="dataTables_paginate paging_simple_numbers"
                                 id="datatable-responsive_paginate">
                                <div>
                               <a href="javascript:go(1)">首页</a>
                               <a href="javascript:go(${pageInfo.prePage==0?1:pageInfo.prePage})">上一页</a>
                              <a href="javascript:go(${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage})">下一页</a>
                             <a href="javascript:go(${pageInfo.pages})">尾页</a>
                             </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        ZHIZAOYAOGEIISHUDIOE DONXGEINISH
    </div>
</div>
<%@include file="common/footer.jsp" %>
<%--<script src="${pageContext.request.contextPath }/statics/localjs/rollpage.js"></script>--%>
<script src="${pageContext.request.contextPath }/statics/localjs/appinfolist.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script language="JavaScript" type="text/javascript">

    //加载事件
    $(function () {
         //加载app状态
        //$.post("服务器地址",传给服务器的参数,回调函数,"json");
        $.post("getStatus",null,function (data) {
            //data表示返回的数据
            //动态option
            for(var i=0;i<data.length;i++){
                var option="<option value="+data[i].valueid+">"+data[i].valuename+"<option>";
                $("#queryStatus").append(option);
            }
            //回显
            $("#queryStatus").val(${pageMeter.queryStatus})
        }, "json")

        //加载App平台
        $.post("getFlatFrom",null,function (data) {
            for (var i=0;i<data.length;i++){
                var option="<option value="+data[i].valueid+">"+data[i].valuename+"<option>";
                $("#queryFlatformId").append(option);
            }
            //回显
            $("#queryFlatformId").val(${pageMeter.queryFlatformId})
        }, "json")

        //发送异步请求加载一级分类
     $.post("getOneCategroy", null, function (data) {
            //获取数据动态添加到下拉列表
            for (var i = 0; i < data.length; i++) {
                var option = "<option value=" + data[i].id+ ">" + data[i].categoryname + "</option>";
                $("#queryCategoryLevel5").append(option);
            }
            // //设置选中项回显
            $("#queryCategoryLevel5").val(${pageMeter.queryCategoryLevel5});
            //加载二级分类
           Level2();
        }, "json");

        //当一级分类选项发生改变时加载二级分类
        //加载二级分类:
        function Level2() {
            $("#queryCategoryLevel6>option:gt(0)").remove(); //清空现有的分类
            //获取当前下拉列表中选中项的值
            var tid = $("#queryCategoryLevel5").val()
            if(tid!=""){
            $.post("showCategoryLevel2", {"tid": tid}, function (data) {
                //获取数据动态添加到下拉列表
                for (var i = 0; i < data.length; i++) {
                    var option = "<option value=" + data[i].id + ">" + data[i].categoryname + "</option>";
                    $("#queryCategoryLevel6").append(option);
                }
                //设置选中项
                $("#queryCategoryLevel6").val(${pageMeter.queryCategoryLevel6})
                //加载三级分类
                Level3();

               }, "json");
            }
        }
        //耳机联动效果
        $("#queryCategoryLevel5").change(Level2);


        //当二级分类选项发生改变时加载三级分类
        //加载三级分类
       function Level3() {
            $("#queryCategoryLevel7>option:gt(0)").remove();//清空现有的分类
            var tid = $("#queryCategoryLevel6").val();
            if(tid!=""){
            $.post("showCategoryLevel3", {"tid": tid}, function (data) {
                //获取数据动态添加到下拉列表
                for (var i = 0; i < data.length; i++) {
                    var option = "<option value=" + data[i].id + ">" + data[i].categoryname + "</option>";
                    $("#queryCategoryLevel7").append(option);
                }
            }, "json");

                //设置选中项
                $("queryCategoryLevel7").val(${pageMeter.queryCategoryLevel7})
            }
        }

        //联动效果
        $("#queryCategoryLevel6").change(Level3)


    });

    //实现上架的异步请求
    $(function(){  //加载
        //上架下架
        $("a[name='upJia']").click(function () {
            //获取app的id
            var appid=$(this).attr("appid");
            //显示状态单元格 首先将a标签所在的单元格添加一个name属性 name="curtd"
            var node=$(this).parents("[name='curtd']").prev().prev().prev();
            //上下架的a标签
            var anode=$(this);
            //发送一步请求上架
            if(anode.html()=="上架"){
                //异步请求
                $.post("${pageContext.request.contextPath}/App",{"appid":appid,"status":4},function (data) {
                    if(data.result==1){
                        node.html("已上架")
                        anode.html("下架")
                    }else{
                        alert("上架失败");
                    }

                },"json");
            }else{
                $.post("${pageContext.request.contextPath}/App",{"appid":appid,"status":5},function (data) {
                    if(data.result==1){
                        node.html("已下架")
                        anode.html("上架")
                    }else {
                        alert("下载失败")
                    }
                },"json");
            }
        });
    });

</script>

