<%@page import="edu.sejong.ex.vo.DeptVo"%>
<%@page import="java.util.List"%>
<%@page import="edu.sejong.ex.DeptDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	DeptDao deptDao = new DeptDao();

	List<DeptVo> dtos = deptDao.deptList();
	out.print("-----------------------");
	for(DeptVo vo : dtos){
		
		out.print("<h4>부서번호 : "+vo.getDeptno()+"</h4>");
		out.print("<h4>부서명 : "+vo.getDname()+"</h4>");
		out.print("<h4>지역 : "+vo.getLoc()+"</h4>");
		out.print("-----------------------");
	}
%> --%>
<jsp:useBean id="deptDao" class="edu.sejong.ex.DeptDao"/>
<c:set var="dtos" value="${deptDao.deptList}"></c:set>
<h1></h1>
<table border="1" style="border-color: black; background-color: yellow">
	<tr bgcolor="pink" style="text-align: center; font-weight: bold;">
		<td>부서번호</td>
		<td>부서명</td>
		<td>위치명</td>
	</tr>
<c:forEach var="dto" items="${dtos}">
	<tr align="center" style="background-color: white; ">
		<td> ${dto.deptno} </td>
		<td> ${dto.dname} </td>
		<td> ${dto.loc} </td>
	</tr>
</c:forEach>
</table>
</body>
</html>