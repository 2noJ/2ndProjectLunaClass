package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import dao.NoticeDAO;
import db.JdbcUtil;

public class MagNoticeUpdateService {

	private NoticeDAO noticeDao = NoticeDAO.getInstance();
	  
	   
	   public boolean updateNotice(String notice_title, String notice_content, int notice_id) {
	      try (Connection conn = JdbcUtil.getConnection()) {
	    	  noticeDao.setConnection(conn);
	    	  
	
	    	  boolean isUpdateSuccess = false;
	  	
	  		
	  	
	  		int updateCount = noticeDao.updateMagNoticeList(notice_title, notice_content, notice_id);
	  		
	  		if(updateCount > 0){
	  			commit(conn);
	  			isUpdateSuccess=true;
	  		}
	  		else{
	  			rollback(conn);
	  		}
	  		
	  		close(conn);
	  		return isUpdateSuccess;
	  		
	  	
	      } catch (SQLException e) {
	         throw new RuntimeException(e);
	      }
	   }
	}
