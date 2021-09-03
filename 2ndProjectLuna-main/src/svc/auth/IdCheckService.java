package svc.auth;

import java.sql.Connection;
import java.sql.SQLException;

import dao.SignInDAO;
import db.JdbcUtil;
import vo.Customer_bean;
import vo.Join_bean;

public class IdCheckService {
	
	private SignInDAO signinDao = SignInDAO.getInstance();
	public void join(Join_bean cusbean) {
		Connection con = null;
		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false);
			signinDao.setConnection(con);
			Customer_bean cusmo = signinDao.selectById(cusbean.getCUS_ID());
			if (cusmo != null) {
				JdbcUtil.rollback(con);
			}
			
			signinDao.insert(con, cusbean);
			con.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(con);
			
		} finally { 
			JdbcUtil.close(con);
		}
	}
}
