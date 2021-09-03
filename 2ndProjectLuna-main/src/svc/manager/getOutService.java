package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CustomerDAO;
import dao.SignInDAO;
import vo.Customer_bean;

public class getOutService {

public boolean checkClassING(String cusid) throws Exception {
	boolean isClassING = false;
	Connection con = getConnection();
	CustomerDAO customerDAO = CustomerDAO.getInstance();
	customerDAO.setConnection(con);
	int countclass = customerDAO.checkClassING(cusid);
	if (countclass > 0) {
		isClassING = true;
	}
	close(con);
	return isClassING;
}
public boolean checkParticlpateING(String cusid) throws Exception {
	boolean isParticlpateING = false;
	Connection con = getConnection();
	CustomerDAO customerDAO = CustomerDAO.getInstance();
	customerDAO.setConnection(con);
	int countparti = customerDAO.checkParticlpateING(cusid);
	if (countparti > 0) {
		isParticlpateING = true;
	}
	close(con);
	return isParticlpateING;
}

public Customer_bean myPass(String cusid) throws Exception {
	Customer_bean myInfo = null;
	Connection con = getConnection();
	CustomerDAO customerDAO = CustomerDAO.getInstance();
	customerDAO.setConnection(con);
	myInfo = customerDAO.getCustomerInfo(cusid);
	
	close(con);
	return myInfo;
}

public boolean deletemember(String cusid) throws Exception {
	boolean isDeleteSuccess = false;
	Connection con = getConnection();
	CustomerDAO customerDAO = CustomerDAO.getInstance();
	SignInDAO signInDao = SignInDAO.getInstance();
	customerDAO.setConnection(con);
	signInDao.setConnection(con);
	con.setAutoCommit(false);
	Customer_bean member = signInDao.selectById(cusid);
	if (member == null) {
		return isDeleteSuccess;
	}
	
	int count = customerDAO.deleteMember(cusid);
	if (count > 0) {
		con.commit();
		customerDAO.leaveUp(cusid);	
		isDeleteSuccess = true;
	} else {
		con.rollback();
	}
	

	close(con);
	return isDeleteSuccess;
}


}
