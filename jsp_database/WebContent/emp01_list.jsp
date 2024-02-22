<%@page import="making.vo.EmpDto_Ex"%>
<%@page import="java.util.ArrayList"%>
<%@page import="making.vo.EmpDao_Ex"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	EmpDao_Ex empDao = new EmpDao_Ex();
	ArrayList<EmpDto_Ex> dtos = empDao.empList();
	for(EmpDto_Ex emp : dtos){
		out.print(emp+"<br>");
	}
%>

</body>
</html>