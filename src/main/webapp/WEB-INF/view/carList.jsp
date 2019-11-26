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
    <title></title>
</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach items="${carList}" var="car">
            <div class="col-md-3">
                <img alt="" width="50px" height="50px" src="/pic/${car.picUrl}">
                <br>
                名称：${car.name}
                品牌：${car.trademark}
                驾驶证：${car.carType}
                图片：${car.picUrl}
            </div>
        </c:forEach>

    </div>
</div>

</body>
</html>