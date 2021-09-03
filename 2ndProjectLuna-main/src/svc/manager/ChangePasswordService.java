package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CustomerDAO;
import dao.SignInDAO;
import vo.Customer_bean;
import vo.User;

public class ChangePasswordService {

	public boolean changePassword(User authUser, String curPass, String newPass) throws Exception {
		boolean isModifySuccess = false;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		SignInDAO signInDao = SignInDAO.getInstance();
		customerDAO.setConnection(con);
		signInDao.setConnection(con);
		con.setAutoCommit(false);
		Customer_bean member = signInDao.selectById(authUser.getId());
		if (member == null) {
			return isModifySuccess;
		}
		if (!member.matchPassword(curPass)) {
			return isModifySuccess;
		}
		member.changePassword(newPass);
		int count = customerDAO.passUpdate(newPass, authUser);
		if (count > 0) {
			con.commit();
			isModifySuccess = true;
		} else {
			con.rollback();
		}
		close(con);
		return isModifySuccess;
	}
}
