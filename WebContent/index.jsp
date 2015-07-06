<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="context" value="<%=request.getContextPath()%>"></c:set>
    
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Index</title>
</head>
<body>
	<h1> jQuery N jQuery Mobile </h1>
	<h3> jQuery</h3>
	<ul>
		<li> <a href="${context}/home/main.do"> 게시판메인 바로가기  </a> </li>
	</ul>

	
</body>
</html>