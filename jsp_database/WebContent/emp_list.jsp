<%@page import="edu.sejong.ex.vo.EmpDto"%>
<%@page import="edu.sejong.ex.EmpDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="making.vo.EmpDao_Ex"%>
<%@page import="making.vo.EmpDto_Ex"%>
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
<a href="emp_insert_form_prac.jsp">뒤로</a><br>
<%-- <%
	EmpDao empDao = new EmpDao();
	ArrayList<EmpDto> dtos = empDao.empList();
	for(EmpDto emp : dtos){
		out.print(emp+"<br>");
	}
%> --%>
<jsp:useBean id="empDao" class="edu.sejong.ex.EmpDao"/>
<c:set var="etos" value="${empDao.empList}"></c:set>
<table border="1" style="background-color:purple; ">
	<tr style="background-color:orange; ; font-weight: bold; text-align: center ; ">
		<td>사원번호</td>
		<td>사원명</td>
		<td>직업</td>
		<td>매니저번호</td>
		<td>입사일</td>
		<td>봉급</td>
		<td>보너스</td>
		<td>부서번호</td>
	</tr>
<c:forEach var="emp" items="${etos}">
	<tr style="background-color:olive; ;text-align: center;">
		<td>${emp.empNo}</td>
		<td>${emp.ename}</td>
		<td>${emp.job}</td>
		<td>${emp.mgr}</td>
		<td>${emp.hiredate}</td>
		<td>${emp.sal}</td>
		<td>${emp.comm}</td>
		<td>${emp.deptno}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>