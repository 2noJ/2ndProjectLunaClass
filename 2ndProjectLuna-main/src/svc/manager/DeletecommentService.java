package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.replyDAO;

public class DeletecommentService {

	public void commentdelete(int comment_num) {
		
		Connection con = getConnection();
		replyDAO dao = replyDAO.getInstance();
		dao.setConnection(con);
		
		 dao.deletecomment(comment_num);
			commit(con);
			close(con);
	}
}
