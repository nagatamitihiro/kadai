<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function onclickBtnKadai61() {
	document.kadaiForm.action = "/Kadai/Kadai61";
	document.kadaiForm.submit();
}
function onclickBtnKadai62() {
	document.kadaiForm.action = "/Kadai/Kadai62";
	document.kadaiForm.submit();
}
</script>

<body>
	<input type="button" value="課題6-1" onclick="onclickBtnKadai61();" />
	<input type="button" value="課題6-2" onclick="onclickBtnKadai62();" />
	<form name="kadaiForm" method="post">
	</form>
</body>
</html>