package svc.customer.classes;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ClassDetailDAO;
import dao.JjimDAO;
import vo.ClassBean;
import vo.Customer_bean;
import vo.JjimBean;
import vo.ReservationBean;

public class JjimCancelDetailService {

	
	public JjimBean getSelectJjimBean(int CL_ID, String userId) throws Exception{
		// TODO Auto-generated method stub

		JjimBean jjimBean = null;
		Connection con = getConnection();
		JjimDAO jjimDAO = JjimDAO.getInstance();
		jjimDAO.setConnection(con);
		
		jjimBean = jjimDAO.selectJjim(CL_ID, userId);
		close(con);
		return jjimBean;

	}
	
	
	public JjimBean getDeleteJjimBean(int CL_ID, String userId) throws Exception{
		// TODO Auto-generated method stub

		JjimBean jjimBean = null;
		Connection con = getConnection();
		JjimDAO jjimDAO = JjimDAO.getInstance();
		jjimDAO.setConnection(con);
		
		
		jjimDAO.deleteJjim(CL_ID, userId);
		jjimBean = jjimDAO.selectJjim(CL_ID, userId);
		close(con);
		return jjimBean;

	}
	
	
	public ArrayList<Customer_bean> getCustomerList(int CL_ID) throws Exception{

		ArrayList<Customer_bean> customerList = null;
		Connection con = getConnection();
		ClassDetailDAO customerListDAO = ClassDetailDAO.getInstance();
		customerListDAO.setConnection(con);
		customerList = customerListDAO.selectCustomerList(CL_ID);
		close(con);
		return customerList;

	}

	public ArrayList<ReservationBean> getReservationList(int CL_ID) throws Exception{

		ArrayList<ReservationBean> reservationList = null;
		Connection con = getConnection();
		ClassDetailDAO reservationListDAO = ClassDetailDAO.getInstance();
		reservationListDAO.setConnection(con);
		reservationList = reservationListDAO.selectReservationList(CL_ID);
		close(con);
		return reservationList;
	}













	public ClassBean getArticle(int CL_ID) throws Exception{
		// TODO Auto-generated method stub

		ClassBean article = null;
		Connection con = getConnection();
		ClassDetailDAO boardDAO = ClassDetailDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.updateReadCount(CL_ID);

		if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}

		article = boardDAO.selectArticle(CL_ID);
		close(con);
		return article;

	}

}
