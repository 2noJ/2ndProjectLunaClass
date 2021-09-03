package svc.customer.myPage;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CustomerDAO;
import dao.SignInDAO;
import vo.ClassBean;
import vo.Customer_bean;
import vo.User;

public class DeleteUserService {

	public boolean deleteUserAction(User authUser, String curPass) throws Exception {
		boolean isDeleteSuccess = false;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		SignInDAO signInDao = SignInDAO.getInstance();
		customerDAO.setConnection(con);
		signInDao.setConnection(con);
		con.setAutoCommit(false);
		Customer_bean member = signInDao.selectById(authUser.getId());
		if (member == null) {
			return isDeleteSuccess;
		}
		if (!member.matchPassword(curPass)) {
			return isDeleteSuccess;
		}
		int count = customerDAO.deleteMember(authUser, curPass);
		if (count > 0) {
			con.commit();
			customerDAO.leaveUp(authUser);	
			isDeleteSuccess = true;
		} else {
			con.rollback();
		}
		

		close(con);
		return isDeleteSuccess;
	}
}
