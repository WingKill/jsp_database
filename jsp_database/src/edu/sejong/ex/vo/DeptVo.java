package edu.sejong.ex.vo;

/*value Object = bean*/
//이름     널?       유형           
//------ -------- ------------ 
//DEPTNO NOT NULL NUMBER(2)    
//DNAME           VARCHAR2(14) 
//LOC             VARCHAR2(13) 
public class DeptVo {
	private int deptno;
	private String dname;
	private String loc;
	
	public DeptVo() {
		
	}
	
	public DeptVo(int deptno,String dname,String loc){
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}	
}
