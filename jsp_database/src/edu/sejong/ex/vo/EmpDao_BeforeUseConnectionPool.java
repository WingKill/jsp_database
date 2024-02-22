package edu.sejong.ex.vo;
//package edu.sejong.ex.vo;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//public class EmpDao2 {
//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
//	private String id = "scott";
//	private String pw = "tiger";
//	
//	public EmpDao2() {
//		try {
//			Class.forName(driver);
//		} catch (Exception e) {
//			
//		}
//	}
//	
//	public ArrayList<EmpDto> empList(){
//		ArrayList<EmpDto> emps = new ArrayList<EmpDto>();
//		
//		String sql = "select * from emp";
//		try(Connection connection = DriverManager.getConnection(url,id,pw);
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery(sql)){
//			
//			
//			while(rs.next()){
//				int empNo = rs.getInt("empno");
//				String ename = rs.getString("ename"); 
//				String job = rs.getString("job");
//				String mgr = rs.getString("mgr");
//				Timestamp hiredate = rs.getTimestamp("hiredate");
//				int sal = rs.getInt("sal");
//				String comm = rs.getString("comm");
//				int deptno = rs.getInt("deptno");
//				
//				EmpDto dto = new EmpDto(empNo,ename,job,mgr,hiredate,sal,comm,deptno);
//				
//				emps.add(dto);
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return emps;
//	}
//	
//	public ArrayList<EmpDto> getEmpList(){
//		return empList();
//	}
//	
//	public String getHtml() {
//		String html = "";
//		
//		List<EmpDto> emps = empList();
//		
//		for(EmpDto emp : emps) {
//			html = html + emp; 
//		}
//		return html;
//	}
//}
