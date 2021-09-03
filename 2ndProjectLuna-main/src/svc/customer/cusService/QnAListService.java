package svc.customer.cusService;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QnADAO;
import vo.QNA_bean;

public class QnAListService {
	public int getQnAListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		QnADAO qnaDAO = QnADAO.getInstance();
		qnaDAO.setConnection(con);
		listCount = qnaDAO.selectQnAListCount();
		close(con);
		return listCount;

	}

	public ArrayList<QNA_bean> getQnAList(int page, int limit) throws Exception {

		ArrayList<QNA_bean> qnaList = null;
		Connection con = getConnection();
		QnADAO qnaDAO = QnADAO.getInstance();
		qnaDAO.setConnection(con);
		qnaList = qnaDAO.selectQnAList(page, limit);
		close(con);
		return qnaList;
	}
}