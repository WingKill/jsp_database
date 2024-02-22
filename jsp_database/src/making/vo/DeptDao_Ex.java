package making.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*Data Access Object*/
//이름     널?       유형           
//------ -------- ------------ 
//DEPTNO NOT NULL NUMBER(2)    
//DNAME           VARCHAR2(14) 
//LOC             VARCHAR2(13) 
public class DeptDao_Ex {
	private DataSource dataSource = null;
	
	public DeptDao_Ex() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			
		}
	}
	
	public List<DeptVo_Ex> deptList(){
		List<DeptVo_Ex> depts = new ArrayList<DeptVo_Ex>();
		
		Connection connection;
		Statement statement;
		ResultSet rs;
		
		String sql = "select * from dept";
		try{
			
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()){
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				DeptVo_Ex vo = new DeptVo_Ex(deptno,dname,loc);
				
				depts.add(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return depts;
	}
	
//	public int insert(DeptVo_ dept){
//		Connection conn = null;
//		//Statement stmt = null;
//		PreparedStatement pstmt = null;
//		
////		String sql = "Insert into dept01(DEPTNO,DNAME,LOC) values ("+
////					  dept.getDeptno()+",'"+
////					  dept.getDname()+"','"+
////					  dept.getLoc()+"')";
//		
//		String sql = "Insert into dept01(DEPTNO,DNAME,LOC) values (?, ?, ?)";
//		System.out.println("sql 확인 : " + sql);
//		int result = -1;
//		try{
//			conn = DriverManager.getConnection(url,id,pw);
////			stmt = conn.createStatement();
////			result = stmt.executeUpdate(sql);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1,dept.getDeptno());
//			pstmt.setString(2, dept.getDname());
//			pstmt.setString(3, dept.getLoc());
//			
//			result = pstmt.executeUpdate();
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally {
//			try {
//				if(pstmt != null) {
//					pstmt.close();
//				}				
//					
//				if(conn != null) {
//					conn.close();
//				}
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}
//			
//	public int delete(DeptVo_ dept){
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		String sql = "delete from dept01 where deptno = ?";
//		System.out.println("sql 확인 : " + sql);
//		int result = -1;
//		try{
//			conn = DriverManager.getConnection(url,id,pw);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, dept.getDeptno());
//			result = pstmt.executeUpdate();
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally {
//			try {
//				if(pstmt != null) {
//					pstmt.close();
//				}								
//				if(conn != null) {
//					conn.close();
//				}
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}
//	
//	public int update(DeptVo_ dept){
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		String sql = "update dept01 set dname = ?, loc = ? where deptno = ?";
//		System.out.println("sql 확인 : " + sql);
//		int result = -1;
//		try{
//			conn = DriverManager.getConnection(url,id,pw);
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, dept.getDname());
//			pstmt.setString(2, dept.getLoc());
//			pstmt.setInt(3, dept.getDeptno());
//			result = pstmt.executeUpdate();
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally {
//			try {
//				if(pstmt != null) {
//					pstmt.close();
//				}								
//				if(conn != null) {
//					conn.close();
//				}
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}
}
