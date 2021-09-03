package svc.manager;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CustomerDAO;
import dao.replyDAO;
import vo.ClassBean;
import vo.Mag_replyBean;

public class CommentListService {
	
	

	public ArrayList<Mag_replyBean> getList(int page, int limit) {
		Connection con = getConnection();
		replyDAO dao = replyDAO.getInstance();
		dao.setConnection(con);
		ArrayList<Mag_replyBean> bbeanList = null;
		bbeanList = dao.getCommentList(page,limit);
		if(bbeanList.size() > 0) {
			commit(con);
		}
		close(con);
		return bbeanList;
		
	}
	public int getCustomerListCount() {
		int listCount = 0;
		Connection con = getConnection();
		replyDAO replydao = replyDAO.getInstance();
		replydao.setConnection(con);
		listCount = replydao.selectCommentListCount();
		close(con);
		return listCount;
		
	}
	
	
}
