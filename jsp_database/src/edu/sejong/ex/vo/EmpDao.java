package edu.sejong.ex.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import making.vo.EmpDto_Ex;

public class EmpDao {
	// 커넥션 풀 객체
	private DataSource dataSource = null;
	public EmpDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			
		}
	}
	
	public ArrayList<EmpDto> empList(){
		ArrayList<EmpDto> emps = new ArrayList<EmpDto>();
		
		String sql = "select * from emp";
		try(Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql)){
			
			
			while(rs.next()){
				int empNo = rs.getInt("empno");
				String ename = rs.getString("ename"); 
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String hiredate = rs.getString("hiredate");
				int sal = rs.getInt("sal");
				String comm = rs.getString("comm");
				int deptno = rs.getInt("deptno");
				
				EmpDto dto = new EmpDto(empNo,ename,job,mgr,hiredate,sal,comm,deptno);
				
				emps.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return emps;
	}
	
	public int insert(EmpDto emp){
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;		

		String sql = "Insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values (?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println("sql 확인 : " + sql);
		int row = 0;
		try{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,emp.getEmpNo());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setString(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setString(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			
			row = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}									
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public ArrayList<EmpDto> getEmpList(){
		return empList();
	}
	
	public String getHtml() {
		String html = "";
		
		List<EmpDto> emps = empList();
		
		for(EmpDto emp : emps) {
			html = html + emp; 
		}
		return html;
	}
}
