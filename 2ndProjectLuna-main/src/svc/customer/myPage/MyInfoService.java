package svc.customer.myPage;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CustomerDAO;
import vo.Customer_bean;
import vo.User;

public class MyInfoService {
	public Customer_bean getMyInfo(User authUser) throws Exception {
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		Customer_bean myInfo = customerDAO.getMyInfo(authUser);
		close(con);
		return myInfo;

	}
}
