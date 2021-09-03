package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import dao.CustomerDAO;
import db.JdbcUtil;

public class NameUpdateService {

	private CustomerDAO customerDao = CustomerDAO.getInstance();
	  
	   
	   public boolean nameUpdate(String cus_name, String cus_id) {
	      try (Connection conn = JdbcUtil.getConnection()) {
	    	  customerDao.setConnection(conn);
	    	  
	    	
	    	  boolean isUpdateSuccess = false;
	  	
	  		
	  	
	  		int updateCount = customerDao.nameUpdate(cus_name, cus_id);
	  		
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
