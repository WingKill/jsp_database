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
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	DeptVo dept = new DeptVo(Integer.parseInt(deptno),dname,loc);
	
	DeptDao deptDao = new DeptDao();
	
	deptDao.update(dept);
%>
<a href="dept_list.jsp">dept list 확인</a>
</body>
</html>