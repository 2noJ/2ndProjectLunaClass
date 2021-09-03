package svc.customer.classes;
import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CusReplyDAO;

public class Cus_DeletecommentService {

	public void commentdelete(int comment_num) {
		
		Connection con = getConnection();
		CusReplyDAO dao = CusReplyDAO.getInstance();
		dao.setConnection(con);
		
		 dao.deletecomment(comment_num);
			commit(con);
			close(con);
	}
}
