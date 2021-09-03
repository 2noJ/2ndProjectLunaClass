package svc.customer.myPage;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CustomerDAO;
import vo.Customer_bean;
import vo.User;

public class LeaveService {

public boolean checkClassING(User authUser) throws Exception {
	boolean isClassING = false;
	Connection con = getConnection();
	CustomerDAO customerDAO = CustomerDAO.getInstance();
	customerDAO.setConnection(con);
	int countclass = customerDAO.checkClassING(authUser);
	if (countclass > 0) {
		isClassING = true;
	}
	close(con);
	return isClassING;
}
public boolean checkParticlpateING(User authUser) throws Exception {
	boolean isParticlpateING = false;
	Connection con = getConnection();
	CustomerDAO customerDAO = CustomerDAO.getInstance();
	customerDAO.setConnection(con);
	int countparti = customerDAO.checkParticlpateING(authUser);
	if (countparti > 0) {
		isParticlpateING = true;
	}
	close(con);
	return isParticlpateING;
}

public Customer_bean myPass(User authUser) throws Exception {
	Customer_bean myInfo = null;
	Connection con = getConnection();
	CustomerDAO customerDAO = CustomerDAO.getInstance();
	customerDAO.setConnection(con);
	myInfo = customerDAO.getMyInfo(authUser);
	
	close(con);
	return myInfo;
}
}
