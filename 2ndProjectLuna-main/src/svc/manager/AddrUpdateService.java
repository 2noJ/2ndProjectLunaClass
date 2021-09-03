package svc.manager;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import dao.CustomerDAO;
import db.JdbcUtil;

public class AddrUpdateService {

	private CustomerDAO customerDao = CustomerDAO.getInstance();
	  
	   
	   public boolean addrUpdate(String cus_addr, String cus_id) {
	      try (Connection conn = JdbcUtil.getConnection()) {
	    	  customerDao.setConnection(conn);
	    	  

	    	  boolean isUpdateSuccess = false;
	  	
	  		
	  	
	  		int updateCount = customerDao.addrUpdate(cus_addr, cus_id);
	  		
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

