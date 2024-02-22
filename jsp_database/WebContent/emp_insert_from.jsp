<%@page import="making.vo.EmpDto_Ex"%>
<%@page import="making.vo.EmpDao_Ex"%>
<%@page import="making.vo.DeptVo_Ex"%>
<%@page import="java.util.List"%>
<%@page import="making.vo.DeptDao_Ex"%>
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
	
	List<DeptVo_Ex> deptlist = deptDao.deptList();
	EmpDao_Ex empDao = new EmpDao_Ex();
	
	List<String> empJobs = empDao.getJobs();
	List<EmpDto_Ex> empMgrs = empDao.getEmpList();
%>
<form action="emp_inserting.jsp" method="post">
	<table>
		<tr>
			<td>사원번호</td>		
			<td><input type="number" name="empno" min="1" max="99" ></td>
		</tr>
		<tr>
			<td>사원이름</td>		
			<td><input type="text" name="dname"></td>
		</tr>
		<tr>
			<td>직급</td>		
			<td>
				<select name="job">
				<% for(String job : empJobs){ %>
					<option value="<%= job %>"> <%= job %></option>
				<% }%>
				</select>
			</td>
		</tr>
		<tr>
			<td>매니저</td>		
			<td>
				<select name="mgr">
				<% for(EmpDto_Ex emp : empMgrs){ %>
					<option value="<%= emp.getEmpNo()%>"> <%= emp.getEname() %></option>
				<% }%>					
				</select>
			</td>
		</tr>
		<tr>
			<td>입사일</td>		
			<td><input type="date" name="hiredate"></td>
		</tr>
		<tr>
			<td>급여</td>		
			<td><input type="text" name="sal"></td>
		</tr>
		<tr>
			<td>커미션</td>		
			<td><input type="text" name="comm"></td>
		</tr>
		<tr>
			<td>부서명</td>		
			<td>
				<select name="deptno">
				<% for(DeptVo_Ex dept : deptlist){ %>
					<option value="<%= dept.getDeptno()%>"> <%= dept.getDname()%></option>
				<% }%>	
				</select>
			</td>
		</tr>
	</table>
	<input type="submit" value="입력">
</form>
</body>
</html>