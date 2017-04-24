<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/register.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <section class="container">
    <div class="login">
      <h1>用户登录</h1>
      <form method="post" action="servlet/LoginServlet">
        <p><input type="text" name="username" placeholder="用户名"></p>
        <p><input type="password" name="password" value="" placeholder="密码"></p>
        <p class="submit"><input type="button" onclick="location='register.jsp'" value="注册"><input type="submit" name="commit" value="登录"></p>
      </form>
    </div>
  </section>
  </body>
</html>
