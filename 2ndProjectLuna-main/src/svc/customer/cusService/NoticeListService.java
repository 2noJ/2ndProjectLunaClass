package svc.customer.cusService;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.NoticeDAO;
import vo.Notice_bean;

public class NoticeListService {
	public int getNoticeListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		listCount = noticeDAO.selectNoticeListCount();
		close(con);
		return listCount;

	}

	public ArrayList<Notice_bean> getNoticeList(int page, int limit) throws Exception {

		ArrayList<Notice_bean> noticeList = null;
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		noticeList = noticeDAO.selectNoticeList(page, limit);
		close(con);
		return noticeList;
	}
	
	public Notice_bean getNotice(int notice_id) throws Exception{
		
		Notice_bean notice = null;
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		int updateCount = noticeDAO.updateViewCount(notice_id);
		
		if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		notice = noticeDAO.selectNotice(notice_id);
		close(con);
		return notice;
		
	}
}