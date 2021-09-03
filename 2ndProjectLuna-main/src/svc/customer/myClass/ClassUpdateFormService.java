package svc.customer.myClass;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CustomerDAO;
import vo.ClassBean;

public class ClassUpdateFormService {

	public ClassBean getClass(int CL_ID) {
		ClassBean updateClass = new ClassBean();
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		updateClass = customerDAO.getClassInfo(CL_ID);
		close(con);
		return updateClass;
	}
	
	
	
}
