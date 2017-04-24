<%@ page language="java" import="java.util.*,java.sql.*,com.db.OrderCount" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询讲座</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="CSS/queryLecture.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <header>
    	<label>
        <%=session.getAttribute("username") %>登录中
        </label>
        <a href="releaseLectureMessage.jsp" class="query">发布讲座</a>
        <a href="login.jsp" class="login_out">退出登录</a>
    </header>
    <div class="main">
    	<h1>欢迎来到查询展示页面</h1>
    	<div class="body_of_card">
    		<%!
    			int pageSize=4;
    			int pageCount;
    			int showPage;
    		 %>
    		 
    		 <%
    		 	Connection conn;
    		 	Statement stmt;
    		 	ResultSet rs;
    		 	try{
    		 		Class.forName("com.mysql.jdbc.Driver");
    		 	}catch(ClassNotFoundException e){
    		 	}
    		 	
    		 	try{
    		 		conn=DriverManager.getConnection("jdbc:mysql://123.206.191.48:3306/lecturemessage" , "root" , "root");
    		 		stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    		 		rs = stmt.executeQuery("SELECT * FROM lecture_message");
    		 		rs.last();
    		 		int recordCount = rs.getRow();
    		 		pageCount = (recordCount%pageSize==0)?(recordCount/pageSize):(recordCount/pageSize+1);
    		 		String integer = request.getParameter("showPage");
    		 		if(integer==null){
    		 			integer ="1";
    		 		}
    		 		try{
    		 			showPage=Integer.parseInt(integer);
    		 		}catch(Exception e){
    		 			showPage=1;
    		 		}
    		 		if(showPage <=1){
    		 			showPage =1;
    		 		}
    		 		if(showPage>=pageCount){
    		 			showPage = pageCount;
    		 		}
    		 		int position = (showPage -1)*pageSize+1;
    		 		rs.absolute(position);
    		 		for(int i=1 ; i<=4 ;i++){
    		  %>
    		  	<div class="card">
    		  		<h2 class="theme"><%=rs.getString("theme") %></h2>
    		  		<%
    		  			OrderCount OC = new OrderCount();
    		  			int count = OC.Count(rs.getInt("id"));
    		  		 %>
    		  		<h2 class="count">当前预约人数:<%=count %></h2>
    		  		<h2 class="author">发布者:<%=rs.getString("author") %></h2>
    		  		<h2 class="time">讲座时间:<%=rs.getString("start_date") %>&nbsp;&nbsp;<%=rs.getString("start_time") %></h2>
    		  		<p class="details">&nbsp;&nbsp;&nbsp;<%=rs.getString("details") %></p>
    		  		<a href="servlet/DeleteLectureServlet?id=<%=rs.getInt("id") %>" class="delete">删除</a>
    		  		<a href="#" class="change">修改</a>
    		  	</div>
    		  	
    		  <%
    		  	rs.next();
    		  	}
    		  	rs.close();
    		  	conn.close();
    		  	}catch(Exception e){
    		  		e.printStackTrace();
    		  	}
    		   %>
    	</div>
        <div>
            第<%=showPage %>页  (共<%=pageCount %>页)
                <a href="queryLecture.jsp?showPage=1">首页</a>
                <a href="queryLecture.jsp?showPage=<%=showPage-1 %>">上一页</a>
                <%
                    for(int i=1;i<=pageCount;i++){
                %>
                <a href="queryLecture.jsp?showPage=<%=i %>"><%=i%></a>
                <% }
                %>
                <a href="queryLecture.jsp?showPage=<%=showPage+1 %>">下一页</a>
                <a href="queryLecture.jsp?showPage=<%=pageCount %>">末页</a>
                <form action="" method="get">
                    跳转到第<input type="text" name="showPage" size="4">页
                    <input type="submit" name="submit" value="跳转">
                </form>
        </div>
    </div>
  </body>
</html>
