package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.Mag_ClassDAO;
import vo.ClassBean;
import vo.Customer_bean;
import vo.ReservationBean;

public class Mag_ClassDetailService {
	
	

	public ArrayList<Customer_bean> getCustomerList(int CL_ID) throws Exception{

		ArrayList<Customer_bean> customerList = null;
		Connection con = getConnection();
		Mag_ClassDAO magclassDAO = Mag_ClassDAO.getInstance();
		magclassDAO.setConnection(con);
		customerList = magclassDAO.selectCustomerList(CL_ID);
		close(con);
		return customerList;
	}

	public ArrayList<ReservationBean> getReservationList(int CL_ID) throws Exception{

		ArrayList<ReservationBean> reservationList = null;
		Connection con = getConnection();
		Mag_ClassDAO magclassDAO = Mag_ClassDAO.getInstance();
		magclassDAO.setConnection(con);
		reservationList = magclassDAO.selectReservationList(CL_ID);
		close(con);
		return reservationList;

	}


	public ClassBean getArticle(int CL_ID) throws Exception{
		// TODO Auto-generated method stub

		ClassBean article = null;
		Connection con = getConnection();
		Mag_ClassDAO magclassDAO = Mag_ClassDAO.getInstance();
		magclassDAO.setConnection(con);
		

		article = magclassDAO.selectArticle(CL_ID);
		close(con);
		return article;

	}

}
