package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QnADAO;
import vo.FNQ_bean;

public class FnQListService {
	public int getFnQListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		QnADAO qnaDAO = QnADAO.getInstance();
		qnaDAO.setConnection(con);
		listCount = qnaDAO.selectFNQListCount();
		close(con);
		return listCount;

	}

	public ArrayList<FNQ_bean> getFnQList(int page, int limit) throws Exception {

		ArrayList<FNQ_bean> qnaList = null;
		Connection con = getConnection();
		QnADAO qnaDAO = QnADAO.getInstance();
		qnaDAO.setConnection(con);
		qnaList = qnaDAO.selectFnQList(page, limit);
		close(con);
		return qnaList;
	}
}