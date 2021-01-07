<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="demo6" method="post"/>
	<!-- <input type="text" name="name"/>
	<input type="text" name="age"/>
	
	<input type="checkbox" name="hover" value="写代码"/>
	<input type="checkbox" name="hover" value="看视频"/> -->
	<input type="text" name="peo[0].name" value=""/>
	<input type="text" name="peo[0].age" value=""/>
	<input type="text" name="peo[1].name" value=""/>
	<input type="text" name="peo[1].age" value=""/>
	<input type="submit" value="提交"/>
	<a href="demo7?id=123&name=abc">demo7</a>
	<a href="demo8/123/abc">demo8</a>

</form>
<!-- springmvc是spring的子容器，spring配置后是基于请求深度来访问静态资源的，因此要注意好访问资源的路径 -->
 <a href="download?fileName=aa.txt">下载</a>
${demo123 }
</body>
</html>