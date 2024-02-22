package making.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmpDao_Ex {
	// 커넥션 풀 객체
	private DataSource dataSource = null;
	public EmpDao_Ex() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			
		}
	}
	
	public ArrayList<EmpDto_Ex> empList(){
		ArrayList<EmpDto_Ex> emps = new ArrayList<EmpDto_Ex>();
		
		String sql = "select * from emp01"; 
		try(Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql)){
			
			
			while(rs.next()){
				int empNo = rs.getInt("empno");
				String ename = rs.getString("ename"); 
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				Timestamp hiredate = rs.getTimestamp("hiredate");
				int sal = rs.getInt("sal");
				String comm = rs.getString("comm");
				int deptno = rs.getInt("deptno");
				
				EmpDto_Ex dto = new EmpDto_Ex(empNo,ename,job,mgr,hiredate,sal,comm,deptno);
				
				emps.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return emps;
	}
	// 직급리스트 가져오기
	public ArrayList<String> getJobs(){
		ArrayList<String> jobs = new ArrayList<String>();
		
		String sql = "select distinct job from emp";
		try(Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql)){			
			while(rs.next()){
				String job = rs.getString("job");
				jobs.add(job);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return jobs;
	}
	
	public ArrayList<EmpDto_Ex> getMgrs(){
		ArrayList<EmpDto_Ex> emps = new ArrayList<EmpDto_Ex>();
		
		String sql = "select * from emp where job = 'MANAGER'"; 
		try(Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql)){			
			while(rs.next()){
				int empNo = rs.getInt("empno");
				String ename = rs.getString("ename"); 
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				Timestamp hiredate = rs.getTimestamp("hiredate");
				int sal = rs.getInt("sal");
				String comm = rs.getString("comm");
				int deptno = rs.getInt("deptno");
				
				EmpDto_Ex dto = new EmpDto_Ex(empNo,ename,job,mgr,hiredate,sal,comm,deptno);
				
				emps.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return emps;
	}
	
	public int insert(EmpDto_Ex emp){
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		

		String sql = "Insert into emp01(empno,ename,job,mgr,hiredate,sal,comm,deptno) values (?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println("sql 확인 : " + sql);
		int result = 0;
		try{
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,emp.getEmpNo());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setString(4, emp.getMgr());
			pstmt.setTimestamp(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setString(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			
			result = pstmt.executeUpdate();
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
		return result;
	}
	
	public ArrayList<EmpDto_Ex> getEmpList(){
		return empList();
	}
	
	public String getHtml() {
		String html = "";
		
		List<EmpDto_Ex> emps = empList();
		
		for(EmpDto_Ex emp : emps) {
			html = html + emp; 
		}
		return html;
	}
}
