<%@page import="edu.sejong.ex.vo.EmpDto"%>
<%@page import="edu.sejong.ex.vo.EmpDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="making.vo.EmpDao_Ex"%>
<%@page import="making.vo.EmpDto_Ex"%>
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
	EmpDao empDao = new EmpDao();
	ArrayList<EmpDto> dtos = empDao.empList();
	for(EmpDto emp : dtos){
		out.print(emp+"<br>");
	}
%>

</body>
</html>