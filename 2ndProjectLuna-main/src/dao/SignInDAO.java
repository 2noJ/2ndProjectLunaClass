package dao;
import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.sql.DataSource;

import db.JdbcUtil;
import vo.ClassBean;
import vo.Customer_bean;
import vo.Join_bean;

public class SignInDAO {
	DataSource ds;
	Connection con;

	private static SignInDAO signinDAO;

	private SignInDAO() {
	}

	public static SignInDAO getInstance() {
		if (signinDAO == null) {
			signinDAO = new SignInDAO();
		}
		return signinDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
		
	public Customer_bean selectById(String id) throws SQLException {
		
		 PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         pstmt = con.prepareStatement(
	               "select * from CUSTOMER where CUS_ID = ?");
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         Customer_bean member = null;
	         if (rs.next()) {
	            member = new Customer_bean(
	                  rs.getString("CUS_ID"),
	                  rs.getString("CUS_PWD"),
	                  rs.getString("CUS_NAME"),
	                  rs.getString("CUS_PROFILE_PATH"),
	                  rs.getString("CUS_ADDR"),
	                  rs.getString("CUS_TEL"),
	                  toDate(rs.getTimestamp("CUS_REGDATE")));
	         }
	         return member;
	      } finally {
	         JdbcUtil.close(rs);
	         JdbcUtil.close(pstmt);
	      }		
	}
	   
   private Date toDate(Timestamp date) {
      return date == null ? null : new Date(date.getTime());
   }
   
   public void insert(Connection con, Join_bean CusBean) throws SQLException {
 		try (PreparedStatement pstmt =
 				con.prepareStatement("insert into customer (CUS_ID, CUS_PWD, CUS_NAME, CUS_ADDR, CUS_TEL) values(?,?,?,?,?)")) {
 			pstmt.setString(1, CusBean.getCUS_ID());
 			pstmt.setString(2, CusBean.getCUS_PWD());
 			pstmt.setString(3, CusBean.getCUS_NAME());
 			pstmt.setString(4, CusBean.getCUS_ADDR());
 			pstmt.setString(5, CusBean.getCUS_TEL());
 			pstmt.executeUpdate();
 		}
 	}
 	
 	public void update(Connection con, Customer_bean CusBean) throws SQLException {
 		try (PreparedStatement pstmt =
 				con.prepareStatement("update customer set CUS_PWD = ?, CUS_NAME = ?, CUS_ADDR = ?, CUS_TEL = ? where CUS_ID = ?")) {
 			pstmt.setString(1, CusBean.getCUS_PWD());
 			pstmt.setString(2, CusBean.getCUS_NAME());
 			pstmt.setString(3, CusBean.getCUS_ADDR());
 			pstmt.setString(4, CusBean.getCUS_TEL());
 			pstmt.setString(5, CusBean.getCUS_ID());
 			pstmt.executeUpdate();
 		}
 	}
public boolean idCheck(String id) { 
 		
 		Connection con = null;
 		PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean x = false;

 		try {
 			
 			StringBuffer query = new StringBuffer();
            query.append("SELECT CUS_ID FROM CUSTOMER WHERE CUS_ID=?");

            con = JdbcUtil.getConnection();
            pstm = con.prepareStatement(query.toString());
            pstm.setString(1, id);
            rs = pstm.executeQuery();

if(rs.next()) x= true; //해당 아이디 존재
            
            return x;
            
        } catch (Exception sqle) {
            throw new RuntimeException(sqle.getMessage());
        } finally {
            try{
                if ( pstm != null ){ pstm.close(); pstm=null; }
                if ( con != null ){ con.close(); con=null;    }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
    } // end duplicateIdCheck()
 	
   
   
   public String getProfile(String userID) {
	   String userProfile=null;
	   PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from customer where CUS_ID = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userProfile=rs.getString("CUS_PROFILE_PATH");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return userProfile;
		
	   
   }
}
	
	
	
	
	
	
	
	
	
	


