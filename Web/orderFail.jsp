<%--预约失败页面 --%>
<%--
  Created by 麻继友 ECLIPSE
  Date: 2020/3/15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
     <link href="css/OrderFailstyle.css" rel="stylesheet">
  </head>
  <body>
	<p id = "sorry">预约失败</p>
	<div id = "reason">
	<span id = "reasonTitle">可能的失败原因</span>
	<br />
	<ul>
		<li>您已参加本次预约
		</li>
		<li>此前三次预约活动中，您有过中签记录
		</li>
	</ul>
	</div>
	<a href = "index.jsp">去查询中签记录</a>
  </body>
</html>
