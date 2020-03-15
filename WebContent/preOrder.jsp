<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="css/PreOrderstyle.css" rel="stylesheet">
  </head>
  <body>
  		<div id = "headerTitle">某口罩预约系统</div>
  		<div id = "formInformationSubmit">
  			<form method = "post" action = "preOrderServlet">
  				<label class = "lable">姓       名：</label>
  				<br />
  				<input type = "text" id = "username" name = "username" required/>
  				<br />
  				<label class = "lable">手机号码：</label>
  				<br />
  				<input type = "text" id = "userphone" name = "userphone" required/>
  				<br />
  				<label class = "lable">身  份  证：</label>
  				<br />
  				<input type = "text" id = "ID" name = "ID" required/>
  				<br />
  				<label class = "label">口罩数量：</label>
  				<br />
  				<input type="number" id = "masknumber" name = "masknumber" oninput="if(value > 3 || value < 0 ){alert('口罩数量不得小于0，最多只能预约3只口罩');value = ''}" required/>
  				<br />
  				<input type = "submit" value = "预约" id = "submit_btu" name = "submit_btu"/>
  			</form>
  		</div>
  </body>
</html>
