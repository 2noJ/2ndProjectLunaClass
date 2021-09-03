package svc.customer.classes;
import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CusReplyDAO;
import vo.recomment_bean;
import vo.replyBean;

public class Cus_updateCommentService {

	public int updatecommet(replyBean bean) {
		
		Connection con = getConnection();
		CusReplyDAO dao = CusReplyDAO.getInstance();
		dao.setConnection(con);
		int tue =dao.updateCommend(bean);

		
		if(tue > 0) {
			commit(con);
		}
		close(con);
		return tue;
		
		
	}

	public int updateRecomment(recomment_bean bean) {
		Connection con = getConnection();
		CusReplyDAO dao = CusReplyDAO.getInstance();
		dao.setConnection(con);
		int tue =dao.updateRecomment(bean);

		
		if(tue > 0) {
			commit(con);
		}
		close(con);
		return tue;
}
}
