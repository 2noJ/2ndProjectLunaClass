package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import dao.CusResDAO;
import db.JdbcUtil;

public class Mag_cusResDeleteService {

	private CusResDAO cusResDao = CusResDAO.getInstance();
	  
	   
	   public boolean cusResDelete(String cusres_id, int cusres_num) {
	      try (Connection conn = JdbcUtil.getConnection()) {
	    	  cusResDao.setConnection(conn);
	    	  
	    
	    	  boolean isDeleteSuccess = false;
	  	
	  		
	  	
	  		int deleteCount = cusResDao.cusResDelete(cusres_id, cusres_num);
	  		
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
