package svc.customer.myPage;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.sql.SQLException;

import com.oreilly.servlet.MultipartRequest;

import dao.CustomerDAO;
import vo.Customer_bean;
import vo.User;

public class ChangeInfoService {
	public boolean changeInfo(String col,User authUser, String newVal) throws Exception {
		boolean isModifySuccess = false;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		con.setAutoCommit(false);
		int count = customerDAO.infoUpdate(col, authUser, newVal);
		if (count > 0) {
			con.commit();
			isModifySuccess = true;
		} else { 
			con.rollback();
		}
		close(con);
		return isModifySuccess;
	}
	 public User checkName(User authUser) throws Exception {
		 Connection con = getConnection();
			CustomerDAO customerDAO = CustomerDAO.getInstance();
			customerDAO.setConnection(con);
		 
		   Customer_bean cus = customerDAO.selectById(authUser.getId());
	
				  User user = new User(cus.getCUS_ID(),cus.getCUS_NAME(),cus.getCUS_PROFILE_PATH());
		 return user;
	   }
}

