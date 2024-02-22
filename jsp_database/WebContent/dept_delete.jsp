<%@page import="edu.sejong.ex.vo.DeptDao"%>
<%@page import="edu.sejong.ex.vo.DeptVo"%>
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
	request.setCharacterEncoding("UTF-8");

	String deptno = request.getParameter("deptno");
	DeptVo dept = new DeptVo();
	dept.setDeptno(Integer.parseInt(deptno));
	
	DeptDao deptDao = new DeptDao();
	
	deptDao.delete(dept);
%>
<jsp:include page="dept_list.jsp"/>
<a href="dept_input.html">dept input 화면으로</a>
</body>
</html>