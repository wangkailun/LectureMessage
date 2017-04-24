<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发布讲座信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/releaseLectureMessage.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	<header>
   	  <label>
   	  <%=session.getAttribute("username") %>登录中
   	  </label>
      <a href="queryLecture.jsp" class="query">查询讲座</a>
      <a href="login.jsp" class="login_out">退出登录</a>
   	</header>
   	<div>
   		<h1>东华大学讲座发布系统</h1>
   		<form action="servlet/ReleaseLectureServlet" method="post">
   			<input type="text" name="theme" placeholder="主题"  class="theme"><br>
   			<input type="text" name="author" placeholder="发布者" class="author"><br>
   			<input type="date" name="date" class="date">
   			<input type="time" name="time" class="time"><br>
   			<textarea class="details" name="details" cols="30" rows="50">详细内容...</textarea>
   			<input type="reset" class="reset" value="重置">
   			<input type="submit" value="发布" align="right" class="sub">
   		</form>
   	</div>
  </body>
</html>
