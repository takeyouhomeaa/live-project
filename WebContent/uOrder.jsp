<%--预约成功中签页面，包含购买凭证--%>
<%--
  Created by 麻继友 ECLIPSE
  Date: 2020/3/15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" 
		import="domain.Yes"%>
<html>
  <head>
     <link href="css/UOrderstyle.css" rel="stylesheet">
  </head>
  <body>
	<p id = "success">已中签！</p>
	<div id = "information">
		<table>
			<tr>
			<th>姓名</th>
			<th>身份证号码</th>
			<th>预约单号</th>
			</tr>
			<tr> 
			<%Yes user = (Yes)request.getAttribute("buy") ;%>
			<%--补充sevelet返回的预订信息 --%>
				<td><%=user.getName() %></td>
				<td><%=user.getId() %></td>
				<td><%=user.getOrderid() %></td>
			</tr>
		</table>
	</div>
	<a href = "preOrder.jsp">帮他人预约</a>
  </body>
</html>