package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CustomerDAO;
import vo.Customer_bean;

public class CustomerListService {
	public int getCustomerListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		CustomerDAO customereDAO = CustomerDAO.getInstance();
		customereDAO.setConnection(con);
		listCount = customereDAO.selectCustomerListCount();
		close(con);
		return listCount;

	}

	public ArrayList<Customer_bean> getCustomerList(int page, int limit) throws Exception {

		ArrayList<Customer_bean> customerList = null;
		Connection con = getConnection();
		CustomerDAO customereDAO = CustomerDAO.getInstance();
		customereDAO.setConnection(con);
		customerList = customereDAO.selectCustomerList(page, limit);
		close(con);
		return customerList;
	}
	
//	public Customer_bean getCustomer(int notice_id) throws Exception{
//		
//		Customer_bean customer = null;
//		Connection con = getConnection();
//		CustomerDAO customerDAO = CustomerDAO.getInstance();
//		customerDAO.setConnection(con);
//		int updateCount = customerDAO.updateViewCount(customer_id);
//		
//		if(updateCount > 0){
//			commit(con);
//		}
//		else{
//			rollback(con);
//		}
//		
//		customer = customerDAO.selectCustomer(notice_id);
//		close(con);
//		return customer;
//		
//	}
}