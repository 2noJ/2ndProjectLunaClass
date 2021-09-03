package svc.customer.myClass;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.CustomerDAO;
import vo.ClassBean;

public class ClassUpdateService  {
	public boolean updateClass(ClassBean classBean) throws Exception{
		boolean isUpdateSuccess = false;
		Connection con= getConnection();
		CustomerDAO customerDAO=CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		int updateCount=customerDAO.updateClass(classBean);
		
		if(updateCount>0) {
			commit(con);
			isUpdateSuccess=true;
		}else {
			rollback(con);
		}
		close(con);
		return isUpdateSuccess;
	}
	
	public boolean updateClassNoPic(ClassBean classBean) throws Exception{
		boolean isUpdateSuccess = false;
		Connection con= getConnection();
		CustomerDAO customerDAO=CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		int updateCount=customerDAO.updateClassNoPic(classBean);
		
		if(updateCount>0) {
			commit(con);
			isUpdateSuccess=true;
		}else {
			rollback(con);
		}
		close(con);
		return isUpdateSuccess;
	}
	
	public Date strToUtilDate(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		return date;
	}
}