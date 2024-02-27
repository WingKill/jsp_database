<%@page import="edu.sejong.ex.EmpDao"%>
<%@page import="edu.sejong.ex.vo.EmpDto"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	
	int empNo = Integer.parseInt(request.getParameter("empno"));
	String dname = request.getParameter("ename");
	String job = request.getParameter("job");
	String mgr = request.getParameter("mgr");
	String hiredate = request.getParameter("hiredate");
	// 형변환시키기

	int sal = Integer.parseInt(request.getParameter("sal"));
	String comm = request.getParameter("comm");
	int deptno = Integer.parseInt(request.getParameter("deptno"));
	
	EmpDto dto = new EmpDto(empNo,dname,job,mgr,hiredate,sal,comm,deptno);
	
	EmpDao dao = new EmpDao();
	dao.insert(dto);
	response.sendRedirect("emp_list.jsp");
%>

</body>
</html>