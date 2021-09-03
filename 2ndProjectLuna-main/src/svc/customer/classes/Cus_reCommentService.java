package svc.customer.classes;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CusReplyDAO;
import vo.recomment_bean;

public class Cus_reCommentService {

	public void insertRecomment(recomment_bean bean) {
		
		int tue = 0;
		Connection con = getConnection();
		CusReplyDAO dao = CusReplyDAO.getInstance();
		dao.setConnection(con);
		tue =dao.insertRecomment(bean);

		
		if(tue > 0) {
			commit(con);
		}
		close(con);
		
	}

	public static ArrayList<recomment_bean> getlist() {
		
		Connection con = getConnection();
		CusReplyDAO dao = CusReplyDAO.getInstance();
		dao.setConnection(con);
		
		ArrayList<recomment_bean> recommentList = null;
		recommentList = dao.getCommentlist();
		

		
		if(recommentList.size() > 0) {
			commit(con);
		}
		close(con);
		return recommentList;
	}

}
