package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CusResDAO;
import vo.CusRes_bean;


public class Mag_cusResListService {

	public int getCusResListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		CusResDAO cusResDAO = CusResDAO.getInstance();
		cusResDAO.setConnection(con);
		listCount = cusResDAO.CusResListCount();
		close(con);
		return listCount;

	}

	public ArrayList<CusRes_bean> getCusResList(int page, int limit) throws Exception {

		ArrayList<CusRes_bean> cusResList = null;
		Connection con = getConnection();
		CusResDAO cusResDAO = CusResDAO.getInstance();
		cusResDAO.setConnection(con);
		cusResList = cusResDAO.selectCusResList(page, limit);
		close(con);
		return cusResList;
	}
}
