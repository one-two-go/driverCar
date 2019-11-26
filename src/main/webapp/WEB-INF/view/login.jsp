<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
    <title>登录</title>
</head>
<body>
<!-- id	主键
name	司机姓名
phone	手机
password	密码
driver_license	驾驶证号
drive_type	驾驶证等级
issued	发证日期
created	注册时间 -->
<div class="container">
    ${error}
    <form:form action="/login" modelAttribute="driver" method="post">
        姓名：<form:input path="name"/><form:errors path="name"></form:errors><br/>

        密码：<form:input path="password"/><form:errors path="password"></form:errors><br/>

        <form:button>登录</form:button>

    </form:form>

        <input type="button" href="register" value="注册" >

</div>
</body>
</html>