package svc.customer.classes;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ReservationDAO;
import vo.ClassBean;
import vo.JjimBean;
import vo.ReservationBean;

public class ReservationCompletedService {

	
	


	public ClassBean selectClassInfo(int CL_ID) {
		ClassBean classInfoBean = null;  
		Connection con = getConnection();

		ReservationDAO reservationDAO = ReservationDAO.getInstance();
		reservationDAO.setConnection(con);

		classInfoBean =reservationDAO.selectClassInfo(CL_ID);
		close(con);


		return classInfoBean;
	}





	public ArrayList<ReservationBean> resvCheckNum(String userId){

		ArrayList<ReservationBean> revCheckNumList = null;
		Connection con = getConnection();
		ReservationDAO reservationDAO = ReservationDAO.getInstance();
		reservationDAO.setConnection(con);

		revCheckNumList =reservationDAO.resvCheckNum(userId);
		close(con);
		return revCheckNumList; // action으로 가야함





	}






	public ClassBean getArticle(String userId, int CL_ID, String CL_NAME, String CL_WRITER_ID) throws Exception{
		// TODO Auto-generated method stub

		ClassBean reservation = null;
		Connection con = getConnection();
		ReservationDAO reservationDAO = ReservationDAO.getInstance();
		reservationDAO.setConnection(con);
		int updateCount = reservationDAO.updateReadCount(CL_ID);

		if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}


		reservation = reservationDAO.insertArticle(userId, CL_ID, CL_NAME, CL_WRITER_ID);
		close(con);
		return reservation;

	}


	public ReservationBean getArticle2(String userId, int CL_ID) throws Exception{
		// TODO Auto-generated method stub

		ReservationBean reservationBean = null;
		Connection con = getConnection();
		ReservationDAO reservationDAO = ReservationDAO.getInstance();
		reservationDAO.setConnection(con);
		//int updateCount = reservationDAO.updateReadCount(userId);

		//		if(updateCount > 0){
		//			commit(con);
		//		}
		//		else{
		//			rollback(con);
		//		}

		reservationBean = reservationDAO.selectReservationBean(userId, CL_ID);
		close(con);
		return reservationBean;

	}

}
