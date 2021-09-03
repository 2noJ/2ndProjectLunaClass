package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import dao.QnADAO;
import db.JdbcUtil;

public class FnQInsertService {

   private QnADAO qnaDao = QnADAO.getInstance();
  
   
   public boolean insertFnQ(String fnq_title, String qna_content) {
      try (Connection conn = JdbcUtil.getConnection()) {
    	  qnaDao.setConnection(conn);
    
    	  boolean isInsertSuccess = false;
  	
  		
  	
  		int insertCount = qnaDao.insertFnQList(fnq_title, qna_content);
  		
  		if(insertCount > 0){
  			commit(conn);
  			isInsertSuccess=true;
  		}
  		else{
  			rollback(conn);
  		}
  		
  		close(conn);
  		return isInsertSuccess;
  		
  	
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
   }
}