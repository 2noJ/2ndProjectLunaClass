package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import dao.QnADAO;
import db.JdbcUtil;

public class FnQDeleteService {

   private QnADAO qnaDao = QnADAO.getInstance();
  
   
 
   public boolean deleteFnQ(int fnq_id) {
	      try (Connection conn = JdbcUtil.getConnection()) {
	    	  qnaDao.setConnection(conn);
	    	
	    	
	    	  boolean isDeleteSuccess = false;
	  	
	  		
	  	
	  		int deleteCount = qnaDao.deleteFnQList(fnq_id);
	  		
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