<%@page import="edu.sejong.ex.vo.DeptVo"%>
<%@page import="java.util.List"%>
<%@page import="edu.sejong.ex.DeptDao"%>
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
	DeptDao deptDao = new DeptDao();

	List<DeptVo> dtos = deptDao.deptList();
	out.print("-----------------------");
	for(DeptVo vo : dtos){
		
		out.print("<h4>부서번호 : "+vo.getDeptno()+"</h4>");
		out.print("<h4>부서명 : "+vo.getDname()+"</h4>");
		out.print("<h4>지역 : "+vo.getLoc()+"</h4>");
		out.print("-----------------------");
	}
%>


</body>
</html>