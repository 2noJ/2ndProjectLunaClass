package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Mag_ClassDAO;
import db.JdbcUtil;

public class MagClassDeleteService {

   private Mag_ClassDAO classDao = Mag_ClassDAO.getInstance();
  
 
   
   public boolean deleteClass(int cl_id) {
	      try (Connection conn = JdbcUtil.getConnection()) {
	    	  classDao.setConnection(conn);
	    	
	    	  boolean isDeleteSuccess = false;
	  	
	  		
	  	
	  		int deleteCount = classDao.deleteClassList(cl_id);
	  		int deletRevCount = classDao.deleteCLassRevList(cl_id);
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