<%@page import="edu.sejong.ex.vo.EmpDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="empDao" class="edu.sejong.ex.vo.EmpDao"/>
<jsp:getProperty property="empList" name="empDao" />
<%	for(EmpDto dto : empDao.getEmpList()){ 
		out.println(dto + "<br>");
	}%>
</body>
</html>