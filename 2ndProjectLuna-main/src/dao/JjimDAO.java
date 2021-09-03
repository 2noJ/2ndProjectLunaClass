package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import db.JdbcUtil;
import vo.ClassBean;
import vo.JjimBean;
import vo.ReservationBean;

public class JjimDAO {
	DataSource ds;
	Connection con;

	private static JjimDAO customerDAO;

	private JjimDAO() {
	}

	public static JjimDAO getInstance() {
		if (customerDAO == null) {
			customerDAO = new JjimDAO();
		}
		return customerDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	
	
	
	
	public JjimBean selectJjim(int CL_ID, String userId) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from jjim where JJIM_CL_ID = ? and JJIM_CUS_ID = ?";
		
		JjimBean jjimBean = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, CL_ID);
			pstmt.setString(2, userId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				jjimBean = new JjimBean();
				jjimBean.setJJIM_CL_ID(rs.getInt("JJIM_CL_ID"));
				jjimBean.setJJIM_CUS_ID(rs.getString("JJIM_CUS_ID"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return jjimBean;
	}
	
	
	
	
	
	public void insertJjim(int CL_ID, String userId){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JjimBean jjimBean = null;
		int count = 0;
		try{
			
			pstmt = con.prepareStatement(
					"insert into Jjim(JJIM_CL_ID, JJIM_CUS_ID)"
					+"values(?, ?)");
					
					//"select * from class where CL_ID = ?");
			
			pstmt.setInt(1, CL_ID);
			pstmt.setString(2, userId);
			count = pstmt.executeUpdate();
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			 if(count>0) {
		         JdbcUtil.commit(con);
		         
		      }else {
		    	  JdbcUtil.rollback(con);
		      }
			close(pstmt);
		}
	}
	
	public void deleteJjim(int CL_ID, String userId){

		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		JjimBean jjimBean = null;
		int count = 0;
		try{
			
			pstmt = con.prepareStatement(
					"delete from Jjim where JJIM_CL_ID = ? and JJIM_CUS_ID = ?");
					
					//"select * from class where CL_ID = ?");
			
			pstmt.setInt(1, CL_ID);
			pstmt.setString(2, userId);
			count = pstmt.executeUpdate();
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			 if(count>0) {
		         JdbcUtil.commit(con);
		         
		      }else {
		    	  JdbcUtil.rollback(con);
		      }
			close(pstmt);
		}
	}
	
	
	

	public int selectClassListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			pstmt = con.prepareStatement("SELECT count(*) FROM CLASS");
			rs = pstmt.executeQuery();
			if(rs.next()){
				listCount=rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<ClassBean> selectClassList(int page, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from CLASS order by CL_START_DATE desc limit ?,6";
		ArrayList<ClassBean> classList = new ArrayList<ClassBean>();
		ClassBean class1 = null;
		int startrow = (page - 1) * 6;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				class1 = new ClassBean();
				class1.setCL_ID(rs.getInt("CL_ID"));
				class1.setCL_NAME(rs.getString("CL_NAME"));
				class1.setCL_WRITER_ID(rs.getString("CL_WRITER_ID"));
				class1.setCL_CATEGORY(rs.getString("CL_CATEGORY"));
				class1.setCL_CONTENT(rs.getString("CL_CONTENT"));
				class1.setCL_INTRODUCTION(rs.getString("CL_INTRODUCTION"));
				class1.setCL_START_DATE(rs.getDate("CL_START_DATE"));
				class1.setCL_END_DATE(rs.getDate("CL_END_DATE"));
				class1.setCL_LOCATION(rs.getString("CL_LOCATION"));
				class1.setCL_CAPACITY(rs.getInt("CL_CAPACITY"));
				class1.setCL_IMG_PATH(rs.getString("CL_IMG_PATH"));
				class1.setCL_VIEW(rs.getInt("CL_VIEW"));
				classList.add(class1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return classList;
	}
}
