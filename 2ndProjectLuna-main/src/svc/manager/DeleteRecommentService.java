package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CustomerDAO;
import dao.replyDAO;

public class DeleteRecommentService {

	public void recommentdelete(int recomment_num) {
		
		Connection con = getConnection();
		replyDAO dao = replyDAO.getInstance();
		dao.setConnection(con);
		
		 dao.deleteRecomment(recomment_num);
			commit(con);
			close(con);
	}

}
