package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CusResDAO;
import vo.CusRes_bean;


public class Mag_cusReservationListService {

	public int getCusResListCount(String cusid) throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		CusResDAO cusResDAO = CusResDAO.getInstance();
		cusResDAO.setConnection(con);
		listCount = cusResDAO.CusResListCount(cusid);
		close(con);
		return listCount;

	}

	public ArrayList<CusRes_bean> getCusResList(int page, int limit, String cusid) throws Exception {

		ArrayList<CusRes_bean> cusResList = null;
		Connection con = getConnection();
		CusResDAO cusResDAO = CusResDAO.getInstance();
		cusResDAO.setConnection(con);
		cusResList = cusResDAO.selectCusResList(page, limit,cusid);
		close(con);
		return cusResList;
	}
}
