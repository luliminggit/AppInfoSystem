<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>APP开发者平台</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath }/statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath }/statics/css/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="https://colorlib.com/polygon/gentelella/css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath }/statics/css/custom.min.css" rel="stylesheet">
    <script src="/statics/js/jquery.min.js"></script>
    <script>
        function uNmae() {
            var name = $("#devname").val();
            if (name != "") {
                $("#sp1").text("ok").css("color", "green");
                return true;
            } else {
                $("#sp1").text("用户名不能为空").css("color", "red");
                return false;
            }
        }

        function upaws() {
            var pas = $("#devpassword").val()
            if (pas != "") {
                $("#sp2").text("ok").css("color", "green");
                return true;
            } else {
                $("#sp2").text("密码名不能为空").css("color", "red");
                return false;
            }
        }


    </script>
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form action="/login" method="post" onsubmit="return true">
                    <h1>APP开发者平台</h1>
                    <div>

                        <input type="text" class="form-control" id="devname" name="userNname" placeholder="请输入用户名"
                               required="" onblur="uNmae()"/>
                        <span id="sp1">11</span>
                    </div>
                    <div>

                        <input type="password" class="form-control" id="devpassword" name="userPassword"
                               placeholder="请输入密码" required="" onblur="upaws()"/>
                        <span id="sp2"></span>
                    </div>

                    <span style="color: red">${info }</span>
                    <div>
                        <button type="submit" class="btn btn-success">登 录</button>
                        <button type="reset" class="btn btn-default">重　填</button>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <div>
                            <p>©2016 All Rights Reserved. </p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>
</html>