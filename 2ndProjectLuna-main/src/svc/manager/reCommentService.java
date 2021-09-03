package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.replyDAO;
import vo.recomment_bean;
import vo.Mag_replyBean;

public class reCommentService {


	public static ArrayList<recomment_bean> getlist() {
		
		Connection con = getConnection();
		replyDAO dao = replyDAO.getInstance();
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
