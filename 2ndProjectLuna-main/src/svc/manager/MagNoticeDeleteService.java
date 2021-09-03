package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import dao.NoticeDAO;
import db.JdbcUtil;

public class MagNoticeDeleteService {

   private NoticeDAO noticeDao = NoticeDAO.getInstance();
  
   
   public boolean deleteNotice(int notice_id) {
      try (Connection conn = JdbcUtil.getConnection()) {
    	  noticeDao.setConnection(conn);
    	  
    	  System.out.println("되나??");
    	  boolean isDeleteSuccess = false;
  	
  		
  	
  		int deleteCount = noticeDao.deleteMagNoticeList(notice_id);
  		
  		if(deleteCount > 0){
  			commit(conn);
  			isDeleteSuccess=true;
  		}
  		else{
  			rollback(conn);
  		}
  		
  		close(conn);
  		return isDeleteSuccess;
  		
  	
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
   }
}