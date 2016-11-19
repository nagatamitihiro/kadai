<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/common.css" type="text/css" />
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="./js/common.js"></script>
</head>
<script type="text/javascript">
$(function () {
	$("input[type='text']:first").focus();
});
</script>
<body>
	<div id="contents">
		<div id="main">
			<form action="/Kadai/Kadai61" method="post">
				<fieldset>
					<legend>端数処理</legend>
					<c:choose>
						<c:when test="${input.roundTiming=='0' || input.roundTiming==null}">
							<input name="roundTiming" type="radio" value="0" checked />計算前
							<input name="roundTiming" type="radio" value="1" />計算後
						</c:when>
						<c:otherwise>
							<input name="roundTiming" type="radio" value="0" />計算前
							<input name="roundTiming" type="radio" value="1" checked />計算後
						</c:otherwise>
					</c:choose>
				</fieldset>
				<div>
					<input type="text" name="param1" value="<c:out value="${input.param1}" />" >
					<input type="text" name="param2" value="<c:out value="${input.param2}" />" >
					<select name="listDiv">
						<c:forEach items="${LIST_DIV_DOX}" var="obj" varStatus="objStatus">
							<c:choose>
								<c:when test="${obj.key==input.listDiv}">
									<option value="${obj.key}" selected><c:out value="${obj.value}" /></option>
								</c:when>
								<c:otherwise>
									<option value="${obj.key}"><c:out value="${obj.value}" /></option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					<input type="submit" value="計算" />
				</div>
			</form>
			<table border="1">
				<tr>
					<th><c:out value="${input.resultLabel}" /></th>
					<th>偶数/奇数</th>
					<c:if test="${input.showDivi}">
						<th>商</th>
						<th>余</th>
					</c:if>
				</tr>
				<tr>
					<td><fmt:formatNumber value="${result}" /></td>
					<td><c:out value="${evenOdd}" /></td>
					<c:if test="${showDivi}">
						<td><fmt:formatNumber value="${resultInteger}" /></td>
						<td><fmt:formatNumber value="${resultDecimal}" /></td>
					</c:if>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>