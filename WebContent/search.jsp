<%--查询是否中签页面，跳转searchServlet处理 --%>
<%--
  Created by 麻继友 ECLIPSE
  Date: 2020/3/15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
     <link href="css/Searchstyle.css" rel="stylesheet">
  </head>
  <body>
	<p id = "search">预约查询</p>
	<div id = "formforsearch">
	<%--补充用于查询的severlet --%>
		<form method = "post" action = "TODO">
		<label class = "label">请输入预约编号:</label>
		<br />
		<input id = "OrderId" type = "text" required />
		<input type = "submit" id = "searchbutton" value = "查询" />
		</form>
	</div>
	<a href = "preOrder.jsp">去参与预约</a>
  </body>
</html>
