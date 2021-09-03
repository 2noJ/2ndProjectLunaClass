package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CustomerDAO;
import vo.Customer_bean;

public class CustomerDetailService {
	public Customer_bean getCusInfo(String cus_id) throws Exception {
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		Customer_bean cusInfo = customerDAO.getCustomerInfo(cus_id);
		close(con);
		return cusInfo;

	}
}
