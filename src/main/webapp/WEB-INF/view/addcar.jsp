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
 <title>注册</title>
</head>
<body>
<!-- 
id	主键	int	否	唯一主键，自增长
name	车辆名称	varchar(30)	否	
trademark	品牌	int	否	页面上按这个字段升序显示
rent	日租金	decimal	否	唯一主键，自增长
car_type	最低准驾车型	varchar(2)	否	对应准驾车型表的code值
pic_url	图片	varchar(100)	否	
created	发布时间	datetime	否	


 -->
	<div class="container">
		<form:form action="" modelAttribute="car" method="post" enctype="multipart/form-data">
			姓名：<form:input path="name"/><form:errors path="name"></form:errors><br/>
			品牌：<form:input path="trademark"/><form:errors path="trademark"></form:errors><br/>
			租金：<form:input path="rent"/><form:errors path="rent"></form:errors><br/>
			<%--car_type <form:input path="driverLicense"/><br/> --%>
			驾驶证类型 <form:select path="carType">
				<form:options items="${typeList}"  itemValue="code" itemLabel="name"/>
			</form:select>
			图片：<input name="file" type="file"><br/>
			
			<form:button>提交</form:button><br/>
		</form:form>
		
		
	</div>
</body>
</html>