<%@page import="java.util.List"%>
<%@page import="making.vo.DeptVo_Ex"%>
<%@page import="java.util.ArrayList"%>
<%@page import="making.vo.DeptDao_Ex"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	DeptDao_Ex deptDao = new DeptDao_Ex();

	List<DeptVo_Ex> dtos = deptDao.deptList();
	out.print("-----------------------");
	for(DeptVo_Ex vo : dtos){
		
		out.print("<h4>부서번호 : "+vo.getDeptno()+"</h4>");
		out.print("<h4>부서명 : "+vo.getDname()+"</h4>");
		out.print("<h4>지역 : "+vo.getLoc()+"</h4>");
		out.print("-----------------------");
	}
%>
</body>
</html>