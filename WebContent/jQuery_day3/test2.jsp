<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>我是被加载的页面</title>
<!-- <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function (){
		$("#div1").load();
		

		});


</script> -->
</head>
<body>
	<h1>
		你好！！
	</h1>
	<!-- 接受test1中传入的参数 -->
	${param.name}
	${param.age}
</body>
</html>