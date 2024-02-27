package edu.sejong.ex.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.EmpDao;
import edu.sejong.ex.vo.EmpDto;

public class EmpListCommand implements EmpCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		EmpDao dao = new EmpDao();
		List<EmpDto> empDtos = dao.empList();
		request.setAttribute("emps", empDtos);
		request.setAttribute("empdao", dao);
	}

}
