<<<<<<< HEAD
=======
<%--主页负责显示主界面，跳转mainServlet处理 --%>
<%--
  Created by IntelliJ IDEA.
  User: 18030
  Date: 2020/3/15
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>123</title>
  </head>
  <body>
  <form action="OrderServlet" autocomplete="on">
  姓名:<input type="text" name="name" placeholder="请输入真实姓名" required><br>
  身份证号: <input type="text" name="ID" required><br>
  手机号: <input type="text" name="phone" autocomplete="on" required><br>
  想要预约的口罩数量<input type="number" name="number" required><br>
  <input type="submit" value="预约">
</form>
<form action="StartServlet">
<input type="submit" value="预约开始">
</form>
<form action="EndServlet">
<input type="submit" value="预约结束">
</form>
  </body>
</html>
