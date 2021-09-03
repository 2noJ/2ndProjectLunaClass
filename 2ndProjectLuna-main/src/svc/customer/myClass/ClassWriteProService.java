package svc.customer.myClass;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.CustomerDAO;
import vo.ClassBean;
import static db.JdbcUtil.*;

public class ClassWriteProService {
	public boolean registClass(ClassBean classBean) throws Exception{
		boolean isWriteSuccess = false;
		Connection con= getConnection();
		CustomerDAO customerDAO=CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		int insertCount=customerDAO.insertClass(classBean);
		
		if(insertCount>0) {
			commit(con);
			isWriteSuccess=true;
		}else {
			rollback(con);
		}
		close(con);
		return isWriteSuccess;
	}
	
	public Date strToUtilDate(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		return date;
	}
}