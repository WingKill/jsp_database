<%@page import="making.vo.EmpDto_Ex"%>
<%@page import="making.vo.EmpDao_Ex"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
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
	String dname = request.getParameter("dname");
	String job = request.getParameter("job");
	String mgr = request.getParameter("mgr");
	String hiredateStr = request.getParameter("hiredate");
	// 형변환시키기
	SimpleDateFormat sdf = new SimpleDateFormat(hiredateStr);
	Date date = sdf.parse(hiredateStr);
	Timestamp hiredate = new Timestamp(date.getTime()); 	
	
	int sal = Integer.parseInt(request.getParameter("sal"));
	String comm = request.getParameter("comm");
	int deptno = Integer.parseInt(request.getParameter("deptno"));
	
	EmpDto_Ex dto = new EmpDto_Ex(empNo, dname, job, mgr ,hiredate, sal, comm, deptno);
	
	EmpDao_Ex dao = new EmpDao_Ex();
	dao.insert(dto);
%>
<a href="emp01_list.jsp">리스트 확인하기</a>
</body>
</html>