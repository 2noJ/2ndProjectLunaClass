package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import dao.NoticeDAO;
import db.JdbcUtil;

public class MagNoticeInsertService {

   private NoticeDAO noticeDao = NoticeDAO.getInstance();
  
   
   public boolean insertNotice(String notice_title, String notice_content) {
      try (Connection conn = JdbcUtil.getConnection()) {
    	  noticeDao.setConnection(conn);
    	  
    
    	  boolean isModifySuccess = false;
  	
  		
  	
  		int insertCount = noticeDao.insertMagNoticeList(notice_title, notice_content);
  		
  		if(insertCount > 0){
  			commit(conn);
  			isModifySuccess=true;
  		}
  		else{
  			rollback(conn);
  		}
  		
  		close(conn);
  		return isModifySuccess;
  		
  	
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
   }
}