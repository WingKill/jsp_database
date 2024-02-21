package edu.sejong.ex.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*Data Access Object*/
//이름     널?       유형           
//------ -------- ------------ 
//DEPTNO NOT NULL NUMBER(2)    
//DNAME           VARCHAR2(14) 
//LOC             VARCHAR2(13) 
public class DeptDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private String id = "scott";
	private String pw = "tiger";
	
	public DeptDao() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			
		}
	}
	
	public List<DeptVo> deptList(){
		List<DeptVo> depts = new ArrayList<DeptVo>();
		
		Connection connection;
		Statement statement;
		ResultSet rs;
		
		String sql = "select * from dept";
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url,id,pw);
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()){
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				DeptVo vo = new DeptVo(deptno,dname,loc);
				
				depts.add(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return depts;
	}
}
