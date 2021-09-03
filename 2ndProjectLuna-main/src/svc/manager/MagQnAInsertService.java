package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import dao.QnADAO;
import db.JdbcUtil;

public class MagQnAInsertService {

   private QnADAO qnaDao = QnADAO.getInstance();
  
   
   public boolean insertQnA(String mag_content, int qa_id) {
      try (Connection conn = JdbcUtil.getConnection()) {
    	  qnaDao.setConnection(conn);
    	  qnaDao.insertMagQnAList(mag_content, qa_id);
    	
    	  boolean isModifySuccess = false;
  	
  		
  	
  		int updateCount = qnaDao.insertMagQnAList(mag_content, qa_id);;
  		
  		if(updateCount > 0){
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