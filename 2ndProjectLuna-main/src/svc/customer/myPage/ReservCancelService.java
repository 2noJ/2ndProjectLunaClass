package svc.customer.myPage;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CustomerDAO;
import vo.User;

public class ReservCancelService {
	public boolean reservCancel(User authUser, int classId) throws Exception {
		boolean isCancelSuccess = false;
		Connection con = getConnection();
		CustomerDAO customerDAO = CustomerDAO.getInstance();
		customerDAO.setConnection(con);
		con.setAutoCommit(false);

		int count = customerDAO.reservCancel(authUser.getId(), classId);
		if (count > 0) {
			con.commit();
			isCancelSuccess = true;
		} else {
			con.rollback();
		}
		close(con);
		return isCancelSuccess;
	}
}
