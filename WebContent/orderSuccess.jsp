<%--预约成功页面--%>
<%--
  Created by 麻继友 ECLIPSE
  Date: 2020/3/15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
     <link href="css/OrderSuccessstyle.css" rel="stylesheet">
  </head>
  <body>
	<p id = "success">预约成功！</p>
	<div id = "information">
		<table>
			<tr>
			<th>姓名</th>
			<th>身份证号码</th>
			<th>手机号码</th>
			<th>预约单号</th>
			</tr>
			<tr> 
			<%--补充sevelet返回的预订信息 --%>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
	<a href = "preOrder.jsp">帮他人预约</a>
  </body>
</html>
