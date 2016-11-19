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
			<form action="/Kadai/Kadai62" method="post">
				<fieldset>
					<legend>検索方法</legend>
					<c:forEach items="${SEARCH_TYPE_DOX}" var="obj" varStatus="objStatus">
						<c:choose>
							<c:when test="${input.searchType==null && objStatus.index==0}">
								<input name="searchType" type="radio" value="${obj.key}" checked /><c:out value="${obj.value}" />
							</c:when>
							<c:when test="${input.searchType==obj.key}">
								<input name="searchType" type="radio" value="${obj.key}" checked /><c:out value="${obj.value}" />
							</c:when>
							<c:otherwise>
								<input name="searchType" type="radio" value="${obj.key}" /><c:out value="${obj.value}" />
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</fieldset>
				<div>
					<input type="text" name="searchParam" value="<c:out value="${input.searchParam}" />" >
					<input type="submit" value="検索" />
				</div>
			</form>
			<table border="1">
				<c:forEach items="${input.labelNameList}" var="obj" varStatus="objStatus">
					<c:if test="${objStatus.index==0}">
						<tr>
					</c:if>
					<c:choose>
						<c:when test="${obj.status}">
							<td style="background-color:red;"><c:out value="${obj.labelName}" /></td>
						</c:when>
						<c:otherwise>
							<td><c:out value="${obj.labelName}" /></td>
						</c:otherwise>
					</c:choose>
					<c:if test="${(objStatus.index+1)%7==0}">
						</tr>
						<tr>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>