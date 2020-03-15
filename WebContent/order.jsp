<%--主页负责显示主界面，跳转mainServlet处理 --%>
<%--
  Created by 麻继友 ECLIPSE
  Date: 2020/3/15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
  	<link href="css/Indexstyle.css" rel="stylesheet">
    <title>123</title>
  </head>
  <body>
  <div id = "headerTitle">
  <h1>口罩预约系统</h1>
  </div>
  <%--填写处理预约表单的severlet --%>
  <form method = "post" action="OrderServlet">
  	<label class = "label">姓      名：</label>
  	<br />
	<input type="text" name="name" id = "name" required>
	<br />
	<label class = "label">身份证号：</label>
	<br />
    <input type="text" name="ID" id = "ID" required>
    <br />
    <label class = "label">手机号码：</label>
    <br />
	<input type="text" name="phone" required><br>
	<br />
	<label class = "label">口罩数量</label>
  	<input type="number" name="number" id = "number" oninput="if(value > 3 || value < 0 ){alert('口罩数量应大于0，且最多只能预约3只口罩');value = ''}" required>
  	<br />
    <input type="submit" value="预约">

      <a href="EndServlet">结束预约</a>

      <form method="post" action="MaskSumServlet">
          <input type="text" name="maskSum">
          <input type="submit" value="口罩个数">
      </form>
</form>
  </body>
</html>
