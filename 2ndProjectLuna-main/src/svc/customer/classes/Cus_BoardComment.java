package svc.customer.classes;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CusReplyDAO;
import vo.replyBean;
public class Cus_BoardComment {
	
	public void setComment(replyBean bean,int CL_ID) {
		int tue = 0;
		
		Connection con = getConnection();
		CusReplyDAO dao = CusReplyDAO.getInstance();
		dao.setConnection(con);
		tue =dao.inserComend(bean,CL_ID);
		if(tue >0) {
			commit(con);
			
		}
		close(con);
	}
	

	public ArrayList<replyBean> getList(int boardnum) {
		Connection con = getConnection();
		CusReplyDAO dao = CusReplyDAO.getInstance();
		dao.setConnection(con);
		ArrayList<replyBean> bbeanList = null;
		bbeanList = dao.getCommentList(boardnum);

		
		if(bbeanList.size() > 0) {
			commit(con);
		}
		close(con);
		return bbeanList;
		
	}
}
